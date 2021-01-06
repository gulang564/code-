package com.test.controller;



import com.test.domain.Orders;
import com.test.result.Result;
import com.test.service.CarService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * @author tong
 */
@RestController
@Api("购物车模块")
public class CarController {
    @Autowired
    CarService carService;

    @ApiOperation(value = "添加购物车",notes = "将选中的数据添加到购物车中")
    @PostMapping(value = "/addCarServlet")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="goodsId" ,value = "商品id",defaultValue = "6",required = true),
            @ApiImplicitParam(name = "price", value = "商品单价", defaultValue = "72", required = true),
            @ApiImplicitParam(name = "userId", value = "用户id", defaultValue = "1", required = true)
    })
    public Result AddCarServlet(HttpServletRequest request,@ApiParam Orders orders) {
        boolean b= carService.addCar(request,orders);
        if (b){
           return Result.success(b);
        }else{
            return Result.fail500(b);
        }
    }

    @ApiOperation(value = "展示购物车",notes = "根据用户id 查看该用户加入购入车的商品")
    @GetMapping(value = "/showCarServlet")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="uId" ,value = "用户id",defaultValue = "1",required = true)
    })
    public Result showCar(Integer uId) {
        Map map = carService.showCar(uId);
        if (map.size()>0){
            return Result.success(map);
        }else{
            return new Result(400,"没有添加购物车",null);
        }
    }

    @ApiOperation(value = "更新订单状态",notes = "更新订单状态")
    @PutMapping(value = "/updateOrder")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="orderId" ,value = "订单id",defaultValue = "1",required = true),
            @ApiImplicitParam(name = "flag", value = "标志位，如果未0 表示减少商品数量，如果为1 表示增加商品数量", defaultValue = "0", required = true)
    })
    public Result updateOrder(@ApiParam("orderId") Integer orderId,@ApiParam("flag")  Integer flag) {
        boolean b = carService.updateOrder(orderId,flag);
        if (b){
            return Result.success(b);
        }else{
            return Result.fail500(b);
        }

    }
}
