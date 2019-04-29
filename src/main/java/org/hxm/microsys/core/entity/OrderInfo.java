package org.hxm.microsys.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Getter
@Setter
@Alias("OrderInfo")
public class OrderInfo {
    private int orderId;
    private int userId;
    private double inPrice;
    private double outPrice;
    private String fastNumber;
    private Date date;

}
