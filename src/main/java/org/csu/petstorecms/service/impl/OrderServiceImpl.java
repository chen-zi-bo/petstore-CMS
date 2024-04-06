package org.csu.petstorecms.service.impl;

import org.csu.petstorecms.DAO.OrderMapper;
import org.csu.petstorecms.common.CommonResponse;
import org.csu.petstorecms.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {
    @Autowired
    OrderMapper orderMapper;

    public CommonResponse<Object> getAllOrderlist()
    {
        List<Order> ordersList=orderMapper.selectList(null);
        if(ordersList.size()==0){
            return CommonResponse.createForFailure("无订单信息");
        }
        return CommonResponse.createForSuccess(ordersList);
    }

    public CommonResponse<Object> addOrder(Order order) {
        Order order1=orderMapper.selectById(order.getOrderid());
        if(order1!=null){
            return CommonResponse.createForFailure("订单已存在");
        }
        else{
            orderMapper.insert(order);
            return CommonResponse.createForSuccessMessage("添加成功");
        }
    }

    public CommonResponse<Object> updateOrder(Order order) {
        Order order1=orderMapper.selectById(order.getOrderid());
        if(order1!=null){
            orderMapper.updateById(order);
            return CommonResponse.createForSuccessMessage("修改成功");
        }
        else{
            return CommonResponse.createForFailure("修改失败");
        }
    }

    public CommonResponse<Object> removeOrder(int orderid) {
        Order order=orderMapper.selectById(orderid);
        if(order!=null){
            orderMapper.deleteById(orderid);
            return CommonResponse.createForSuccessMessage("删除成功");
        }
        else{
            return CommonResponse.createForFailure("删除失败");
        }
    }
}
