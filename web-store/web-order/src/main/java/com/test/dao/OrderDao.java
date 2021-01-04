package com.test.dao;


import com.test.domain.Orders;
import com.test.domain.dto.CarData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderDao {
    @Select("select * from orders where user_id=#{id} and status=0")
    List<Orders> getAllOrdersByUId(int uId);

    @Select("select * from orders where order_id=#{id} and status=0")
    Orders getOrderById(int id);

    @Update("update orders set num = #{num}  where order_id=#{order_id}")
    void updateOrders(Orders orders);

    @Insert("insert  into orders(goods_id,user_id,price,num) values (#{goods_id},#{user_id},#{price},#{num})")
    void insertOrder(Orders orders);

    @Select("select  o.order_id,g.title,o.price,o.creatTime from orders as o,g_goods as g  where o.user_id=#{id} and o.goods_id=g.id order by o.creatTime desc ")
    List<CarData> findCarDataByUid(int uid);


    @Select("select * from orders where goods_id=#{goods_id} and user_id=#{user_id} and status=0")
    Orders findOrderByGoodsIdAndUserId(Orders orders);
}