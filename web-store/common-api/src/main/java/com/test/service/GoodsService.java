package com.test.service;

import com.test.domain.Goods;

import java.util.List;

public interface GoodsService {
     List<Goods> findGoodsByType(int goodType);
     List<Goods> findGoodsByName(String name);
     public Goods findGoodsById(int id);
}
