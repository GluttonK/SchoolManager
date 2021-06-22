package com.demo.schoolmanager.service;

import com.demo.schoolmanager.entity.Course;

import java.util.List;

public interface AdminService {
    //从Course表中获取所有课程信息
    List<Course> selectAllCourse();
    //向Course表中新增课程信息
    int create(Course course);
    //在Course表中修改课程信息
    int update(Course course);
    //在Course表中删除课程信息
    int delete(int course_id);
}
