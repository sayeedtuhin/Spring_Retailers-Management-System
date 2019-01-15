/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.CustomerinfoService;
import com.tuhin.retailersmanagement.model.Customerinfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author C13
 */@Controller
public class CustomerInfoController {
 @Autowired
    CustomerinfoService cat;
@Autowired
    private ServletContext servletContext;

 @RequestMapping("/showingCustomerinfo")
    public ModelAndView showcatpage() {
        String categorygsonlist = cat.viewCustomerinfo();
        ModelAndView mv = new ModelAndView("customerinfo", "addCustomerinfo1", new Customerinfo());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    
     @RequestMapping("/showingCustomerinfo2")
    public ModelAndView showcustomer() {
        String categorygsonlist = cat.viewCustomerinfo();
        ModelAndView mv = new ModelAndView("viewCustomer", "addCustomerinfo1", new Customerinfo());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    @RequestMapping(value = "/addingcustomer", params = "Addcategory")
    public String addcategory(@ModelAttribute("addCustomerinfo1") Customerinfo cm, HttpServletRequest request) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertCustomerinfo(cm);
         String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\pimage\\" + String.valueOf(cm.getCustomerid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = cm.getPimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                FileOutputStream fos = new FileOutputStream(new File(p));
                BufferedOutputStream bs = new BufferedOutputStream(fos);
                bs.write(bytes);
                bs.close();
                fos.close();
                Thread.sleep(10000);
                System.out.println("File Uploaded Successfully");
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingCustomerinfo";
    }

    @RequestMapping(value = "/addingcustomer", params = "EditCategory")
    public String editcategory(@ModelAttribute("addCustomerinfo1") Customerinfo cm, HttpServletRequest request) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateCustomerinfo(cm);
        
         String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut + "\\src\\main\\webapp\\resources\\pimage\\" + String.valueOf(cm.getCustomerid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = cm.getPimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                File f = new File(p);
                if (f.exists()) {
                    f.delete();
                    FileOutputStream fos = new FileOutputStream(f);
                    BufferedOutputStream bs = new BufferedOutputStream(fos);
                    bs.write(bytes);
                    bs.close();
                    fos.close();
                    Thread.sleep(10000);
                    System.out.println("File Uploaded Successfully");
                }
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
        return "redirect:/showingCustomerinfo";
    }

    @RequestMapping("removecustomer/{Id}")
    public String removecategory(@PathVariable("Id") int categoryId) {
        cat.deleteCustomerinfo(categoryId);
        return "redirect:/showingCustomerinfo";
    }

    @RequestMapping("/editcustomerbutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

       Customerinfo onecategory = cat.viewOneCustomerinfo(categoryId);
        String categorygsonlist = cat.viewCustomerinfo();
        ModelAndView mv = new ModelAndView("customerinfo", "addCustomerinfo1", onecategory);
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    } 
     
}
