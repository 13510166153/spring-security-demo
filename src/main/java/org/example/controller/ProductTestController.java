package org.example.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zhanggq
 * @Date 2020/6/4 22:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductTestController {

    @RequestMapping("/info")
    @ResponseBody
    public String productInfo() {
        String currentUser = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            currentUser = ((UserDetails) principal).getUsername();
        } else {
            currentUser = principal.toString();
        }
        return "Some product info!,currentUser is: "+currentUser;
    }
}
