package com.ks.eshop.controller;

import com.ks.eshop.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private AdminInfoService adminInfoService;

    @ResponseBody
    @GetMapping("/getSession")
    public String getSession(HttpSession session){
        String admin = (String) session.getAttribute("admin");
        return admin;
    }

    @RequestMapping("/menu_page")
    public String menu(){
        return "menu";
    }

    @RequestMapping("/user_page")
    public String user(){
        return "user";
    }

    @RequestMapping("/admin_page")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/home_page")
    public String home(){
        return "home";
    }

    @RequestMapping("/product_page")
    public String product(){
        return "product";
    }

    @RequestMapping("/productType_page")
    public String productType(){
        return "product_type";
    }

    @RequestMapping("/orderInfo_page")
    public String orderInfo(){
        return "order_info";
    }

    @RequestMapping("/orderCreate_page")
    public String orderCreate(){
        return "order_create";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
    @RequestMapping("/index")
    public String index()  {
        return "index";
    }

    //管理员登录
    @PostMapping("/login")
    public String login()  {
        return "redirect:/index";
    }
}
