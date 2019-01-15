/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.EmpattendService;
import com.tuhin.retailersmanagement.dao.EmployeeinfoService;
import com.tuhin.retailersmanagement.dao.EmpsalaryService;
import com.tuhin.retailersmanagement.model.Empsalary;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author C13
 */@Controller
public class EmpsalaryController {
   @Autowired
    EmpsalaryService ems;
    @Autowired
    EmployeeinfoService eis;
    @Autowired
    EmpattendService eas;
    @Autowired
    private ServletContext servletContext;
    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "salarydate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/showsalarytpage")
    public ModelAndView showsalarytpage() {
        
        String salarylist = ems.viewEmpsalary();
        String employeelist = eis.viewEmployeeinfo();
        String empattendList = eas.viewEmpattend();

        ModelAndView mv = new ModelAndView("addsalary", "newsalaryObject", new Empsalary());
        mv.addObject("salarylist", salarylist);
        mv.addObject("employeelist", employeelist);
        mv.addObject("empattendList", empattendList);
        mv.addObject("check", "true");
        return mv;
    }

     @RequestMapping("/showsalarytpage2")
    public ModelAndView showsalary() {
        
        String salarylist = ems.viewEmpsalary();
        String employeelist = eis.viewEmployeeinfo();
        String empattendList = eas.viewEmpattend();

        ModelAndView mv = new ModelAndView("viewSalary", "newsalaryObject", new Empsalary());
        mv.addObject("salarylist", salarylist);
        mv.addObject("employeelist", employeelist);
        mv.addObject("empattendList", empattendList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    
    @RequestMapping(value = "/salaryadd", params = "Add")
    public String addproductpage(@ModelAttribute("newsalaryObject") Empsalary salary, HttpServletRequest request) {
        ems.insertEmpsalary(salary);
        
        return "redirect:/showsalarytpage";
    }

    @RequestMapping(value = "/salaryadd", params = "Edit")
    public String editProduct(@ModelAttribute("newsalaryObject") Empsalary salary, HttpServletRequest request) {
        ems.updateEmpsalary(salary.getSalaryid(), salary);
        
        return "redirect:/showsalarytpage";
    }

    @RequestMapping("removingsalary/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        ems.deleteEmpsalary(productid);
        return "redirect:/showsalarytpage";
    }

   

    @RequestMapping("/editingsalary")
    public ModelAndView editproductpage(@RequestParam("getpid") int pid) {
        String salarylist = ems.viewEmpsalary();
        String employeelist = eis.viewEmployeeinfo();
        String empattendList = eas.viewEmpattend();
        ModelAndView mv = new ModelAndView("addsalary", "newsalaryObject", ems.viewOneEmpsalary(pid));
        mv.addObject("salarylist", salarylist);
        mv.addObject("employeelist", employeelist);
        mv.addObject("empattendList", empattendList);
        mv.addObject("check", "false");
        return mv;
    }
}
