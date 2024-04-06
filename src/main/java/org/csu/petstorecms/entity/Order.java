package org.csu.petstorecms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("orders")
public class Order {
    @TableId("orderid")
    private int orderid;
    @TableField("userid")
    private String userid;
    @TableField("orderdate")
    private Date orderdate;
    @TableField("shipaddr1")
    private String shipfromadd;
    @TableField("shipzip")
    private String shipfromzip;
    @TableField("courier")
    private String courier;
    @TableField("billaddr1")
    private String shiptoadd;
    @TableField("billtofirstname")
    private String realfirstname;
    @TableField("billtolastname")
    private String reallastname;
    @TableField("creditcard")
    private String creditcard;
    @TableField("totalprice")
    private double totalprice;
}
