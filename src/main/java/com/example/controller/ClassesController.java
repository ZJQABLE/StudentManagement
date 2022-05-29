package com.example.controller;

import com.example.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cla")
public class ClassesController {

    @Autowired
    private IClassesService classesService;

    @GetMapping("/stubyt")
    public String selStuByTea(){
        classesService.selectStudentByTeacherName("丁老师");
        return "ok!";
    }

}
