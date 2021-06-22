package com.demo.schoolmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.schoolmanager.entity.Admin;
import com.demo.schoolmanager.entity.Student;
import com.demo.schoolmanager.entity.Teacher;
import com.demo.schoolmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;






    @RequestMapping(value = "/admin_login")
    public @ResponseBody
    String admin_login(Integer admin_id, String admin_password, HttpSession session) {
        HashMap<String, Integer> result = new HashMap<>();
        Admin admin = userService.admin_login(admin_id,admin_password);
        if (admin == null) {
            result.put("result", 1);
        } else {
            result.put("result", 2);
            session.setAttribute("userid", admin.getAdminId());
            session.setAttribute("username", admin.getAdminName());
        }
        return JSONObject.toJSONString(result);
    }

    @RequestMapping(value = "/student_login")
    public @ResponseBody
    String student_login(Integer student_id, String student_password, HttpSession session) {
        HashMap<String, Integer> result = new HashMap<>();
        Student student = userService.student_login(student_id,student_password);
        if (student == null) {
            result.put("result", 1);
        } else {
            result.put("result", 2);
            session.setAttribute("userid", student.getStudentId());
            session.setAttribute("username", student.getStudentName());
        }
        return JSONObject.toJSONString(result);
    }

    @RequestMapping(value = "/teacher_login")
    public @ResponseBody
    String teacher_login(Integer teacher_id, String teacher_password, HttpSession session) {
        HashMap<String, Integer> result = new HashMap<>();
        Teacher teacher = userService.teacher_login(teacher_id,teacher_password);
        if (teacher == null) {
            result.put("result", 1);
        } else {
            result.put("result", 2);
            session.setAttribute("userid", teacher.getTeacherId());
            session.setAttribute("username", teacher.getTeacherName());
        }
        return JSONObject.toJSONString(result);
    }






}
