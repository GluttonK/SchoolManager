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
    public int insert(Integer course_id, String course_name, Integer course_score, Integer teacher_id) {
        Course course = new Course();
        course.setCourseId(course_id);
        course.setCourseName(course_name);
        course.setCourseScore(course_score);
        course.setTeacherId(teacher_id);
        course.setTeacherName(teacherMapper.selectByPrimaryKey(teacher_id).getTeacherName());

        return courseMapper.insert(course);
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
