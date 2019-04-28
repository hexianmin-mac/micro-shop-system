package org.hxm.microsys.core.controller;

import net.sf.json.JSONObject;
import org.hxm.microsys.core.entity.SysUser;
import org.hxm.microsys.core.entity.User;
import org.hxm.microsys.core.service.IUserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Resource
    private IUserService userService;



    // 登录验证
    @ResponseBody
    @RequestMapping("login")
    public String login(HttpSession session, String requestDate) {
        Map<String,String> resultMap = new HashMap<>();
        JSONObject requestJson = JSONObject.fromObject(requestDate);
        SysUser sysUser = userService.login(requestJson.getString("name"),requestJson.getString("password"));
        if (null == sysUser) {
            resultMap.put("result","error");
            JSONObject jsonObject = JSONObject.fromObject(resultMap);
            return jsonObject.toString();
        }
        if (sysUser.getType() != 0) {
            resultMap.put("result","denied");
            JSONObject jsonObject = JSONObject.fromObject(resultMap);
            return jsonObject.toString();
        }
        if (sysUser.getStatus() == 1) {
            resultMap.put("result"," frozen");
            JSONObject jsonObject = JSONObject.fromObject(resultMap);
            return jsonObject.toString();
        }
        session.setAttribute("sysUser",sysUser);
        resultMap.put("result","success");
        JSONObject jsonObject = JSONObject.fromObject(resultMap);
        return jsonObject.toString();
    }


    @RequestMapping("homePage")
    public String homePage(User u,HttpSession session,Model model) {
        SysUser user = (SysUser) session.getAttribute("sysUser");
        int type = user.getType();
        if (type == 0) {
            List<User> allUser = userService.findAllUser();
            model.addAttribute("userList",allUser);
            return "admin/index";
        }
        return null;
    }

    @RequestMapping("forwardUpdate")
    public String forwardUpdate() {
        return "admin/updateUser";
    }


    @RequestMapping(value="likeUser", method=RequestMethod.POST)
    public String findUser(@RequestParam("name") String name, Model model) {
        List<User> likeUser = userService.findUserByName(name);
        model.addAttribute("userList",likeUser);
        return "admin/index";
    }

    @RequestMapping("forwardEdit")
    public String forwardEdit(@RequestParam(value = "userId") int userId, Model mode) {
        User editUser = userService.findUserById(userId);
        mode.addAttribute("user",editUser);
        return "admin/editUser";
    }

    @RequestMapping("updateUser")
    public String updateUser(User user) {
        return "admin/index";
    }


}
