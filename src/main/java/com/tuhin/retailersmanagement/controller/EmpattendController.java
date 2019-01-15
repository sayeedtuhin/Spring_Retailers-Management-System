/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.EmpattendService;
import com.tuhin.retailersmanagement.dao.EmployeeinfoService;
import com.tuhin.retailersmanagement.model.Empattend;
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
public class EmpattendController {
   @Autowired
      EmpattendService es;
    @Autowired
    EmployeeinfoService eis;
    
     
     
      @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "attenddate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
    
    @InitBinder
    public void myInitBinderr(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
    
    @RequestMapping("/showattendpage")
    public ModelAndView showAttended() {
        String empattendlist = es.viewEmpattend();
        String empinfoList = eis.viewEmployeeinfo();
        //User emaillist = sdao.viewUser( s);

        ModelAndView mv = new ModelAndView("addAttend", "newAttendObject", new Empattend());
        mv.addObject("empattendlist", empattendlist);
        mv.addObject("empinfoList", empinfoList);
        //mv.addObject("categorymodelobject", emaillist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    @RequestMapping(value = "/addAttends", params = "Add")
    public String addAttended(@ModelAttribute("newAttendObject") Empattend eattend, HttpServletRequest request) {
        es.insertEmpattend(eattend);
//        String path = "D:\\SOFT_WORKING\\ShopOnlineRest\\ShopOnlineRest\\src\\main\\webapp\\resources\\Pimage\\";
        
//        System.out.println(servletContext.getContextPath()+".......");
//        //System.out.println(request.getSession().getServletContext());
//        String p = servletContext.getContextPath();
//             p = "D:\\SOFT_WORKING\\project36\\src\\main\\webapp\\resources\\pimage\\"+String.valueOf(product.getPurchaseid()) + "" + ".jpg" ; 
////        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
//             System.out.println(p);
//        MultipartFile filedet = product.getPimage();
//        if (!filedet.isEmpty()) {
//            try {
//                byte[] bytes = filedet.getBytes();
//                System.out.println(bytes.length);
//                FileOutputStream fos = new FileOutputStream(new File(p));
//                BufferedOutputStream bs = new BufferedOutputStream(fos);
//                bs.write(bytes);
//                bs.close();
//                fos.close();
//                Thread.sleep(10000);
//                System.out.println("File Uploaded Successfully");
//            } catch (Exception e) {
//                System.out.println("Exception Arised" + e);
//            }
//        } else {
//            System.out.println("File is Empty not Uploaded");
//        }
        return "redirect:/showattendpage";
    }
    
    @RequestMapping(value = "/addAttends", params = "Edit")
    public String editAttended(@ModelAttribute("newAttendObject") Empattend eattend, HttpServletRequest request) {
        es.updateEmpattend(eattend.getEmpattendid(), eattend);
//        String path = "D:\\SOFT_WORKING\\ShopOnlineRest\\ShopOnlineRest\\src\\main\\webapp\\resources\\Pimage\\";
//        System.out.println(request.getSession().getServletContext());
////        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
////        MultipartFile filedet = product.getPimage();
////        if (!filedet.isEmpty()) {
////            try {
////                byte[] bytes = filedet.getBytes();
////                System.out.println(bytes.length);
////                File f = new File(path);
////                if (f.exists()) {
////                    f.delete();
////                    FileOutputStream fos = new FileOutputStream(f);
////                    BufferedOutputStream bs = new BufferedOutputStream(fos);
////                    bs.write(bytes);
////                    bs.close();
////                    fos.close();
////                    Thread.sleep(10000);
////                    System.out.println("File Uploaded Successfully");
////                }
////            } catch (Exception e) {
////                System.out.println("Exception Arised" + e);
////            }
////        } else {
////            System.out.println("File is Empty not Uploaded");
////        }
        return "redirect:/showattendpage";
    }
    
     @RequestMapping("removingAttend/{Id}")
    public String removeAttended(@PathVariable("Id") int categoryId) {
        es.deleteEmpattend(categoryId);
        return "redirect:/showattendpage";
    }
    
    @RequestMapping("/editingAttend")
    public ModelAndView editAttendeds(@RequestParam("getpid") int eid) {
        String empattendlist = es.viewEmpattend();
        String empinfoList = eis.viewEmployeeinfo();
        //User emaillist = sdao.viewUser( s);
        ModelAndView mv = new ModelAndView("addAttend", "newAttendObject", es.viewOneEmpattend(eid));
        mv.addObject("empattendlist", empattendlist);
        mv.addObject("empinfoList", empinfoList);
       // mv.addObject("categorymodelobject", emaillist);
        mv.addObject("check", "false");
        return mv;
    }
   
}
