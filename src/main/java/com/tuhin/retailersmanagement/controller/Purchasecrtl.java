/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.PurchaseDetailService;
import com.tuhin.retailersmanagement.model.Purchasedetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author R34
 */@Controller
public class Purchasecrtl {
  
    @Autowired
    PurchaseDetailService eas;
   
    
    

    @RequestMapping("/showdetail")
    public ModelAndView showsalarytpage() {
        
        String detail = eas.viewPurchasedetail();
        

        ModelAndView mv = new ModelAndView("purchasedetaillist", "newdetail", new Purchasedetail());
        mv.addObject("detail", detail);
       
        mv.addObject("check", "true");
        return mv;
    }

    

   

    @RequestMapping("removingdetail/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        eas.deletePurchasedetail(productid);
        return "redirect:/showdetail";
    }

   

   
}
