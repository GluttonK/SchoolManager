package com.demo.schoolmanager.service.impl;

import com.demo.schoolmanager.dao.AdminMapper;
import com.demo.schoolmanager.dao.StudentMapper;
import com.demo.schoolmanager.dao.TeacherMapper;
import com.demo.schoolmanager.entity.Admin;
import com.demo.schoolmanager.entity.Student;
import com.demo.schoolmanager.entity.Teacher;
import com.demo.schoolmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Admin admin_login(int admin_id, String admin_password) {
        Admin admin = adminMapper.selectByIdAndPwd(admin_id,admin_password);
        return admin;
    }

    @Override
    public Student student_login(int student_id, String student_password) {
        Student student = studentMapper.selectByIdAndPwd(student_id,student_password);
        return student;
    }

    @Override
    public Teacher teacher_login(int teacher_id, String teacherpassword) {
        Teacher teacher = teacherMapper.selectByIdAndPwd(teacher_id,teacherpassword);
        return teacher;
    }


}
