package com.test.dao;

import com.test.domain.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GoodTypeRepository extends JpaRepository<GoodsType,Integer>, CrudRepository<GoodsType,Integer> {

}
