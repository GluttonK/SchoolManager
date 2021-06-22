package com.demo.schoolmanager.service.impl;

import com.demo.schoolmanager.dao.*;
import com.demo.schoolmanager.entity.Course;
import com.demo.schoolmanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ScMapper scMapper;
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<Course> selectAllCourse() {
        return courseMapper.selectAllCourse();
    }

    @Override
    public int create(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public int update(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public int delete(int course_id) {
        return courseMapper.deleteByPrimaryKey(course_id);
    }
}
