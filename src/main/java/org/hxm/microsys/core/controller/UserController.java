package org.hxm.microsys.core.controller;

import com.alibaba.fastjson.JSONObject;
import org.hxm.microsys.core.entity.User;
import org.hxm.microsys.core.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Resource
    private IUserService userService;



    // 登录验证
    @ResponseBody
    @RequestMapping("login")
    public String login(User user, HttpSession session, String requestDate) {
        JSONObject requestJson = JSONObject.parseObject(requestDate);
        return null;
    }


    @RequestMapping("/findUser")
    public String findUser(Model model) {
        int id = 1;
        User user = this.userService.findUserById(id);
        model.addAttribute("user", user);
        return "index";
    }
}
