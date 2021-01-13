package com.test.service;

import com.test.domain.Orders;
import com.test.dto.CarData;
import com.test.dto.OrderDto;
import com.test.vo.OrderVo;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Orders> getAllOrdersByUId(int uId);

    Optional<Orders> getOrderById(int id);

    void updateOrders(OrderVo orders);

    void insertOrder(Orders orders);

    List<CarData> findCarDataByUid(int uid);

    List<OrderVo> findOrderByGoodsIdAndUserId(OrderDto orderDto);
}
