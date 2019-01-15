/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.EmployeeinfoService;
import com.tuhin.retailersmanagement.model.Employeeinfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */@Controller
public class EmployeeinfoController {
   @Autowired
    EmployeeinfoService cat; 
   @Autowired
    private ServletContext servletContext;
   
   
  
   
   @RequestMapping("/showingEmployeeinfo")
    public ModelAndView showcatpage() {
        String categorygsonlist = cat.viewEmployeeinfo();
        ModelAndView mv = new ModelAndView("employeeinfo", "addEmployeeinfo1", new Employeeinfo());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    
    @RequestMapping("/showingEmployeeinfo2")
    public ModelAndView showemp() {
        String categorygsonlist = cat.viewEmployeeinfo();
        ModelAndView mv = new ModelAndView("viewEmployee", "addEmployeeinfo1", new Employeeinfo());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    
    @RequestMapping(value = "/addingemployee", params = "Addcategory")
    public String addcategory(@ModelAttribute("addEmployeeinfo1") Employeeinfo cm, HttpServletRequest request) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertEmployeeinfo(cm);
        
         String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
        //System.out.println(targetcut+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut + "\\src\\main\\webapp\\resources\\pimage\\" + String.valueOf(cm.getEmpid()) + "" + ".jpg";
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
        return "redirect:/showingEmployeeinfo";
    }

    @RequestMapping(value = "/addingemployee", params = "EditCategory")
    public String editcategory(@ModelAttribute("addEmployeeinfo1") Employeeinfo cm, HttpServletRequest request) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateEmployeeinfo(cm);
         String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String projectcuts = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcuts.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut + "\\src\\main\\webapp\\resources\\pimage\\" + String.valueOf(cm.getEmpid()) + "" + ".jpg";
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
        
        return "redirect:/showingEmployeeinfo";
    }

    @RequestMapping("removeemployee/{Id}")
    public String removecategory(@PathVariable("Id") int categoryId) {
        cat.deleteEmployeeinfo(categoryId);
        return "redirect:/showingEmployeeinfo";
    }

    @RequestMapping("/editemployeebutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

       Employeeinfo onecategory = cat.viewOneEmployeeinfo(categoryId);
        String categorygsonlist = cat.viewEmployeeinfo();
        ModelAndView mv = new ModelAndView("employeeinfo", "addEmployeeinfo1", onecategory);
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    } 
     
}
