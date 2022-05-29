package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mapper.ClassesMapper;
import com.example.mapper.StudentsMapper;
import com.example.pojo.Classes;
import com.example.pojo.Students;
import com.example.service.IStudentsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements IStudentsService {

    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    protected ClassesMapper classesMapper;

    @Override
    public List<Students> selectAllStuList() {
        List<Students> studentsList = studentsMapper.selectList(null);
        studentsList.forEach(System.out::println);
        return studentsList;
    }

    @Override
    public void selectById(Integer sid) {
        studentsMapper.selectById(sid);
    }

    @Override
    public void selectStuByLike(String likeStr) {
        List<Students> studentsAll = studentsMapper.selectList(null);
        int sizeAll = studentsAll.size();
        //模糊查询
        LambdaQueryWrapper<Students> lqw = new LambdaQueryWrapper<Students>();
        lqw.like(Students::getSSex,likeStr);
        List<Students> studentsBoy = studentsMapper.selectList(lqw);
        int sizeBoy = studentsBoy.size();
        int sizeGirl = sizeAll - sizeBoy;

        System.out.println("男："+sizeBoy+"条");
        System.out.println("女："+sizeGirl+"条");

    }

        @Override
    public void selectStuBySub(String str) {

        LambdaQueryWrapper<Classes> lqw = new LambdaQueryWrapper<Classes>();
        lqw.like(Classes::getCSubject,str);
        List<Classes> classesList = classesMapper.selectList(lqw);
        for(int i=0;i<classesList.size();i++){
            String cClass = classesList.get(i).getCClass();
            LambdaQueryWrapper<Students> lqw2 = new LambdaQueryWrapper<Students>();
            lqw2.like(Students::getSClass,cClass);

            List<Students> students = studentsMapper.selectList(lqw2);
            students.forEach(System.out::println);
        }

    }

    @Override
    public void deleteStuByTeacher(String str) {
        LambdaQueryWrapper<Classes> lqw = new LambdaQueryWrapper<Classes>();
        lqw.like(Classes::getCTeacher,str);
        Classes classes = classesMapper.selectOne(lqw);
        String str1 = classes.getCClass();

        LambdaQueryWrapper<Students> lqw2 = new LambdaQueryWrapper<Students>();
        lqw2.like(Students::getSClass,str1);
        int delete = studentsMapper.delete(lqw2);
        System.out.println("删除"+delete);
    }







}
