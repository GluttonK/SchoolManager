package com.demo.schoolmanager.service.impl;

import com.demo.schoolmanager.dao.*;
import com.demo.schoolmanager.entity.Course;
import com.demo.schoolmanager.entity.Sc;
import com.demo.schoolmanager.entity.ScKey;
import com.demo.schoolmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

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
    public List<Course> selectCourseByCourseId(int course_id) {
        return null;
    }

    @Override
    public List<Course> selectCourseByStudentId(int student_id) {
        List<Sc> scs = scMapper.selectByStudentId(student_id);
        List<Course> courses = new ArrayList<Course>();

        for(int i = 0;i < scs.size(); i ++){
            courses.add(courseMapper.selectByPrimaryKey(scs.get(i).getCourseId()));
        }
        return courses;
    }

    @Override
    public int insert(Integer student_id,Integer course_id) {
        Sc sc =new Sc();
        ScKey sckey = new ScKey();
        sckey.setCourseId(course_id);
        sckey.setStudentId(student_id);

        sc.setStudentId(student_id);
        sc.setCourseId(course_id);
        sc.setCourseName(courseMapper.selectByPrimaryKey(course_id).getCourseName());
        sc.setCourseScore(courseMapper.selectByPrimaryKey(course_id).getCourseScore());
        sc.setStudentGrade(0);
        sc.setStudentName(studentMapper.selectByPrimaryKey(student_id).getStudentName());
        sc.setTeacherId(courseMapper.selectByPrimaryKey(course_id).getTeacherId());
        sc.setTeacherName(teacherMapper.selectByPrimaryKey(courseMapper.selectByPrimaryKey(course_id).getTeacherId()).getTeacherName());

        return scMapper.insert(sc);
    }

    @Override
    public List<Integer> selectTeacherIdByCourseId(int course_id) {
        List<Sc> scs = scMapper.selectByCourseId(course_id);
        List<Integer> teacherIds = new ArrayList<Integer>();

//        for(int i = 0;i < scs.size(); i ++){
//            teacherIds.add(scMapper.selectByCourseId(scs.get(i).getTeacherId()));
//        }

        return  teacherIds;
    }

    @Override
    public int delete(Integer student_id, Integer course_id) {
        ScKey sckey = new ScKey();
        sckey.setStudentId(student_id);
        sckey.setCourseId(course_id);

        return scMapper.deleteByPrimaryKey(sckey);
    }
}
