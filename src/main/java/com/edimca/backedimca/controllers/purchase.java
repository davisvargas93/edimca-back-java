
package com.edimca.backedimca.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edimca.backedimca.models.purchaseDetail;
import com.edimca.backedimca.models.purchaseHeader;
import com.edimca.backedimca.models.purchaseHeaderDetail;
import com.edimca.backedimca.persistence.conectionDB;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:4200"})
@RestController
@RequestMapping(value= "api/v1/")
public class purchase {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostMapping(path = "/createPurchase")
    public Boolean createPurchase(@RequestBody purchaseHeaderDetail purchaseHeaderDetail){

        conectionDB c = new conectionDB();
        System.out.println(purchaseHeaderDetail.purchaseHeader.create_date);
        purchaseHeader purchaseHeader =new purchaseHeader(0,purchaseHeaderDetail.purchaseHeader.create_date) ;
        int id_header =Integer.parseInt( c.createPurchaseHeader(jdbcTemplate, purchaseHeader).toString());
        List<purchaseDetail> ListPurchaseDetailFinal = new ArrayList<purchaseDetail>();
        for (purchaseDetail pd :  purchaseHeaderDetail.purchaseDetail) {
            pd.setId_header(id_header);
            ListPurchaseDetailFinal.add(pd);
        }
        c.createPurchaseDetail(jdbcTemplate, ListPurchaseDetailFinal);

        return true;
    }


    @GetMapping(path = "/getPurchaseHeader")
    public List<purchaseHeader> getProducts(){
        conectionDB c = new conectionDB();
        return c.getPurchaseHeader(jdbcTemplate); 
    }
}
