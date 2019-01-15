/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.CustomerinfoService;
import com.tuhin.retailersmanagement.dao.ReceivepaymentService;
import com.tuhin.retailersmanagement.dao.SaleService;
import com.tuhin.retailersmanagement.model.Receivepayment;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
 * @author R34
 */@Controller
public class ReceivepaymentController {
  @Autowired
    ReceivepaymentService rps;
    @Autowired
    CustomerinfoService cs;
    @Autowired
    SaleService ss;
    @Autowired
    private ServletContext servletContext;
    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/showreceivepaytpage")
    public ModelAndView showpaytpage() {
        
        String  receivepayment = rps.viewReceivepayment();
        String customerinfoService = cs.viewCustomerinfo();
        String saleService = ss.viewSale();

        ModelAndView mv = new ModelAndView("addreceive", "newreceiveObject", new Receivepayment());
        mv.addObject("receivepayment", receivepayment);
        mv.addObject("customerinfoService", customerinfoService);
        mv.addObject("saleService", saleService);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping("/showreceivepaytpage2")
    public ModelAndView showpay() {
        
        String  receivepayment = rps.viewReceivepayment();
        String customerinfoService = cs.viewCustomerinfo();
        String saleService = ss.viewSale();

        ModelAndView mv = new ModelAndView("viewReceive", "newreceiveObject", new Receivepayment());
        mv.addObject("receivepayment", receivepayment);
        mv.addObject("customerinfoService", customerinfoService);
        mv.addObject("saleService", saleService);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    
    @RequestMapping(value = "/receiveadd", params = "Add")
    public String addproductpage(@ModelAttribute("newreceiveObject") Receivepayment receive, HttpServletRequest request , HttpSession httpSession) {
       String email = (String) httpSession.getAttribute("UserId");
        receive.setUser(email);
        rps.insertReceivepayment(receive);
        
        return "redirect:/showreceivepaytpage";
    }

    @RequestMapping(value = "/receiveadd", params = "Edit")
    public String editProduct(@ModelAttribute("newreceiveObject") Receivepayment receive, HttpServletRequest request) {
        rps.updateReceivepayment(receive.getReceiveid(), receive);
        
        return "redirect:/showreceivepaytpage";
    }

    @RequestMapping("removingreceive/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        rps.deleteReceivepayment(productid);
        return "redirect:/showreceivepaytpage";
    }

   

    @RequestMapping("/editingreceive")
    public ModelAndView editproductpage(@RequestParam("getpid") int pid) {
        String  receivepayment = rps.viewReceivepayment();
        String customerinfoService = cs.viewCustomerinfo();
        String saleService = ss.viewSale();
        ModelAndView mv = new ModelAndView("addreceive", "newreceiveObject", rps.viewOneReceivepayment(pid));
       mv.addObject("receivepayment", receivepayment);
        mv.addObject("customerinfoService", customerinfoService);
        mv.addObject("saleService", saleService);
        mv.addObject("check", "false");
        return mv;
    }    
}
