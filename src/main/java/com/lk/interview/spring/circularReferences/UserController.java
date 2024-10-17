package com.lk.interview.spring.circularReferences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private LoginController loginController;

}
