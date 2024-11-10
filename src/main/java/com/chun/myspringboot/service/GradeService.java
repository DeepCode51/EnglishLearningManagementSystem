package com.chun.myspringboot.service;

import com.chun.myspringboot.pojo.Grade;

import java.util.List;

public interface GradeService {
    //根据ID查询一等级的信息
    Grade queryGradeById(Integer gradeId);
    //增加等级
    int addGrade(Grade grade);
    //删除等级
    int deleteGrade(Integer gradeId);
    //修改等级
    int updateGrade(Grade grade);
    //查看等级所有信息
    List<Grade> queryAllGrade();
}
