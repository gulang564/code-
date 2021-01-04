package com.test.dao;

import com.test.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {
    @Select("select * from g_goods where typeid=#{goodType}")
    List<Goods> findGoodsByType(int goodType);

    @Select("select * from g_goods where title like #{name}")
    List<Goods> findGoodsByName(String name);

    @Select("select * from g_goods where id=#{id}")
    Goods findGoodsById(int id);
}
