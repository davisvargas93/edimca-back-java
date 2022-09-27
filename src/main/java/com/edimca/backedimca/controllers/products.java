package com.edimca.backedimca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edimca.backedimca.models.product;
import com.edimca.backedimca.persistence.conectionDB;
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
@RestController
@RequestMapping(value= "api/v1/")
public class products {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // get products
    @GetMapping(path = "/getProducts")
    public List<product> getProducts(){
        conectionDB c = new conectionDB();
        return c.getProducts(jdbcTemplate); 
    }
    // Create Product
    @PostMapping(path = "/createProduct")
    public int createProduct(@RequestBody product product ){
        conectionDB c = new conectionDB();
        int rows = c.createProduct(jdbcTemplate,product); 
        return rows; 
    }
    
}
