package org.hxm.microsys.core.service.impl;

import org.hxm.microsys.core.dao.OrderDao;
import org.hxm.microsys.core.entity.OrderInfo;
import org.hxm.microsys.core.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public List<OrderInfo> findAllOrder() {
        return orderDao.getAllOrderInfo();
    }

    @Override
    public List<OrderInfo> findOrderByUserId(int userId) {
        return orderDao.getOrderByUserId(userId);
    }

    @Override
    public int insertOrUpdate(OrderInfo orderInfo) {
        return orderDao.insertOrUpdate(orderInfo);
    }


}
