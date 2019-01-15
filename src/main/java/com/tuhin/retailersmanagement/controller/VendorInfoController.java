/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.VendorService;
import com.tuhin.retailersmanagement.model.Vendorinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */@Controller
public class VendorInfoController {
  @Autowired
    VendorService cat; 
  
  @RequestMapping("/showingvendorinfo")
    public ModelAndView showcatpage() {
        String categorygsonlist = cat.viewVendorinfo();
        ModelAndView mv = new ModelAndView("vendorinfo", "addVendorObject1", new Vendorinfo());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/showingvendorinfo2")
    public ModelAndView showvendor() {
        String categorygsonlist = cat.viewVendorinfo();
        ModelAndView mv = new ModelAndView("viewVendor", "addVendorObject1", new Vendorinfo());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    

    @RequestMapping(value = "/addingvendor", params = "Addcategory")
    public String addcategory(@ModelAttribute("addVendorObject1") Vendorinfo cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertVendorinfo(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingvendorinfo";
    }

    @RequestMapping(value = "/addingvendor", params = "EditCategory")
    public String editcategory(@ModelAttribute("addVendorObject1") Vendorinfo cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateVendorinfo(cm);
        return "redirect:/showingvendorinfo";
    }

    @RequestMapping("removevendor/{Id}")
    public String removecategory(@PathVariable("Id") int categoryId) {
        cat.deleteVendorinfo(categoryId);
        return "redirect:/showingvendorinfo";
    }

    @RequestMapping("/editvendorbutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

        Vendorinfo onecategory = cat.viewOneVendorinfo(categoryId);
        String categorygsonlist = cat.viewVendorinfo();
        ModelAndView mv = new ModelAndView("vendorinfo", "addVendorObject1", onecategory);
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
  
}
