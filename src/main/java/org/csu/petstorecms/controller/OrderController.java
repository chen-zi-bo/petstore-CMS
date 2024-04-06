package org.csu.petstorecms.controller;
import org.csu.petstorecms.common.CommonResponse;
import org.csu.petstorecms.entity.Order;
import org.csu.petstorecms.service.impl.OrderServiceImpl;
import org.csu.petstorecms.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/orderlist")
    public CommonResponse<Object> getAllOrder(HttpServletRequest httpServletRequest){
        String username= JWTUtils.verify(httpServletRequest);
        return orderService.getAllOrderlist();
    }
    @PostMapping("/neworder")
    public CommonResponse<Object> addOrder(@RequestBody Order order, HttpServletRequest httpServletRequest){
        String username=JWTUtils.verify(httpServletRequest);
        return orderService.addOrder(order);
    }
    @PostMapping("/updateorder")
    public CommonResponse<Object> updateOrder(@RequestBody Order order,HttpServletRequest httpServletRequest){
        String username=JWTUtils.verify(httpServletRequest);
        return orderService.updateOrder(order);
    }
    @PostMapping("/removeorder")
    public CommonResponse<Object> removeOrder(@RequestBody Map order,HttpServletRequest httpServletRequest){
        String username=JWTUtils.verify(httpServletRequest);
        int orderid= (int) order.get("orderid");
        return orderService.removeOrder(orderid);
    }

}
