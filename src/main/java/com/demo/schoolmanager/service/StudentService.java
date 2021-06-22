package com.demo.schoolmanager.service;

import com.demo.schoolmanager.entity.Course;
import com.demo.schoolmanager.entity.Sc;

import java.util.List;

public interface StudentService {
    //从Course表中获取所有课程信息
    List<Course> selectAllCourse();
    //根据course_id从course表中查询course_name
    List<Course> selectCourseByCourseId(int course_id);
    //根据学生id从SC表中查询已选课程信息
    List<Course> selectCourseByStudentId(int student_id);
    //选课 向SC表中新增已选课程
    int insert(Integer student_id,Integer course_id);
    //根据courseId从SC表中查询对应的教师id
    List<Integer> selectTeacherIdByCourseId(int course_id);
    //根据course_id和student_id删除sc表中的信息
    int delete(Integer student_id,Integer course_id);
}
