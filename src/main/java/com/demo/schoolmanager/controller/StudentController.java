package com.demo.schoolmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.schoolmanager.entity.Course;
import com.demo.schoolmanager.entity.Sc;
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
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    //获取全部课程信息
    @RequestMapping("/student_index/course_selection/getAllCourse")
    public @ResponseBody
    String findAll() {

        List<Course> courses = studentService.selectAllCourse();
        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("courses", courses);

        return JSONObject.toJSONString(resultMap);
    }

    //获取未选的课程信息
    @RequestMapping("/student_index/course_selection/getUnSelectedCourse")
    public @ResponseBody
    String getUnSelectedCourse(HttpSession session) {

        Integer student_id = Integer.parseInt(session.getAttribute("userid").toString());

        List<Course> allcourses = studentService.selectAllCourse();
        List<Course> selectedcourses = studentService.selectCourseByStudentId(student_id);
        //allcourses.removeAll(selectedcourses);//用所有课程减去已选课程removeAll只能用于基本数据类型
        //比较主键course_id,相同即删去
        for(int i = 0;i < allcourses.size(); i ++){
            for(int j = 0;j < selectedcourses.size(); j ++){
                if (allcourses.get(i).getCourseId() == selectedcourses.get(j).getCourseId())
                    allcourses.remove(allcourses.get(i));
            }
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("courses", allcourses);

        return JSONObject.toJSONString(resultMap);
    }

    //选课后向添加选课信息
    @RequestMapping("/student_index/course_selection/insert")
    public @ResponseBody
    String insert(Integer course_id,HttpSession session) {


        Integer student_id = Integer.parseInt(session.getAttribute("userid").toString());

        int result = studentService.insert(student_id,course_id);
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

    //获取已经选课的课程信息
    @RequestMapping("/student_schedule/getSelectedCourse")
    public @ResponseBody
    String getSelectedCourse(HttpSession session) {

        Integer student_id = Integer.parseInt(session.getAttribute("userid").toString());
        List<Course> courses = studentService.selectCourseByStudentId(student_id);
        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("courses", courses);

        return JSONObject.toJSONString(resultMap);
    }

    //退课，在sc表中删除已经选课的课程信息
    @RequestMapping("/student_schedule/delete")
    public @ResponseBody
    String deleteSc(Integer course_id,HttpSession session) {

        Integer student_id = Integer.parseInt(session.getAttribute("userid").toString());
        int result = studentService.delete(student_id,course_id);

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

        //resultMap.put("info", result);

        return JSONObject.toJSONString(resultMap);
    }



}
