package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zhanggq
 * @Date 2020/6/4 22:15
 * @Version 1.0
 */
@RestController
public class AppController {

    @RequestMapping("/hello")
    @ResponseBody
    String home(){
        return "Hello,spring security!";
    }
}
