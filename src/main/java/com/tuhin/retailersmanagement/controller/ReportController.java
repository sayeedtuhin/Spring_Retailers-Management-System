/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.controller;

import com.tuhin.retailersmanagement.dao.CustomerinfoService;
import com.tuhin.retailersmanagement.dao.EmployeeinfoService;
import com.tuhin.retailersmanagement.dao.ProductService;
import com.tuhin.retailersmanagement.dao.PurchaseService;
import com.tuhin.retailersmanagement.dao.SaleService;
import com.tuhin.retailersmanagement.dao.VendorService;
import com.tuhin.retailersmanagement.daoimpl.JasperDao;
import com.tuhin.retailersmanagement.reportmodel.Employeesalary;
import com.tuhin.retailersmanagement.reportmodel.PaymentReport;
import com.tuhin.retailersmanagement.reportmodel.PurchaseA;
import com.tuhin.retailersmanagement.reportmodel.PurchaseReport;
import com.tuhin.retailersmanagement.reportmodel.Receiverpaymenteport;
import com.tuhin.retailersmanagement.reportmodel.SalaryD;
import com.tuhin.retailersmanagement.reportmodel.SaleA;
import com.tuhin.retailersmanagement.reportmodel.SaleReport;
import com.tuhin.retailersmanagement.reportmodel.StockR;
import com.tuhin.retailersmanagement.reportmodel.SubPurchases;
import com.tuhin.retailersmanagement.reportmodel.SubSale;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.HashMap;
import org.springframework.ui.Model;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sayeed Tuhin
 */
@Controller
public class ReportController {
    
    @Autowired
    SaleService ss;
    @Autowired
    PurchaseService ps;
     @Autowired
     EmployeeinfoService eis;
   
     @Autowired
    VendorService vendor;
     @Autowired
    CustomerinfoService custom;

    @Autowired
    ProductService productdao;
     
     
     
