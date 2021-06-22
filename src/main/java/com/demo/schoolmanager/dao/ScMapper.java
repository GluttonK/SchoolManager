package com.demo.schoolmanager.dao;

import com.demo.schoolmanager.entity.Sc;
import com.demo.schoolmanager.entity.ScKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScMapper {
    int deleteByPrimaryKey(ScKey key);

    int insert(Sc record);

    int insertSelective(Sc record);

    Sc selectByPrimaryKey(ScKey key);

    List<Sc> selectByStudentId(Integer student_id);

    List<Sc> selectByTeacherId(Integer teacher_id);

    List<Sc> selectByCourseIdAndTeacherId(Integer course_id,Integer teacher_id);

    List<Sc> selectByCourseId(Integer course_id);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);
}