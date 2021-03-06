package com.test.controller;

import com.test.domain.Goods;
import com.test.domain.GoodsType;

import com.test.result.Result;
import com.test.service.GoodService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tong
 */
@RestController
@Api("商品模块")
public class GoodsController {

    @Autowired
    GoodService goodService;

    @ApiOperation(value = "显示所有商品信息", notes = "商品信息notes")
    @GetMapping(value = "/goodInfo")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "goodsType", value = "商品类型", defaultValue = "1", required = true)
    )
    public Result showAllGoodsInfo(Integer goodsType) {
        List<Goods> goods = goodService.showAllGoods(goodsType);
        return goods.size() > 0 ? Result.success(goods) : Result.fail500(null);
    }


    @ApiOperation(value = "显示所有商品类型", notes = "显示所有商品类型notes")
    @GetMapping(value = "/goodsTypeInfo")
    public Result showAllGoodsTypeInfo() {
        List<GoodsType> goodsTypeList = goodService.showAllGoodsType();
        return goodsTypeList.size() > 0 ? Result.success(goodsTypeList) : Result.fail500(null);
    }
}
