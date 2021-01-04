package com.test.controller;


import com.test.domain.Goods;
import com.test.domain.User;
import com.test.service.GoodsService;
import com.test.service.GoodsTypeService;
import com.test.service.SearchService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SearchController {
    @Reference
    GoodsService goodsService;
    @Reference
    GoodsTypeService goodsTypeService;

    @RequestMapping(value = "/SearchServlet")
    public String SearchServlet(HttpServletRequest request, HttpServletResponse response){
        String targetVal=request.getParameter("targetVal");
        System.out.println("========》进入查询页面");
        List<Goods> goodsList=null;
        if (targetVal != null){
            goodsList= goodsService.findGoodsByName("%"+targetVal+"%");
        }
        request.setAttribute("goodsList",goodsList);


        System.out.println("输出查询结果====》");
        request.setAttribute("goodTypes",goodsTypeService.getAllGoodType());
        User curUser= (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser",curUser);

        return "index1";
    }
}
