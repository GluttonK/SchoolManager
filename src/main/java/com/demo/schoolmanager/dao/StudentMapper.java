package com.demo.schoolmanager.dao;

import com.demo.schoolmanager.entity.Admin;
import com.demo.schoolmanager.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    Student selectByIdAndPwd(Integer student_id, String student_password);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}