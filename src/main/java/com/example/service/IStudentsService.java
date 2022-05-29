package com.example.service;


import com.example.pojo.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentsService {

    //查询所有学生列表
    List<Students> selectAllStuList();

    //按id查询
    void selectById(Integer sid);

    //模糊查询学生信息
    void selectStuByLike(String likeStr);

    //根据学科查
    void selectStuBySub(String str);

    //按老师查
    void deleteStuByTeacher(String str);

}
