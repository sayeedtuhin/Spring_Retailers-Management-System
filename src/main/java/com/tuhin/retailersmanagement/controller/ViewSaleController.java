/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.ViewSaleService;
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
public class ViewSaleController {
      @Autowired
      ViewSaleService vsl;
    
    
     @RequestMapping(value = "/viewShowsale", method = RequestMethod.GET)
    public ModelAndView showsale() {
        String salelist = vsl.viewSaleservice();
        ModelAndView mv = new ModelAndView("viewsale");
        mv.addObject("salelist", salelist);
        //logger.info("End of Landingpage in home controller");
        return mv;
    }
    @RequestMapping("removingproduct/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        vsl.deleteSaleservice(productid);
        return "redirect:/viewShowsale";
    }
    
}