      @RequestMapping("/reportview")
    public ModelAndView showpayytpage() {
        
       
        String purchaseService = ps.viewPurchase();
         String vendorlist = vendor.viewVendorinfo();

        ModelAndView mv = new ModelAndView("paymentreport", "reportInputForm", new PaymentReport());
        
        mv.addObject("purchaseService", purchaseService);
         mv.addObject("vendorlist", vendorlist);
        mv.addObject("check", "true");
        return mv;
    }
     
    
    @RequestMapping(value = "/reportview1", method = RequestMethod.POST)
    public String generateReport(@ModelAttribute("reportInputForm") PaymentReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "vendorpaymentreport";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int pid = reportInputForm.getPid();
             String vname = reportInputForm.getVname();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("pid", pid);
             hmParams.put("vname", vname);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }   
    
    
    
  
    
    
    @RequestMapping("/salaryView")
    public ModelAndView showsalarytpage() {
        
       
        String employeelist = eis.viewEmployeeinfo();
      

        ModelAndView mv = new ModelAndView("salaryreport", "reportInputForm", new Employeesalary());
       
        mv.addObject("employeelist", employeelist);
         mv.addObject("dddddd", new SalaryD());
       
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    
    @RequestMapping(value = "/salaryView1", method = RequestMethod.POST)
    public String generatesalaryReport(@ModelAttribute("reportInputForm") Employeesalary reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "salary";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String empname = reportInputForm.getEmpname();
             String empmail = reportInputForm.getEmpmail();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("empname", empname);
             hmParams.put("empmail", empmail);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }  
    
    

    
    @RequestMapping(value = "/salaryView2", method = RequestMethod.POST)
    public String generatesalaryDReport(@ModelAttribute("dddddd") SalaryD dddddd,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "empsalaryR";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String sdate = dddddd.getSdate();
             String edate = dddddd.getEdate();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("sdate", sdate);
             hmParams.put("edate", edate);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    } 
    
    
    
    
    
    
    
    @RequestMapping("/receiveview")
    public ModelAndView showpattpage() {
        
        
        String saleService = ss.viewSale();
        String customerlist = custom.viewCustomerinfo();

        ModelAndView mv = new ModelAndView("receiveReport", "reportInputForm1", new Receiverpaymenteport());
        
        mv.addObject("saleService", saleService);
        mv.addObject("customerlist", customerlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    @RequestMapping(value = "/receiveview1", method = RequestMethod.POST)
    public String generatereceiveReport(@ModelAttribute("reportInputForm1") Receiverpaymenteport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "receivepayreport";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int sid = reportInputForm.getSid();
             String cname = reportInputForm.getCname();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("sid", sid);
             hmParams.put("cname", cname);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    } 
    
    
    
    @RequestMapping(value = "/purchaseview", method = RequestMethod.GET)
    public String loadpurchasePg(
            @ModelAttribute("reportInputForm") PurchaseReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "purchaseReport";
    }
    
    @RequestMapping(value = "/purchaseview", method = RequestMethod.POST)
    public String generatepurchaseReport(@ModelAttribute("reportInputForm") PurchaseReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "purchaseReportt";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String sdate = reportInputForm.getSdate();
            String edate = reportInputForm.getEdate();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("sdate", sdate);
              hmParams.put("edate", edate);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    } 
    
    
    @RequestMapping(value = "/saleview", method = RequestMethod.GET)
    public String loadpSalePg(
            @ModelAttribute("reportInputForm") SaleReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "saleReport";
    }
    
    @RequestMapping(value = "/saleview", method = RequestMethod.POST)
    public String generateSaleReport(@ModelAttribute("reportInputForm") SaleReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "reportSale";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String startdate = reportInputForm.getStartdate();
            String enddate = reportInputForm.getEnddate();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("startdate", startdate);
              hmParams.put("enddate", enddate);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    } 
    
    
    
    
    @RequestMapping(value = "/peview", method = RequestMethod.GET)
    public String loadppPg(
            @ModelAttribute("reportInputForm") PurchaseA reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "pReport";
    }
    
    @RequestMapping(value = "/peview", method = RequestMethod.POST)
    public String generatepReport(@ModelAttribute("reportInputForm") PurchaseA reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "purchase";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int pid = reportInputForm.getPid();
           
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("pid", pid);
             
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    } 
    
    
    @RequestMapping(value = "/seview", method = RequestMethod.GET)
    public String loadspPg(
            @ModelAttribute("reportInputForm") SaleA reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "sReport";
    }
    
    @RequestMapping(value = "/seview", method = RequestMethod.POST)
    public String generatesReport(@ModelAttribute("reportInputForm") SaleA reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "sale";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int sid = reportInputForm.getSid();
           
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("sid", sid);
             
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    } 
    
    
    

    
    
     @RequestMapping("/subpeview")
    public ModelAndView showpaytpage() {
        
       
        String purchaseService = ps.viewPurchase();

        ModelAndView mv = new ModelAndView("subpurchasereport", "reportInputForm", new SubPurchases());
        
        mv.addObject("purchaseService", purchaseService);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    
    @RequestMapping(value = "/subpeview1", method = RequestMethod.POST)
    public String generatesubReport(@ModelAttribute("reportInputForm") SubPurchases reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "subPurchase1";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int pid = reportInputForm.getPid();
           
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("pid", pid);
             
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }  
    
    
    

    
    
    @RequestMapping("/subseview")
    public ModelAndView showpayyttpage() {
        
        
        String saleService = ss.viewSale();

        ModelAndView mv = new ModelAndView("subSalereport", "reportInputForm", new SubSale());
        
        mv.addObject("saleService", saleService);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/subseview1", method = RequestMethod.POST)
    public String generatesubsReport(@ModelAttribute("reportInputForm") SubSale reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "subsale";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int sid = reportInputForm.getSid();
           
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("sid", sid);
             
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    } 
    
   
    
    
    
   @RequestMapping("/stockview")
    public ModelAndView showpstockttpage() {
        
        
        String products = productdao.viewProduct();

        ModelAndView mv = new ModelAndView("stockReport", "reportInputForm", new StockR());
        
       mv.addObject("products", products);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/stockview1", method = RequestMethod.POST)
    public String generatstocksReport(@ModelAttribute("reportInputForm") StockR reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "stockReport";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String pname = reportInputForm.getPname();
           String ptype = reportInputForm.getPtype();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("pname", pname);
            hmParams.put("ptype", ptype);
             
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }  
    
    
    
    
    @RequestMapping(value = "/stockview2", method = RequestMethod.POST)
    public String generatstock2sReport(@ModelAttribute("reportInputForm") StockR reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "stockTotalR";
        JasperDao jrdao = new JasperDao();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            
             
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    } 
    
    
    
}
