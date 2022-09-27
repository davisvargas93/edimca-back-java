package com.edimca.backedimca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edimca.backedimca.models.loginModel;



@CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
@RestController
@RequestMapping(value= "api/v1/")
public class login {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping(path = "/validUser")
    public boolean  prueba(@RequestBody loginModel login_in ){
        String sql = "SELECT * FROM users WHERE email = '"+login_in.user+"';";
        System.out.println(sql);
        loginModel user = jdbcTemplate.queryForObject( 
            sql, 
            new BeanPropertyRowMapper<loginModel>(loginModel.class));
        System.out.println(user.password.equals( login_in.password));
        boolean valid = false;
        if (user.password.equals( login_in.password)) {
            valid = true;
        }
        return  valid;
    }
}
