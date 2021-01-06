package com.test.service;


import com.test.dao.GoodTypeRepository;
import com.test.domain.GoodsType;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class GoodsTypeServiceImp implements GoodsTypeService {
    @Autowired
    GoodTypeRepository goodTypeDao;
    @Override
    public List<GoodsType> getAllGoodType(){
        return goodTypeDao.findAll();
    }

}
