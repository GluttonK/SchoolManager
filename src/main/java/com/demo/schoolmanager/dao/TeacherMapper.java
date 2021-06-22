package com.demo.schoolmanager.dao;

import com.demo.schoolmanager.entity.Admin;
import com.demo.schoolmanager.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherId);

    Teacher selectByIdAndPwd(Integer teacher_id, String teacher_password);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}