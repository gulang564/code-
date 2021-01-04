package com.test.controller;


import com.test.domain.Orders;
import com.test.domain.User;
import com.test.domain.dto.CarData;
import com.test.service.CarService;

import com.test.service.GoodsService;
import com.test.service.GoodsTypeService;
import com.test.service.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CarController {

    @Reference(interfaceClass = OrderService.class)
    OrderService orderService;

    @Reference(interfaceClass = GoodsTypeService.class)
    GoodsTypeService goodsTypeService;

    @Reference(interfaceClass = GoodsService.class)
    GoodsService goodsService;


    @RequestMapping(value = "/addCarServlet")
    public String AddCarServlet(HttpServletRequest request, HttpServletResponse response) {
        int goodsId = Integer.parseInt(request.getParameter("goods_id"));
        double price = Double.parseDouble(request.getParameter("price"));
        User user = (User) request.getSession().getAttribute("currUser");
        int u_id = user.getU_id();

        int id = Integer.parseInt(request.getParameter("typeid"));
        request.setAttribute("typeid", id);
        request.setAttribute("isSuccess", true);

        Orders temp= new Orders();
        temp.setUser_id(u_id);
        temp.setGoods_id(goodsId);

        /*单在一个订单上记录用户信息*/
        temp=orderService.findOrderByGoodsIdAndUserId(temp);
        if (temp!=null){
            temp.setNum(temp.getNum()+1);
            orderService.updateOrders(temp);
            return "forward:/showAllGoodsInfo";
        }

        /*如果用户没有买过这商品则 插入一条记录*/
        System.out.println("====添加购物车====");
        Orders orders ;
        orders = new Orders();
        orders.setGoods_id(goodsId);
        orders.setPrice(price);
        orders.setUser_id(u_id);
        orders.setNum(1);
        orderService.insertOrder(orders);

        return "forward:/showAllGoodsInfo";
    }

    @RequestMapping(value = "/showCarServlet")
    public String showCar(HttpServletRequest request, HttpServletResponse response) {
        Integer uId=null;
        if (request.getParameter("u_id")!=null){
            uId = Integer.parseInt(request.getParameter("u_id"));
        }

        if (uId==null){
            uId= Integer.parseInt(request.getAttribute("u_id").toString());
        }
        List<Orders> ordersList = orderService.getAllOrdersByUId(uId);

        System.out.println("=======》进入购入车");

        request.setAttribute("goodTypes", goodsTypeService.getAllGoodType());
        User user = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", user);

        List<CarData> carDataList = new ArrayList();
        CarData carData = null;

        double total = 0;
        for (Orders order : ordersList) {
            carData = new CarData();
            carData.setU_name(user.getU_name());
            carData.setCreatTime(order.getCreatTime());
            carData.setNum(order.getNum());
            carData.setTitle(goodsService.findGoodsById(order.getGoods_id()).getTitle());
            carData.setOrder_id(order.getOrder_id());
            /*订单里面存的事商品的单价*/
            carData.setPrice(order.getPrice());
            carData.setRowPrice(order.getPrice() * order.getNum());
            /*计算所有商品的总价*/
            total += order.getPrice() * order.getNum();
            carDataList.add(carData);
        }

        for (CarData carData1 : carDataList) {
            System.out.println(carData1);
        }

        request.setAttribute("total", total);
        request.setAttribute("carDataList", carDataList);
        return "index1";
    }

    @RequestMapping(value = "/updateOrder")/*需要商品id 和用户id*/
    public String updateOrder(Orders orders, HttpServletRequest request) {
        System.out.println("============>进入更新区");
        int flag = Integer.parseInt(request.getParameter("flag"));
        orders= orderService.getOrderById(orders.getOrder_id());
        request.setAttribute("u_id",orders.getUser_id());

        /*如果订单存在就直接往这个订单上面添加数据*/
        if (orders.getOrder_id() != null) {
            if (flag == 0) {
                orders.setNum(orders.getNum() - 1);
            }
            if (flag == 1) {
                orders.setNum(orders.getNum() + 1);
            }
            orderService.updateOrders(orders);
        }/*如果没有这个订单，这直接生成一个订单*/
        return "forward:/showCarServlet";
    }
}
