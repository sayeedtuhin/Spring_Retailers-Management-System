/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.ProductService;
import com.tuhin.retailersmanagement.dao.PurchaseDetailService;
import com.tuhin.retailersmanagement.dao.PurchaseService;
import com.tuhin.retailersmanagement.dao.VendorService;
import com.tuhin.retailersmanagement.model.Cart;
import com.tuhin.retailersmanagement.model.Product;
import com.tuhin.retailersmanagement.model.Purchase;
import com.tuhin.retailersmanagement.model.Purchasedetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author R34
 */
@Controller
public class CartController {

    @Autowired
    ProductService productdao;
    @Autowired
    VendorService vendor;
    @Autowired
    PurchaseService purchaseService;
    @Autowired
    PurchaseDetailService purchaseDetailService;

    @RequestMapping("/showcartpage")
    public ModelAndView showCartPage(HttpSession httpSession) {
        //String phurchaselist = purchaseService.viewPurchase();
        String vendorlist = vendor.viewVendorinfo();
        String products = productdao.viewProduct();
        ModelAndView mv = new ModelAndView("addpurchase", "newpurchaseObject", new Purchase());
        //mv.addObject("phurchaselist", phurchaselist);
        mv.addObject("vendorlist", vendorlist);
        mv.addObject("products", products);
        mv.addObject("check", "true");
        Gson g = new Gson();

        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart1");
        if (c.isEmpty()) {
            httpSession.setAttribute("cartempty", "true");
            mv.addObject("itemsincart", "null");
            return mv;
        } else {
            String cartgson = g.toJson(c);
            mv.addObject("itemsincart", cartgson);
            System.out.println(cartgson);
            httpSession.setAttribute("grandtotal", getGrandTotal(c));
            httpSession.setAttribute("grandquantity", getgrandquantity(c));
            httpSession.setAttribute("cartempty", "false");
            return mv;
        }
    }

    @RequestMapping("/addtocart")
    public String addingToCart(HttpSession session, @ModelAttribute("newpurchaseObject") Purchase purchase) {

//        String phurchaselist = purchaseService.viewPurchase();
//        String vendorlist = vendor.viewVendorinfo();
//        String products = productdao.viewProduct();
//        ModelAndView mv = new ModelAndView("purchase", "newpurchaseObject", new Purchase());
//        mv.addObject("phurchaselist", phurchaselist);
//        mv.addObject("vendorlist", vendorlist);
//       mv.addObject("products", products);
//        mv.addObject("check", "true");
        Product pm = productdao.viewOneProduct(purchase.getProductid());
        //Purchasedetail pd = purchaseDetailService.viewOnePurchasedetail(productId);
        //Purchase pp = purchaseService.viewOnePurchase(productId);
        //session.setAttribute("productid", productId);
        System.out.println(purchase.getPrice());
        String flag = "not inserted";
        ArrayList<Cart> cartarray = (ArrayList<Cart>) session.getAttribute("usercart1");

        if (cartarray.isEmpty()) {
            cartarray.add(new Cart(purchase.getProductid(), pm.getProductname(),purchase.getQuantity(), purchase.getPrice(), purchase.getQuantity()*purchase.getPrice()));
            System.out.println(purchase.getPrice());
            flag = "inserted";
        } else {
            Iterator<Cart> lit = cartarray.iterator();
            while (lit.hasNext()) {
                Cart d = lit.next();
                if (d.getPid() == purchase.getProductid()) {
                    int index = cartarray.indexOf(d);
                    String name = d.getPname();
                    int qty = d.getQty() + 1;
                    double price = d.getPrice();
                    cartarray.remove(index);
                    cartarray.add(index, new Cart(purchase.getProductid(), name, qty, price, ((qty) * price)));
                    session.setAttribute("usercart1", cartarray);
                    flag = "inserted";
                    break;
                }
            }
            if (flag.equals("not inserted")) {
                cartarray.add(new Cart(purchase.getProductid(), pm.getProductname(), purchase.getQuantity(), purchase.getPrice(), purchase.getQuantity()*purchase.getPrice()  ));
                session.setAttribute("usercart1", cartarray);
            }
        }
        session.setAttribute("grandquantity", getgrandquantity(cartarray));
//        UserCartDetails usercart = new UserCartDetails();
//        Integer intcart = Integer.parseInt(session.getAttribute("Cartid").toString());
//        usercart.setCartid(Integer.parseInt(session.getAttribute("Cartid").toString()));
//        usercart.setProductsincart(cartarray.toString());
//        cdao.insertCartwithProducts(usercart);
        return "redirect:/showcartpage";
    }

    public int getgrandquantity(ArrayList<Cart> items) {
        int grandquant = 0;
        ListIterator<Cart> itr = items.listIterator();
        while (itr.hasNext()) {
            Cart obj = (Cart) itr.next();
            grandquant = grandquant + obj.getQty();
        }
        return grandquant;
    }

    public double getGrandTotal(ArrayList<Cart> item) {
        double gtotal = 0;
        ListIterator<Cart> itr = item.listIterator();
        while (itr.hasNext()) {
            Cart ob = (Cart) itr.next();
            gtotal = gtotal + (ob.getQty() * ob.getPrice());
        }
        return gtotal;
    }

    @RequestMapping(value = "/editquantity")
    public String editCart(@RequestParam("getproductid") int id, @RequestParam("value") String sign, HttpSession session) {
        ArrayList<Cart> c = (ArrayList<Cart>) session.getAttribute("usercart1");
        Iterator<Cart> lit = c.iterator();
        while (lit.hasNext()) {
            Cart d = lit.next();
            int index = c.indexOf(d);
            if (d.getPid() == id) {
                String name = d.getPname();
                int qty = d.getQty();
                double price = d.getPrice();
                c.remove(index);
                if (sign.equals("decrease") && qty > 1) {
                    c.add(index, new Cart(id, name, qty - 1, price, ((qty + 1) * price)));
                } else if (sign.equals("decrease") && qty == 1) {
                    c.add(index, new Cart(id, name, 1, price, price));
                } else if (sign.equals("increase") && qty < 100) {
                    c.add(index, new Cart(id, name, qty + 1, price, ((qty + 1) * price)));
                } else {
                    c.add(index, new Cart(id, name, qty, price, ((qty) * price)));
                }
                break;
            }
        }
        session.setAttribute("grandquantity", getgrandquantity(c));
        session.setAttribute("usercart1", c);

        return "redirect:/showcartpage";
    }

    @RequestMapping("/removeproductitem")
    public String removeproductitem(@RequestParam("pid") int productid, HttpSession session) {
        @SuppressWarnings("unchecked")
        ArrayList<Cart> cartitems = (ArrayList<Cart>) session.getAttribute("usercart1");
        Iterator<Cart> list = (Iterator<Cart>) cartitems.iterator();
        while (list.hasNext()) {
            Cart c = list.next();
            if (c.getPid() == productid) {
                cartitems.remove(cartitems.indexOf(c));
                break;
            }
        }
        session.setAttribute("grandquantity", getgrandquantity(cartitems));
        session.setAttribute("usercart1", cartitems);
        return "redirect:/showcartpage";
    }
}
