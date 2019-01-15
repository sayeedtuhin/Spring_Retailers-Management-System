/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.StockService;
import com.tuhin.retailersmanagement.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author C13
 */@Controller
public class StockController {
    
   @Autowired
    StockService eas;
   
    
    

    @RequestMapping("/showstock")
    public ModelAndView showsalarytpage() {
        
        String stockdetail = eas.viewStock();
        

        ModelAndView mv = new ModelAndView("stocklist", "newstock", new Stock());
        mv.addObject("stockdetail", stockdetail);
       
        mv.addObject("check", "true");
        return mv;
    }

    

   

    @RequestMapping("removingstock/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        eas.deleteStock(productid);
        return "redirect:/showstock";
    }
 
}
