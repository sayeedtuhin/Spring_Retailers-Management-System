/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.ProductService;
import com.tuhin.retailersmanagement.model.Product;
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
public class ProductController {
    @Autowired
    ProductService cat;
    
    @RequestMapping("/showingcategorypage")
    public ModelAndView showcatpage() {
        String categorygsonlist = cat.viewProduct();
        ModelAndView mv = new ModelAndView("addproduct", "addCategoryObject1", new Product());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    @RequestMapping("/showproduct")
    public ModelAndView showproduct() {
        String categorygsonlist = cat.viewProduct();
        ModelAndView mv = new ModelAndView("viewproduct", "addCategoryObject1", new Product());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    

    @RequestMapping(value = "/addingcategory", params = "Addcategory")
    public String addcategory(@ModelAttribute("addCategoryObject1") Product cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertProduct(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingcategorypage";
    }

    @RequestMapping(value = "/addingcategory", params = "EditCategory")
    public String editcategory(@ModelAttribute("addCategoryObject1") Product cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateProduct(cm);
        return "redirect:/showingcategorypage";
    }

    @RequestMapping("removecategory/{Id}")
    public String removecategory(@PathVariable("Id") int categoryId) {
        cat.deleteProduct(categoryId);
        return "redirect:/showingcategorypage";
    }

    @RequestMapping("/editcategorybutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

        Product onecategory = cat.viewOneProduct(categoryId);
        String categorygsonlist = cat.viewProduct();
        ModelAndView mv = new ModelAndView("addproduct", "addCategoryObject1", onecategory);
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
}
