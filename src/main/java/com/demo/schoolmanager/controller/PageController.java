package com.demo.schoolmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @RequestMapping(value = "/")
    public
    String init(){
        return "login";
    }
//上面这个 代表http://localhost:8080/跳转到/index
//  @ResponseBody 无注解返回视图，有注解返回字符串

    @RequestMapping(value = "/to_admin_login")
    public
    String to_admin_login(){
        return "admin_login";
    }

    @RequestMapping(value = "/to_student_login")
    public
    String to_student_login(){
        return "student_login";
    }

    @RequestMapping(value = "/to_teacher_login")
    public
    String to_teacher_login(){
        return "teacher_login";
    }


    //分界线----------------------上面是可以直接访问，下面需要登陆后才能访问-----------------------------------



    @RequestMapping(value = "/index")
    public
    String index(HttpSession session){
        if (session.getAttribute("username") == null) {
            return "login";
        }
        return "index";
    }

    @RequestMapping(value = "/student_index")
    public
    String student_index(HttpSession session){
        if (session.getAttribute("username") == null) {
            return "login";
        }
        return "student_index";
    }

    @RequestMapping(value = "/student_schedule")
    public
    String student_schedule(HttpSession session){
        if (session.getAttribute("username") == null) {
            return "login";
        }
        return "student_schedule";
    }

    @RequestMapping(value = "/admin_index")
    public
    String admin_index(HttpSession session){
        if (session.getAttribute("username") == null) {
            return "login";
        }
        return "admin_index";
    }

    @RequestMapping(value = "/teacher_index")
    public
    String teacher_index(HttpSession session){
        if (session.getAttribute("username") == null) {
            return "login";
        }
        return "teacher_index";
    }

    @RequestMapping(value = "/teacher_class")
    public
    String teacher_class(HttpSession session){
        if (session.getAttribute("username") == null) {
            return "login";
        }
        return "teacher_class";
    }





//HttpSession 用来判断是否 已登录，若未登录则不能访问且跳转到登录页面

}
