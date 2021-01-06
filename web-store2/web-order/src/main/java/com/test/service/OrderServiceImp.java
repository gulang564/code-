package com.test.service;

import com.test.dao.OrderRepository;
import com.test.domain.Orders;
import com.test.dto.CarData;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp  implements OrderService{
    @Autowired
    OrderRepository orderDao;

    @Override
    public List<Orders> getAllOrdersByUId(int uId){
        return orderDao.getAllOrdersByUId(uId);
    }
    @Override
    public Optional<Orders> getOrderById(int id){
        return   orderDao.findById(id);
    }
    @Override
    public  void updateOrders(Orders orders){
        orderDao.updateOrders(orders);
    }
    @Override
    public void insertOrder(Orders orders){
        orderDao.save(orders);
    }

    @Override
    public List<CarData> findCarDataByUid(int uid){
        return orderDao.findCarDataByUid(uid);
    }

    @Override
    public   Orders findOrderByGoodsIdAndUserId(Orders orders){
        return orderDao.findOrderByGoodsIdAndUserId(orders);
    }
}
