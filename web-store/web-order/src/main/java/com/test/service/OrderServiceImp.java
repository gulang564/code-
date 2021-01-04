package com.test.service;

import com.test.dao.OrderDao;
import com.test.domain.Orders;
import com.test.domain.dto.CarData;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderServiceImp  implements OrderService{
    @Autowired
    OrderDao orderDao;

    public List<Orders> getAllOrdersByUId(int uId){
        return orderDao.getAllOrdersByUId(uId);
    }
    public  Orders getOrderById(int id){
        return   orderDao.getOrderById(id);
    }
    public  void updateOrders(Orders orders){
        orderDao.updateOrders(orders);
    }
    public void insertOrder(Orders orders){
        orderDao.insertOrder(orders);
    }

    public List<CarData> findCarDataByUid(int uid){
        return orderDao.findCarDataByUid(uid);
    }

    public   Orders findOrderByGoodsIdAndUserId(Orders orders){
        return orderDao.findOrderByGoodsIdAndUserId(orders);
    }
}
