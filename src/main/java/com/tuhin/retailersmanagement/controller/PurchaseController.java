/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.ProductService;
import com.tuhin.retailersmanagement.dao.PurchaseDetailService;
import com.tuhin.retailersmanagement.dao.PurchaseService;
import com.tuhin.retailersmanagement.dao.StockService;
import com.tuhin.retailersmanagement.dao.Userservice;
import com.tuhin.retailersmanagement.dao.VendorService;
import com.tuhin.retailersmanagement.model.Cart;
import com.tuhin.retailersmanagement.model.Product;
import com.tuhin.retailersmanagement.model.Purchase;
import com.tuhin.retailersmanagement.model.Purchasedetail;
import com.tuhin.retailersmanagement.model.Sale;
import com.tuhin.retailersmanagement.model.Stock;
import com.tuhin.retailersmanagement.model.User;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
@Controller
public class PurchaseController {

    @Autowired
    ProductService productdao;
    @Autowired
    VendorService vendor;
    @Autowired
    PurchaseService purchaseService;
    @Autowired
    StockService stock;
    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Autowired
    private ServletContext servletContext;

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "saledate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/phurchasepage")
    public ModelAndView showsaletpage() {

        String phurchaselist = purchaseService.viewPurchase();
        String vendorlist = vendor.viewVendorinfo();
        String products = productdao.viewProduct();

        ModelAndView mv = new ModelAndView("addpurchase", "newpurchaseObject", new Purchase());
        mv.addObject("phurchaselist", phurchaselist);
        mv.addObject("vendorlist", vendorlist);
        mv.addObject("products", products);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addpurchasepage", params = "Add")
    public String addproductpage(@ModelAttribute("newpurchaseObject") Purchase purchase, HttpServletRequest request, HttpSession httpSession) {
        
        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart1");
        String email = (String) httpSession.getAttribute("UserId");
        purchase.setAdmin(email);
        purchaseService.insertPurchase(purchase);
        System.out.println("start");
        Stock s=new Stock();
        Purchasedetail sorder1 = new Purchasedetail();
        int pq= sorder1.getPurchaseid();
        int xp= pq;
         ArrayList<Purchasedetail> odetail2 = new ArrayList<Purchasedetail>();
          ArrayList<Stock> detail = new ArrayList<Stock>();
        for (Cart cart : c) {
            System.out.println("fast");
            
            
            System.out.println("jslkjfldk");
            sorder1.setPurchaseid(purchase.getPurchaseid());
            if(sorder1.getPurchaseid() > xp){
                System.out.println("data is same");
                sorder1.setProductid(cart.getPid());
            sorder1.setQuantity(cart.getQty());
            sorder1.setPrice(cart.getPrice());
            System.out.println("end");
            odetail2.add(sorder1);
             purchaseDetailService.insertPurchasedetail(odetail2);
            
            s.setProductid(cart.getPid());
            s.setTotalstock(cart.getQty());
           detail.add(s);
           stock.insertStock(detail);
            }else{
              System.out.println(" done end");  
            }
            
            
            // get product and update quantity
//            Stock p = stock.viewOneStock(cart.getPid());
//            p.setTotalstock(p.getTotalstock()+ cart.getQty());
//           stock.updateStock(cart.getPid(), p);

        }
         //purchaseDetailService.insertPurchasedetail(odetail2);
        odetail2.removeAll(odetail2);
        
        ModelAndView mv = new ModelAndView("addpurchase");
        
        mv.addObject("purchaseid", purchase.getPurchaseid());
        httpSession.setAttribute("usercart1", new ArrayList<Cart>());
       
        return "redirect:/welcome";
        
        
        
        
       // return "redirect:/phurchasepage";

    }

    @RequestMapping(value = "/addpurchasepage", params = "Edit")
    public String editProduct(@ModelAttribute("newpurchaseObject") Purchase purchase, HttpServletRequest request) {
        purchaseService.updatePurchase(purchase.getPurchaseid(), purchase);
      return "redirect:/phurchasepage";
    }

    @RequestMapping("removingpurchase/{productId}")
    public String removeproduct(@PathVariable("productId") int productid) {
        purchaseService.deletePurchase(productid);
        return "redirect:/phurchasepage";
    }

    @RequestMapping("/editingpurchase")
    public ModelAndView editproductpage(@RequestParam("getpid") int pid) {
        String phurchaselist = purchaseService.viewPurchase();
        String vendorlist = vendor.viewVendorinfo();
        String products = productdao.viewProduct();
        ModelAndView mv = new ModelAndView("addpurchase", "newpurchaseObject", purchaseService.viewOnePurchase(pid));
        mv.addObject("phurchaselist", phurchaselist);
        mv.addObject("vendorlist", vendorlist);
        mv.addObject("products", products);
        mv.addObject("check", "false");
        return mv;
    }

//    public ModelAndView confirmOrder(@RequestParam("getaddressid") int addressid, HttpSession httpSession) {
//        // BillingAddress bm = (BillingAddress) bdao.viewOneBillingAddress(addressid);
//        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart");
//        String email = (String) httpSession.getAttribute("UserId");
//        ProductOrder porder = new ProductOrder();
//        porder.setUseremail(email);
//        porder.setAddressid(addressid);
//        odao.insertProductOrder(porder);
//        ArrayList<OrderDetails> odetails = new ArrayList<OrderDetails>();
//        for (Cart cart : c) {
//            OrderDetails sorder = new OrderDetails();
//            sorder.setOrderid(porder.getOrderid())
//            sorder.setProductid(cart.getPid());
//            sorder.setQuantity(cart.getQty());
//            sorder.setPrice(cart.getPrice());
//            odetails.add(sorder);
//            // get product and update quantity
//            Product p = pdao.viewOneProduct(cart.getPid());
//            p.setProductquantity(p.getProductquantity() - cart.getQty());
//            pdao.updateProduct(cart.getPid(), p);
//
//        }
//        odetdao.insertOrderDetails(odetails);
//        odetails.removeAll(odetails);
//        ModelAndView mv = new ModelAndView("invoice");
//        mv.addObject("bill", "false");
//        mv.addObject("success", "true");
//        mv.addObject("orderid", porder.getOrderid());
//        httpSession.setAttribute("usercart", new ArrayList<Cart>());
//        httpSession.setAttribute("grandquantity", 0);
//        return mv;
//    }

}
