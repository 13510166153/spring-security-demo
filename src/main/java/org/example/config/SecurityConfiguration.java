package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author Zhanggq
 * @Date 2020/6/4 22:24
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/product/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }


    /**
     * 在正式的应用中，我们的用户和角色是保存在数据库中的；本例为了方便演示，我们来创建两个存放于内存的用户和角色。我们在上一步中创建的SecurityConfiguration中增加角色用户，如下代码：
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin1")//管理员，同时具有ADMIN,USER权限 ，可以访问所有资源
//                .password("amdin1")//springboot1.x
                .password("{noop}admin1")
                .roles("ADMIN","USER")
                .and()
                .withUser("user1")
//                .password("user1")
                .password("{noop}user1")
                .roles("USER");
    }
}
