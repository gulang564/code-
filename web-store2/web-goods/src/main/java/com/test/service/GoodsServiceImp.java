package com.test.service;

import com.test.dao.GoodsRepository;
import com.test.domain.Goods;
import org.apache.dubbo.config.annotation.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService{
    @Resource
    GoodsRepository goodsDao;

    //@Cacheable(key = "'good_'+#goodType")
    @Override
    public List<Goods> findGoodsByType(int goodType){
        return goodsDao.findGoodsByType(goodType);
    }

    //@Cacheable(key = "'good_'+#name")
    @Override
    public List<Goods> findGoodsByName(String name){
        return goodsDao.findGoodsByName(name);
    }

    //@Cacheable(key = "'good_'+#id")
    @Override
    public Goods findGoodsById(int id){
       return goodsDao.findGoodsById(id);
    }
}
