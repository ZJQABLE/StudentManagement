package com.example.controller;

import com.example.pojo.Students;
import com.example.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.xml.soap.SAAJResult;

@RestController
@RequestMapping("/stu")
@EnableWebMvc
public class StudentsController {

    @Autowired
    private IStudentsService studentsService;

    @GetMapping("/selectall")
    public String selectAll(){
        studentsService.selectAllStuList();
        return "ok";
    }

    @GetMapping("/selbyid")
    public String selById(){
        studentsService.selectById(101);
        return "ok";
    }


    @GetMapping("/selectbylike")
    public String selectByLike(){
        studentsService.selectStuByLike("男");
        return "ok";
    }


    @GetMapping("/delstu")
    public String delStu(){
        studentsService.selectStuBySub("英语");
        return "ok";
    }

    @GetMapping("/delbyteacher")
    public String delStuByT(){
        studentsService.deleteStuByTeacher("丁老师");
        return "ok";
    }

}
