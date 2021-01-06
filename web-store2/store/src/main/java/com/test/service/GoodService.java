package com.test.service;

import com.test.domain.Goods;
import com.test.domain.GoodsType;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "goods_cache")
public class GoodService {
    @Reference(interfaceClass = GoodsService.class)
    GoodsService goodsService;

    @Reference(interfaceClass = GoodsTypeService.class)
    GoodsTypeService goodsTypeService;


    /**
    *  @Author: tong
    *  @date: 2021/1/6
    *  @Description: 根据商品类型，显示对应类型的商品
    *  @Param:
    *  @return:
    */
    @Cacheable(key = "#goodsType")
    public List<Goods> showAllGoods(Integer goodsType){
        List<Goods> goodsList= goodsService.findGoodsByType(goodsType);
        return goodsList;
    }


    public List<GoodsType> showAllGoodsType(){
        //这个是第一次请求的时候，需要用的
        Integer goodsTyepId=null;
        List<GoodsType> allGoodType = goodsTypeService.getAllGoodType();
        return allGoodType;
    }
}
