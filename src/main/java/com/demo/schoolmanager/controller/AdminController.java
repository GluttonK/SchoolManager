package com.demo.schoolmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.schoolmanager.entity.Course;
import com.demo.schoolmanager.service.AdminService;
import com.demo.schoolmanager.service.StudentService;
import com.demo.schoolmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin_index/getAllCourse")
    public @ResponseBody
    String findAll() {

        List<Course> courses = adminService.selectAllCourse();
        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("courses", courses);

        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("admin_index/course_updation/update")
    public @ResponseBody
    String update(Integer course_id,String course_name,Integer course_score,Integer teacher_id) {


        Course course = new Course();
        course.setCourseId(course_id);
        course.setCourseName(course_name);
        course.setCourseScore(course_score);
        course.setTeacherId(teacher_id);
        course.setTeacherName(teacherService.selectTeacherNameByTeacherId(teacher_id));

        int result = adminService.update(course);
        HashMap<String, Object> resultMap = new HashMap<>();

        switch (result) {
            case 0:
                resultMap.put("info", "产品名称重复！");
                break;
            case 1:
                resultMap.put("info", "修改成功！");
                break;
            default:
                resultMap.put("info", "修改失败！");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("/admin_index/delete")
    public @ResponseBody
    String delete(Integer course_id) {


        int result = adminService.delete(course_id);
        HashMap<String, Object> resultMap = new HashMap<>();

        switch (result) {
            case 0:
                resultMap.put("info", "产品名称重复！");
                break;
            case 1:
                resultMap.put("info", "修改成功！");
                break;
            default:
                resultMap.put("info", "修改失败！");
        }

        return JSONObject.toJSONString(resultMap);
    }



}
