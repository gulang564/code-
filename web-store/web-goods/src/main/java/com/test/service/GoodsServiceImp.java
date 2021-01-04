package com.test.service;

import com.test.dao.GoodsDao;
import com.test.domain.Goods;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService{
    @Resource
    GoodsDao goodsDao;

    @Cacheable(key = "'good_'+#goodType")
    public List<Goods> findGoodsByType(int goodType){
        return goodsDao.findGoodsByType(goodType);
    }

    @Cacheable(key = "'good_'+#name")
    public List<Goods> findGoodsByName(String name){
        return goodsDao.findGoodsByName(name);
    }

    @Cacheable(key = "'good_'+#id")
    public Goods findGoodsById(int id){
       return goodsDao.findGoodsById(id);
    }
}
