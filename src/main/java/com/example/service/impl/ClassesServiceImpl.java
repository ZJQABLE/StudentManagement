package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mapper.ClassesMapper;
import com.example.mapper.StudentsMapper;
import com.example.pojo.Classes;
import com.example.pojo.Students;
import com.example.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public void selectStudentByTeacherName(String teacherName) {
        LambdaQueryWrapper<Classes> lqw = new LambdaQueryWrapper<>();
        lqw.like(Classes::getCTeacher,teacherName);
        Classes classes = classesMapper.selectOne(lqw);
        String className = classes.getCClass();

        LambdaQueryWrapper<Students> lqw2 =new LambdaQueryWrapper<>();
        lqw2.like(Students::getSClass,className);
        List<Students> stuListByTeacher = studentsMapper.selectList(lqw2);
        int count = stuListByTeacher.size();

        System.out.println("【"+teacherName+"】"+"教的学生有"+count+"名，分别是：");
        System.out.println("=======================================");
        stuListByTeacher.forEach(System.out::println);
    }
}
