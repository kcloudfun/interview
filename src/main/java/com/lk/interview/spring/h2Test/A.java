package com.lk.interview.spring.h2Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 由于本项目的初衷是为了方便测试，所以在数据库方面选择不需要安装的h2数据库。
 * 1.添加pom依赖（主要是h2自身依赖，jpa是因为顺带要使用的）；
 * 2.添加初始化的sql脚本（schema.sql、data.sql）；
 * 3.添加数据源配置、jpa配置（数据库文件有文件模式和内存模式两种，这里由于都是临时数据，直接使用内存模式jdbc:h2:mem:）
 * 4.添加实体类及Repository
 */
@RestController(value = "h2TestController")
public class A {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/h2test/insert")
    public String insert(){
        Student student = new Student();
        student.setUserId(1);
        student.setUserName("赵日天");
        //这里save方法实际是有更新的逻辑的，所以会把初始化的数据覆盖掉
        studentRepository.save(student);
        return "插入成功";
    }

    @GetMapping("/h2test/query")
    public List<Student> query(){
        List<Student> list = studentRepository.findAll();
        return list;
    }
}
