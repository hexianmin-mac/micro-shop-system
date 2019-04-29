package org.hxm.microsys.core.service;

import org.hxm.microsys.core.entity.OrderInfo;

import java.util.List;

public interface IOrderService {

    List<OrderInfo> findAllOrder();
    List<OrderInfo> findOrderByUserId(int userId);
    int insertOrUpdate(OrderInfo orderInfo);
}
