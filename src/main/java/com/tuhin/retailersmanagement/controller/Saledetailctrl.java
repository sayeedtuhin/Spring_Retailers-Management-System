/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.SaleDetailService;
import com.tuhin.retailersmanagement.model.Saledetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author R34
 */@Controller
public class Saledetailctrl {
      @Autowired
      SaleDetailService eas;
   
    
    

    @RequestMapping("/showsaledetail")
    public ModelAndView showsalarytpage() {
        
        String sdetail = eas.viewSaledetail();
        

        ModelAndView mv = new ModelAndView("saleDetail", "newsaledetail", new Saledetail());
        mv.addObject("sdetail", sdetail);
       
        mv.addObject("check", "true");
        return mv;
    }

    

   

    @RequestMapping("removingsaledetail/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        eas.deleteSaledetail(productid);
        return "redirect:/showsaledetail";
    }
    
}
