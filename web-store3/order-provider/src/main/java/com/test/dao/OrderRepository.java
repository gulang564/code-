package com.test.dao;


import com.test.domain.Orders;
import com.test.dto.CarData;
import com.test.dto.OrderDto;
import com.test.vo.OrderVo;
import org.junit.jupiter.api.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer>, CrudRepository<Orders, Integer> {
    @Query(value = "select o from Orders o  where o.userId=?1  and  o.status=0")
    List<Orders> getAllOrdersByUId(int uId);

    @Query(value = "select o from Orders o where o.id=?1 and o.status=0")
    Orders getOrderById(int id);

    @Modifying
    @Query(value = "update Orders set num = :#{#orders.num}  where id=:#{#orders.id}")
    void updateOrders(Orders orders);

    @Query(value = "select  o.id,g.title,o.price,o.createTime from Orders as o,Goods as g  where o.userId= ?1 and o.goodsId=g.id order by o.createTime desc ")
    List<CarData> findCarDataByUid(int uid);

    @Query("select o from Orders o where o.goodsId=:#{#orders.goodsId} and o.userId=:#{#orders.userId} and o.status=0")
    Orders findOrderByGoodsIdAndUserId(Orders orders);
}
