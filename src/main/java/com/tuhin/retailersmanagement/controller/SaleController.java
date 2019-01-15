/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.CustomerinfoService;
import com.tuhin.retailersmanagement.dao.ProductService;
import com.tuhin.retailersmanagement.dao.PurchaseDetailService;
import com.tuhin.retailersmanagement.dao.SaleDetailService;
import com.tuhin.retailersmanagement.dao.SaleService;
import com.tuhin.retailersmanagement.dao.StockService;
import com.tuhin.retailersmanagement.dao.Userservice;
import com.tuhin.retailersmanagement.model.Cart1;
import com.tuhin.retailersmanagement.model.Purchasedetail;
import com.tuhin.retailersmanagement.model.Sale;
import com.tuhin.retailersmanagement.model.Saledetail;
import com.tuhin.retailersmanagement.model.Stock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class SaleController {
    @Autowired
    SaleService saleService;
    @Autowired
    CustomerinfoService custom;
    @Autowired
    ProductService productdao;
     @Autowired
    PurchaseDetailService purchaseDetailService;
    
     @Autowired
     SaleDetailService saleDetailService;
     
    @Autowired
     StockService stockservice;
    
    @Autowired
    private ServletContext servletContext;
    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "saledate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/salepage")
    public ModelAndView showsaletpage() {
        
        String salelist = saleService.viewSale();
        String customerlist = custom.viewCustomerinfo();
        String productlist = productdao.viewProduct();

        ModelAndView mv = new ModelAndView("addsale", "newsaleObject", new Sale());
        mv.addObject("salelist", salelist);
        mv.addObject("customerlist", customerlist);
       mv.addObject("productlist", productlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addsaleshow", params = "Add")
    public String addproductpage(@ModelAttribute("newsaleObject") Sale sale, HttpServletRequest request, HttpSession httpSession) {
      ArrayList<Cart1> c = (ArrayList<Cart1>) httpSession.getAttribute("usercart");
        String email = (String) httpSession.getAttribute("UserId");
        sale.setAdmin(email);
        saleService.insertSale(sale);
        System.out.println("start");
        Saledetail sorder = new Saledetail();
        int pq= sorder.getSaleid();
        int xp= pq;
         ArrayList<Saledetail> odetail = new ArrayList<Saledetail>();
        for (Cart1 cart : c) {
            System.out.println("fast");
            
            
            System.out.println("jslkjfldk");
            sorder.setSaleid(sale.getSaleid());
            if(sorder.getSaleid()> xp){
                System.out.println("data is same");
                sorder.setProductid(cart.getPid());
            sorder.setQuantity(cart.getQty());
            sorder.setPrice(cart.getPrice());
            System.out.println("end");
            odetail.add(sorder);
            saleDetailService.insertSaledetail(odetail);
            }else{
              System.out.println(" done end");  
            }
            
            
//            // get product and update quantity
                Stock p = stockservice.viewOneStock(cart.getPid());
            p.setTotalstock(p.getTotalstock()- cart.getQty());
            stockservice.updateStock(cart.getPid(), p);

        }
         //purchaseDetailService.insertPurchasedetail(odetail2);
        odetail.removeAll(odetail);
        
        ModelAndView mv = new ModelAndView("addpurchase");
        
        mv.addObject("saleid", sale.getSaleid());
        httpSession.setAttribute("usercart", new ArrayList<Cart1>());
       
        return "redirect:/welcome";
        
    }

    @RequestMapping(value = "/addsaleshow", params = "Edit")
    public String editProduct(@ModelAttribute("newsaleObject") Sale sale, HttpServletRequest request) {
        saleService.updateSale(sale.getSaleid(), sale);
        
        return "redirect:/salepage";
    }

    @RequestMapping("removingsale/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        saleService.deleteSale(productid);
        return "redirect:/salepage";
    }

   

    @RequestMapping("/editingsale")
    public ModelAndView editproductpage(@RequestParam("getpid") int pid) {
     String salelist = saleService.viewSale();
        String customerlist = custom.viewCustomerinfo();
        String products = productdao.viewProduct();
        ModelAndView mv = new ModelAndView("addsale", "newsaleObject", saleService.viewOneSale(pid));
        mv.addObject("salelist", salelist);
        mv.addObject("customerlist", customerlist);
       mv.addObject("product", products);
        mv.addObject("check", "false");
        return mv;
    }
    
    
    @RequestMapping("/viewproduct")
    public ModelAndView viewproductdata(@RequestParam("getId") int productid, HttpSession session) {
        Gson g = new Gson();
        String productdata = g.toJson(purchaseDetailService.viewOnePurchasedetail(productid));
        //session.setAttribute("productid", productid);
        ModelAndView mv = new ModelAndView("addsale");
        mv.addObject("pro", productdata);
        return mv;
    } 
    
    
}
