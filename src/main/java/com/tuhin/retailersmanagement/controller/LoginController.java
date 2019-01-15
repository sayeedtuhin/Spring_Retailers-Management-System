/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.StockService;
import com.tuhin.retailersmanagement.dao.Userservice;
import com.tuhin.retailersmanagement.dao.ViewSaleService;
import com.tuhin.retailersmanagement.daoimpl.ViewpurchaseServiceImpl;
import com.tuhin.retailersmanagement.model.Cart;
import com.tuhin.retailersmanagement.model.Cart1;
import com.tuhin.retailersmanagement.model.User;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
public class LoginController {

    @Autowired
    Userservice user;
@Autowired
    ViewpurchaseServiceImpl vps;

@Autowired
    StockService ss;
@Autowired
      ViewSaleService vsl;
    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showlogin() {

        return "login";
    }

    @RequestMapping("/perlogcheck")
    public String prologin(HttpSession session, @RequestParam("getProductId") int id) {
        //logger.info("Inside prologin method in login controller");
        session.setAttribute("pId", id);
        //logger.info("end of prologin method in login controller");
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcome(HttpSession session) {
        return "welcome";
    }

    @RequestMapping(value = "/loginsuccess")
    public String loginsuccess(HttpSession session) {
        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        User us = user.viewUser(userid);
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String page = "";
        String role = "ROLE_USER";
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals(role)) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("usercart1", new ArrayList<Cart>());
                session.setAttribute("usercart", new ArrayList<Cart1>());
                 session.setAttribute("showpurchase",vps.showallpurchase());
                  session.setAttribute("stock",ss.showstock());
                   

                page = "redirect:/welcome";
            } else {
                page = "redirect:/";
            }
        }
        return page;

    }
}
