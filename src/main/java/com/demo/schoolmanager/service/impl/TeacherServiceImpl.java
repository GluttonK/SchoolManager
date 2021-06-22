package com.demo.schoolmanager.service.impl;

import com.demo.schoolmanager.dao.*;
import com.demo.schoolmanager.entity.Sc;
import com.demo.schoolmanager.entity.ScKey;
import com.demo.schoolmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

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
    public List<Sc> selectScByTeacherId(int teacher_id) {
        return scMapper.selectByTeacherId(teacher_id);
    }

    @Override
    public List<Sc> selectScByCourseIdAndTeacherId(int course_id, int teacher_id) {
        return scMapper.selectByCourseIdAndTeacherId(course_id,teacher_id);
    }

    @Override
    public int update(int student_id, int course_id, int student_grade) {
        Sc sc =new Sc();
        ScKey sckey = new ScKey();
        sckey.setCourseId(course_id);
        sckey.setStudentId(student_id);

        sc.setStudentId(student_id);
        sc.setCourseId(course_id);
        sc.setCourseName(courseMapper.selectByPrimaryKey(course_id).getCourseName());
        sc.setCourseScore(courseMapper.selectByPrimaryKey(course_id).getCourseScore());
        sc.setStudentGrade(student_grade);
        sc.setStudentName(studentMapper.selectByPrimaryKey(student_id).getStudentName());
        sc.setTeacherId(scMapper.selectByPrimaryKey(sckey).getTeacherId());
        sc.setTeacherName(teacherMapper.selectByPrimaryKey(scMapper.selectByPrimaryKey(sckey).getTeacherId()).getTeacherName());

        return scMapper.updateByPrimaryKeySelective(sc);
    }

    @Override
    public String selectTeacherNameByTeacherId(Integer teacher_id) {
        return teacherMapper.selectByPrimaryKey(teacher_id).getTeacherName();
    }
}
