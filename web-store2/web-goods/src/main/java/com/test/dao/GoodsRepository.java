package com.test.dao;

import com.test.domain.Goods;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GoodsRepository  extends JpaRepository<Goods,Integer>, CrudRepository<Goods,Integer> {
    @Query(value="select g from Goods g where g.typeId=?1")
    List<Goods> findGoodsByType(int goodType);


    @Query(value="select g from Goods g where g.title like concat('%',?1,'%')")
    List<Goods> findGoodsByName(String name);

    @Query(value="select g from Goods g where g.id=?1")
    Goods findGoodsById(int id);
}
