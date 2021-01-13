package com.test.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.dao.OrderRepository;
import com.test.domain.Orders;
import com.test.domain.QGoods;
import com.test.domain.QOrders;
import com.test.domain.QUser;
import com.test.dto.CarData;
import com.test.dto.OrderDto;
import com.test.vo.OrderVo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderRepository orderDao;


    @Autowired
    private EntityManager entityManager;

    //查询工厂实体
    private JPAQueryFactory queryFactory;

    //实例化控制器完成后执行该方法实例化JPAQueryFactory
    @PostConstruct
    public void initFactory() {
        queryFactory = new JPAQueryFactory(entityManager);
    }


    @Override
    public List<Orders> getAllOrdersByUId(int uId) {
        return orderDao.getAllOrdersByUId(uId);
    }

    @Override
    public Optional<Orders> getOrderById(int id) {
        return orderDao.findById(id);
    }

    @Override
    public void updateOrders(OrderVo ordersVo) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersVo, orders);
        orderDao.updateOrders(orders);
    }

    @Override
    public void insertOrder(Orders orders) {
        orderDao.save(orders);
    }

    @Override
    public List<CarData> findCarDataByUid(int uid) {
        return orderDao.findCarDataByUid(uid);
    }

    @Override
    public List<OrderVo> findOrderByGoodsIdAndUserId(OrderDto orderDto) {

        QOrders orders = QOrders.orders;
        QGoods goods = QGoods.goods;
        //直接返回
        List<OrderVo> collect = queryFactory
                //投影只去部分字段
                .select(
                        orders.id,
                        goods.title,
                        orders.num,
                        orders.price,
                        orders.createTime
                )
                .from(orders, goods)
                //联合查询
                .where(
                        orders.userId.eq(orderDto.getUserId()).and(orders.goodsId.eq(orderDto.getGoodsId()))
                )
                .fetch()
                //lambda开始
                .stream()
                .map(tuple ->
                        //需要做类型转换，所以使用map函数非常适合
                        OrderVo.builder()
                                .id(tuple.get(orders.id))
                                .num(tuple.get(orders.num))
                                .title(tuple.get(goods.title))
                                .price(tuple.get(orders.price))
                                .createTime(tuple.get(orders.createTime))
                                .build()
                )
                .collect(Collectors.toList());

        return collect;
    }
}
