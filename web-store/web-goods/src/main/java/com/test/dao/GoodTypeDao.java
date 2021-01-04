package com.test.dao;


import com.test.domain.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface GoodTypeDao {
    @Select("select * from goods_type")
    List<GoodsType> getAllGoodType();
}
