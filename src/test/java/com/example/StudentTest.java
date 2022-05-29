package com.example;

import com.example.mapper.StudentsMapper;
import com.example.pojo.Students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentsMapper studentsMapper;

    @Test
    public void insertStuTest(){
        Students stu = new Students();
        stu.setSName("ss");
        stu.setSSex("男");
        stu.setSAge(43);
        stu.setSTel("123456");
        stu.setSClass("计算机1班");
        int insert = studentsMapper.insert(stu);
        System.out.println(insert);
    }

}
