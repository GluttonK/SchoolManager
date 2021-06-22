package com.demo.schoolmanager.service;

import com.demo.schoolmanager.entity.Course;
import com.demo.schoolmanager.entity.Sc;
import com.demo.schoolmanager.entity.Student;

import java.util.List;

public interface TeacherService {
    //根据teacher_id从SC表中获取任职的所有课程信息
    List<Sc> selectScByTeacherId(int teacher_id);
    //根据course_id和teacher_id从SC表中获取所有选课学生信息
    List<Sc> selectScByCourseIdAndTeacherId(int course_id, int teacher_id);
    //在SC表中修改学生成绩
    int update(int student_id,int course_id,int student_grade);
    //根据teacherId从teacher表中获取teacherName
    String selectTeacherNameByTeacherId(Integer teacher_id);
}
