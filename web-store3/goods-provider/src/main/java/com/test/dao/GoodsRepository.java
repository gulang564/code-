package com.test.dao;

import com.test.domain.Goods;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@CacheConfig(cacheNames = "goods_cache")
public interface GoodsRepository extends JpaRepository<Goods, Integer>, CrudRepository<Goods, Integer> {
    @Cacheable(key = "'good_'+#goodType")
    @Query(value = "select g from Goods g where g.typeId=?1")
    List<Goods> findGoodsByType(int goodType);


    @Cacheable(key = "'good_'+#name")
    @Query(value = "select g from Goods g where g.title like ?1")
    List<Goods> findGoodsByName(String name);

    @Cacheable(key = "'good_'+#id", unless = "#result==null")  //unless="#result==null" 剔除掉null值
    @Query(value = "select g from Goods g where g.id=?1")
    Goods findGoodsById(int id);
}
