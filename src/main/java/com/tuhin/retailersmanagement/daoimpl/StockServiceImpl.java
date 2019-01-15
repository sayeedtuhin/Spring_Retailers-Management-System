/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.StockService;
import com.tuhin.retailersmanagement.model.Stock;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author R34
 */@Repository
public class StockServiceImpl implements StockService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertStock(ArrayList<Stock> stocks) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
         for (Stock details : stocks) {
             
             List<Stock> stocklist=s.createQuery("from Stock where productid=?").setParameter(0, details.getProductid()).list();
             if(stocklist.size()>0){
                Stock ss=stocklist.get(0);
                if(stocklist.size()>0){
             
              Stock st = (Stock) s.get(Stock.class, ss.getStockid());
                st.setProductid(details.getProductid());
                st.setTotalstock(details.getTotalstock()+ss.getTotalstock());
                s.update(st);
             
             }
             
             }else{
                 Stock sts=new Stock();
               sts.setProductid(details.getProductid());
               sts.setTotalstock(details.getTotalstock());
               
            s.save(sts);
        }
             
             
         }
        
        
        
//        for (Stock details : stocks) {
//            List<Stock> stockList = s.createQuery("from Stock where productid=?").setParameter(0, details.getProductid()).list();
//            Stock ss=stockList.get(0);
//            
//            if(stockList.size()>0){
//                Stock st = (Stock) s.get(Stock.class, ss.getStockid());
//                st.setProductid(details.getProductid());
//                st.setTotalstock(details.getTotalstock()+ss.getTotalstock());
//                s.update(st);
//                System.out.println("laksdjflkasjdflkasjflj   "+details.getTotalstock());
//            System.out.println("kajsdhfahsdfoahsdfpoahdsfashdf"+ss.getTotalstock());
//            }else{
//            s.save(details);
//            }
            
            
        
        t.commit();
        s.close();
        return null;   
    }

    @Override
    public Integer updateStock(int stockid, Stock pm) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Stock emp = (Stock) s.get(Stock.class, stockid);
        emp.setProductid(pm.getProductid());
        // oneproductobject.setEmailid(pm.getEmailid());
        emp.setTotalstock(pm.getTotalstock());
//        emp.setSalarydate(pm.getSalarydate());
//        emp.setBasicsalary(pm.getBasicsalary());
//        emp.setOvertimepayment(pm.getOvertimepayment());
//        emp.setIncentives(pm.getIncentives());
        //emp.setTotal(pm.getTotal());

        s.update(emp);
        t.commit();
        s.close();
        return null;    }

    @Override
    public Integer deleteStock(int stockid) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Stock pm = (Stock) s.get(Stock.class, stockid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;   
    }

    @Override
    public String viewStock() {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Stock> stockList = s.createQuery("from Stock").list();
        Gson g = new Gson();
        String stockListlistgson = g.toJson(stockList);
        t.commit();
        s.close();
        return stockListlistgson;    }

    @Override
    public Stock viewOneStock(int stockid) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Stock pm = (Stock) s.get(Stock.class, stockid);
        t.commit();
        s.close();
        return pm;    }

    @Override
    public int showstock() {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Stock> st = s.createQuery("from Stock").list();
        int a=st.size();
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return a;     
    }
    
}
