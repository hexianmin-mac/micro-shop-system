package org.hxm.microsys.core.controller;

import org.hxm.microsys.core.entity.OrderInfo;
import org.hxm.microsys.core.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/order/")
public class OrderController {

    @Resource
    private IOrderService orderService;


    @RequestMapping("showAll")
    public String getAllOrder(Model model) {
        List<OrderInfo> orderList = orderService.findAllOrder();
        model.addAttribute("orderList",orderList);
        return "admin/showOrder";
    }

    public String inserOrUpdate(OrderInfo orderInfo, Model model) {
        return "showAll";
    }

    public String getUserAll(@RequestParam(value = "userId") int userId, Model model) {
        List<OrderInfo> orderList = orderService.findOrderByUserId(userId);
        model.addAttribute("orderList",orderList);
        return "admin/showOrder";
    }
}
