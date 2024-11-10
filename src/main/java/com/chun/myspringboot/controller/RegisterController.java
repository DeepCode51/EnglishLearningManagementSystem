package com.chun.myspringboot.controller;

import com.chun.myspringboot.pojo.User;
import com.chun.myspringboot.service.Impl.SendEmailImpl;
import com.chun.myspringboot.service.Impl.UserServiceImpl;
import com.chun.myspringboot.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SendEmailImpl sendEmail;


    //进行注册
    @RequestMapping("/register")
    public String register(User user,Model model){
        //激活状态为0
        user.setActiveStatus(0);
        //得到一个UUID
        String activeCode = IDUtils.getUUID();
        user.setActiveCode(activeCode);
        //加入到数据库
        userService.addUser(user);
        System.out.println("增加成功");
        //发送邮件激活
        String email = user.getEmail();
        String subject = "来自StudyEnglish网站的激活邮件";
        String context = "<a href=\"http://localhost:8080/user/checkCode?activeCode="+activeCode+"\">激活请点击:"+activeCode+"</a>";
        sendEmail.SendEmail(email,subject,context);
        //回到主页面给用户提示
        model.addAttribute("msg","注册成功请去邮箱中激活");
        return "index";
    }

    //验证激活码 登录
    @RequestMapping("/user/checkCode")
    public String active(String activeCode,Model model){
        //查询这个激活码
        User user = userService.queryUserByActiveCode(activeCode);
        if (user != null)
        {   model.addAttribute("msg","恭喜你激活成功，现在可以立即登录");
            //给这个用户激活
            user.setActiveStatus(1);
            //把激活码清除
            user.setActiveCode(" ");
            userService.updateUser(user);
        }
        return "index";
    }

    //去忘记密码页面
    @RequestMapping("/toforget")
    public String toForget(){
        return "user/register/page-forget";
    }
}
