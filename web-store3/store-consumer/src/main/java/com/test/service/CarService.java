package com.test.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.test.domain.Goods;
import com.test.domain.Orders;
import com.test.domain.User;
import com.test.dto.CarData;
import com.test.dto.OrderDto;
import com.test.vo.OrderVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
//该类下面的所有方法，使用的缓存区都时cache_car
//如果不想使用统一的缓存区，在  @Cacheable(cacheNames = )中可以指定相应的缓存区
/*
* @Cacheable(cacheNames = )
  @CacheEvict(cacheNames = )
  @CachePut(cacheNames = )

这三个基本的注解里面都可以指定对应的缓存区。 如果缓存区统一，则使用@CacheConfig(cacheNames = "cache_car") 进行统一
被@CacheConfig 修饰的类下面的 三个基本注解，默认使用同一个缓冲区
* */

public class CarService {
    @Reference(interfaceClass = OrderService.class)
    OrderService orderService;

    @Reference(interfaceClass = GoodsTypeService.class)
    GoodsTypeService goodsTypeService;

    @Reference(interfaceClass = GoodsService.class)
    GoodsService goodsService;

    @Reference(interfaceClass = UserService.class)
    UserService userService;

    public boolean addCar(OrderDto orderDto) {
        OrderVo temp;
        Orders orders = new Orders();
        /*单在一个订单上记录用户信息*/
        try {
            temp = orderService.findOrderByGoodsIdAndUserId(orderDto).get(0);
            if (temp != null) {
                temp.setNum(temp.getNum() + 1);
                orderService.updateOrders(temp);
                return true;
            }
            /*如果用户没有买过这商品则 插入一条记录*/

            BeanUtils.copyProperties(orderDto, orders);
            orders.setNum(1);
            orders.setCreateTime(new Date().getTime());
            orders.setStatus(0);
            orderService.insertOrder(orders);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Map showCar(Integer uId) {
        Map<String, Object> map = new HashMap();
        //获取用户
        List<Orders> ordersList = orderService.getAllOrdersByUId(uId);
        List<CarData> carDataList = new ArrayList();
        CarData carData = null;

        User user = userService.findUserById(uId);
        System.out.println("-------------" + user.toString());
        //计算总价
        double total = 0;
        for (Orders order : ordersList) {
            carData = new CarData();
            carData.setUName(user.getUName());
            carData.setCreateTime(order.getCreateTime());
            carData.setNum(order.getNum());
            Goods goods = goodsService.findGoodsById(order.getGoodsId());
            carData.setTitle(goods.getTitle());
            carData.setId(order.getId());
            /*订单里面存的事商品的单价*/
            carData.setPrice(order.getPrice());
            carData.setRowPrice(order.getPrice() * order.getNum());
            /*计算所有商品的总价*/
            total += order.getPrice() * order.getNum();
            carDataList.add(carData);
        }

        map.put("商品总价", total + "元");
        map.put("所有商品", carDataList);
        return map;
    }

    public boolean updateOrder(Integer orderId, Integer flag) {
        Orders order = orderService.getOrderById(orderId).get();
        if (order != null) {
            if (flag == 0) {
                order.setNum(order.getNum() - 1);
            }
            if (flag == 1) {
                order.setNum(order.getNum() + 1);
            }
        } else {
            return false;
        }
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(order, orderVo);
        orderService.updateOrders(orderVo);
        return true;
    }
}
