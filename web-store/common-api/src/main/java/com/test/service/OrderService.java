package com.test.service;

import com.test.domain.Orders;
import com.test.domain.dto.CarData;

import java.util.List;

public interface OrderService {
    List<Orders> getAllOrdersByUId(int uId);

    Orders getOrderById(int id);

    void updateOrders(Orders orders);

    void insertOrder(Orders orders);

    List<CarData> findCarDataByUid(int uid);

    Orders findOrderByGoodsIdAndUserId(Orders orders);
}
