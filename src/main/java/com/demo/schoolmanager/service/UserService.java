package com.demo.schoolmanager.service;


import com.demo.schoolmanager.entity.Admin;
import com.demo.schoolmanager.entity.Student;
import com.demo.schoolmanager.entity.Teacher;

public interface UserService {
    //登录
    Admin admin_login(int admin_id, String admin_password);
    Student student_login(int student_id, String student_password);
    Teacher teacher_login(int teacher_id, String teacher_password);
}
