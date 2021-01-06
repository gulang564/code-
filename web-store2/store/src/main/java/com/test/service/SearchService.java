package com.test.service;

import com.test.domain.Goods;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tong
 */
@Service
@CacheConfig(cacheNames = "search_cache")
public class SearchService {
    @Reference
    GoodsService goodsService;


    @Cacheable(key = "#targetVal")
    public List<Goods> searchGoods(String targetVal){
        List<Goods> goodsList=null;
        if (targetVal != null){
            goodsList= goodsService.findGoodsByName("%"+targetVal+"%");
        }
         return goodsList;
    }
}
