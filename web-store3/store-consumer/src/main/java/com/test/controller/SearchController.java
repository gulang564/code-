package com.test.controller;


import com.test.domain.Goods;
import com.test.result.Result;
import com.test.service.SearchService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tong
 */
@RestController
@Api("查询模块模块")
@Slf4j
public class SearchController {

    @Autowired
    SearchService searchService;

    @ApiOperation(value = "商品查询", notes = "用户登录notes")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "keyword", value = "输入书名", defaultValue = "万历十五年", required = true)
    )
    @GetMapping(value = "/search")
    public Result SearchServlet(String keyword) {
        List<Goods> goods = searchService.searchGoods(keyword);
        log.info("查询后的商品信息量-------------" + goods.size());
        return Result.success(goods);
    }
}
