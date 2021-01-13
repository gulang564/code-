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
public class SearchService {
    @Reference
    GoodsService goodsService;

    public List<Goods> searchGoods(String keyword) {
        List<Goods> goodsList = null;
        if (keyword != null) {
            goodsList = goodsService.findGoodsByName("%" + keyword + "%");
        }
        return goodsList;
    }
}
