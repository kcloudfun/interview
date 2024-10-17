package com.lk.interview.spring.form;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @PostMapping("/form/accept")
    public String formDataAccept(FormVo vo){
        //这样写法，能接url拼接，也能接请求体表单。应该是框架层面做了处理
        return vo.getName();
    }

    @PostMapping("/form/accept2")
    public String formDataAccept2(String name){
        //这样写法，能接url拼接，也能接请求体表单。应该是框架层面做了处理
        return name;
    }
}
