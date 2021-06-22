package com.demo.schoolmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.schoolmanager.entity.Course;
import com.demo.schoolmanager.entity.Sc;
import com.demo.schoolmanager.service.AdminService;
import com.demo.schoolmanager.service.StudentService;
import com.demo.schoolmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/teacher_index/getTeacherCourse")
    public @ResponseBody
    String getTeacherCourse(HttpSession session) {

        Integer teacher_id = Integer.parseInt(session.getAttribute("userid").toString());

        List<Sc> scs = teacherService.selectScByTeacherId(teacher_id);

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("scs", scs);

        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("/teacher_index/getClassByCourse")
    public @ResponseBody
    String getClassByCourse(HttpSession session,Integer course_id) {

        session.setAttribute("courseid",course_id);

        HashMap<String, Object> resultMap = new HashMap<>();

        if (session.getAttribute("courseid") == null) {
            resultMap.put("result", 1);
        } else {
            resultMap.put("result", 2);

        }
        //resultMap.put("scs", scs);

        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("/teacher_class/getClass")
    public @ResponseBody
    String getClass(HttpSession session) {

        Integer teacher_id = Integer.parseInt(session.getAttribute("userid").toString());
        Integer course_id = Integer.parseInt(session.getAttribute("courseid").toString());

        List<Sc> scs = teacherService.selectScByCourseIdAndTeacherId(course_id,teacher_id);

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("scs", scs);

        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("/teacher_class/update")
    public @ResponseBody
    String update(Integer student_id,Integer course_id,Integer student_grade) {


        int result = teacherService.update(student_id,course_id,student_grade);

        HashMap<String, Object> resultMap = new HashMap<>();

        //resultMap.put("scs", scs);

        return JSONObject.toJSONString(resultMap);
    }

}
