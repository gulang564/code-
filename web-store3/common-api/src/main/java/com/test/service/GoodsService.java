package com.test.service;


import com.test.domain.Goods;

import java.util.List;

/**
 * @author tong
 */
public interface GoodsService {
    List<Goods> findGoodsByType(int goodType);

    List<Goods> findGoodsByName(String name);

    Goods findGoodsById(int id);
}
