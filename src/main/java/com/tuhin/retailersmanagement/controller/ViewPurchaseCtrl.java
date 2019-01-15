/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.ViewpurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author R34
 */@Controller
public class ViewPurchaseCtrl {
    @Autowired
    ViewpurchaseService vpl;
    
    
     @RequestMapping(value = "/viewShowpurchase", method = RequestMethod.GET)
    public ModelAndView showPurchase() {
        String purchaselist = vpl.viewPurchaseservice();
        
        ModelAndView mv = new ModelAndView("viewpurchase");
        mv.addObject("purchaselist", purchaselist);
        //logger.info("End of Landingpage in home controller");
        return mv;
    }
    
    @RequestMapping("removinpurchase/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        vpl.deletePurchaseservice(productid);
        return "redirect:/viewShowsale";
    }
    
}
