/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.PurchaseService;
import com.tuhin.retailersmanagement.dao.VendorService;
import com.tuhin.retailersmanagement.dao.VendorpaymentService;
import com.tuhin.retailersmanagement.model.Vendorpayment;
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
public class VendorpaymentController {
  @Autowired
    VendorpaymentService vps;
    @Autowired
    VendorService vs;
    @Autowired
    PurchaseService ps;
    @Autowired
    private ServletContext servletContext;
    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "paydate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/showvendorpaytpage")
    public ModelAndView showpaytpage() {
        
        String  vendorpayment = vps.viewVendorpayment();
        String vendorServicelist = vs.viewVendorinfo();
        String purchaseService = ps.viewPurchase();

        ModelAndView mv = new ModelAndView("addpayment", "newpaymentObject", new Vendorpayment());
        mv.addObject("vendorpayment", vendorpayment);
        mv.addObject("vendorServicelist", vendorServicelist);
        mv.addObject("purchaseService", purchaseService);
        mv.addObject("check", "true");
        return mv;
    }

    
     @RequestMapping("/showvendorpaytpage2")
    public ModelAndView showpay() {
        
        String  vendorpayment = vps.viewVendorpayment();
        String vendorServicelist = vs.viewVendorinfo();
        String purchaseService = ps.viewPurchase();

        ModelAndView mv = new ModelAndView("ViewPayment", "newpaymentObject", new Vendorpayment());
        mv.addObject("vendorpayment", vendorpayment);
        mv.addObject("vendorServicelist", vendorServicelist);
        mv.addObject("purchaseService", purchaseService);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    
    @RequestMapping(value = "/payadd", params = "Add")
    public String addproductpage(@ModelAttribute("newpaymentObject") Vendorpayment payment, HttpServletRequest request , HttpSession httpSession) {
       String email = (String) httpSession.getAttribute("UserId");
        payment.setUser(email);
        vps.insertVendorpayment(payment);
        
        return "redirect:/showvendorpaytpage";
    }

    @RequestMapping(value = "/payadd", params = "Edit")
    public String editProduct(@ModelAttribute("newpaymentObject") Vendorpayment payment, HttpServletRequest request) {
        vps.updateVendorpayment(payment.getVendorpaymentid(), payment);
        
        return "redirect:/showvendorpaytpage";
    }

    @RequestMapping("removingpay/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        vps.deleteVendorpayment(productid);
        return "redirect:/showvendorpaytpage";
    }

   

    @RequestMapping("/editingpay")
    public ModelAndView editproductpage(@RequestParam("getpid") int pid) {
        String  vendorpayment = vps.viewVendorpayment();
        String vendorServicelist = vs.viewVendorinfo();
        String purchaseService = ps.viewPurchase();
        ModelAndView mv = new ModelAndView("addpayment", "newpaymentObject", vps.viewOneVendorpayment(pid));
       mv.addObject("vendorpayment", vendorpayment);
        mv.addObject("vendorServicelist", vendorServicelist);
        mv.addObject("purchaseService", purchaseService);
        mv.addObject("check", "false");
        return mv;
    }  
}
