package org.hxm.microsys.core.dao;

import org.apache.ibatis.annotations.Param;
import org.hxm.microsys.core.entity.OrderInfo;

import java.util.List;

public interface OrderDao {

    List<OrderInfo> getAllOrderInfo();
    List<OrderInfo> getOrderByUserId(@Param("userId") int userId);
    int insertOrUpdate(@Param("orderInfo") OrderInfo orderInfo);
}
