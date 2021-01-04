package com.test.controller;

;
import com.test.domain.Goods;
import com.test.domain.User;
import com.test.service.GoodsService;
import com.test.service.GoodsTypeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class GoodsController  {
    @Reference(interfaceClass = GoodsService.class)
    GoodsService goodsService;

    @Reference(interfaceClass = GoodsTypeService.class)
    GoodsTypeService goodsTypeService;


    @RequestMapping(value = "/showAllGoodsInfo")
    public String showAllGoodsInfo(HttpServletRequest request, HttpServletResponse response){
        //这个是第一次请求的时候，需要用的
        Integer goodsTyepId=null;

        if (request.getAttribute("typeid")!=null){
            goodsTyepId = Integer.parseInt(request.getAttribute("typeid").toString());
        }

        //其他别的请求都是带参数的方式
        if (goodsTyepId==null){
            goodsTyepId= Integer.parseInt(request.getParameter("typeid")) ;
        }

        List<Goods> goodsList= goodsService.findGoodsByType(goodsTyepId);
        request.setAttribute("goodsList",goodsList);
        for (Goods goods:goodsList){
            System.out.println(goods);
        }

        request.setAttribute("goodTypes",goodsTypeService.getAllGoodType());
        User curUser= (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser",curUser);

        System.out.println("----------------------------转发跳转到此处-----------------------");
        return "index1";
    }
}
