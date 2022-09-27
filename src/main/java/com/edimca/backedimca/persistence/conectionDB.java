package com.edimca.backedimca.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.edimca.backedimca.models.product;
import com.edimca.backedimca.models.purchaseDetail;
import com.edimca.backedimca.models.purchaseHeader;
@Service
public class conectionDB {


    public  List<product>  getProducts(JdbcTemplate jdbcTemplate){
        String sql = "select * from products ;";
        List<product> products= jdbcTemplate.query(sql,new BeanPropertyRowMapper(product.class));
        return products;
    }

    public int createProduct(JdbcTemplate jdbcTemplate, product product ){
        String sql = "INSERT INTO products (name, price) VALUES"
                + "('"+product.name+"', "+product.price+");";
        int rows = jdbcTemplate.update(sql);
        return rows; 
    }

    public Number createPurchaseHeader(JdbcTemplate jdbcTemplate, purchaseHeader purchaseHeader ){
        String sql = "INSERT INTO purchase_header (create_date) VALUES"
                + "('"+purchaseHeader.create_date+"') RETURNING id;";


        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
            new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                    return ps;
                }
            },
            keyHolder);
        System.out.println();
        return keyHolder.getKey(); 
    }

    public int createPurchaseDetail( JdbcTemplate jdbcTemplate , List<purchaseDetail> purchaseDetails ){
        String sql = "";
        for (purchaseDetail purchaseDetail : purchaseDetails) {
            sql = sql + "INSERT INTO purchase_detail (id_header, create_date,id_product,amount ) VALUES"
                    + "('"+purchaseDetail.id_header+"', '"+purchaseDetail.create_date+"' ,"+purchaseDetail.id_product+","+purchaseDetail.amount+");";
        }
        int rows = jdbcTemplate.update(sql);
        return rows; 
    }
    public  List<purchaseHeader>  getPurchaseHeader(JdbcTemplate jdbcTemplate){
        String sql = "select * from purchase_header ;";
        List<purchaseHeader>  purchaseHeader= jdbcTemplate.query(sql,new BeanPropertyRowMapper(purchaseHeader.class));
        return purchaseHeader;
    }
    
}
