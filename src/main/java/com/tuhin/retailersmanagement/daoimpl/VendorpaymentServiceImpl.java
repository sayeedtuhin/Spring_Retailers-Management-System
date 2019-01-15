/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.VendorpaymentService;
import com.tuhin.retailersmanagement.model.Vendorpayment;
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
public class VendorpaymentServiceImpl implements  VendorpaymentService{
      @Autowired
    SessionFactory sessionFactory;


    @Override
    public String insertVendorpayment(Vendorpayment pm) {
 Session s = sessionFactory.openSession();

        Transaction t = s.getTransaction();
        t.begin();
       
        
        
        
        s.save(pm);
        t.commit();
        s.close();
        return null;   
    }

    @Override
    public Integer updateVendorpayment(int vendorpaymentid, Vendorpayment pm) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Vendorpayment emp = (Vendorpayment) s.get(Vendorpayment.class, vendorpaymentid);
        emp.setVendorid(pm.getVendorid());
        // oneproductobject.setEmailid(pm.getEmailid());
        emp.setUser(pm.getUser());
        emp.setAmmount(pm.getAmmount());
        emp.setPaydate(pm.getPaydate());
        emp.setRemarks(pm.getRemarks());
        emp.setPurchaseid(pm.getPurchaseid());
        //emp.setTotal(pm.getTotal());

        s.update(emp);
        t.commit();
        s.close();
        return null;    }

    @Override
    public Integer deleteVendorpayment(int vendorpaymentid) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Vendorpayment pm = (Vendorpayment) s.get(Vendorpayment.class, vendorpaymentid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;    
    }

    @Override
    public String viewVendorpayment() {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Vendorpayment> payList = s.createQuery("from Vendorpayment").list();
        Gson g = new Gson();
        String paylistgson = g.toJson(payList);
        t.commit();
        s.close();
        return paylistgson;    }

    @Override
    public Vendorpayment viewOneVendorpayment(int vendorpaymentid) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Vendorpayment pm = (Vendorpayment) s.get(Vendorpayment.class, vendorpaymentid);
        t.commit();
        s.close();
        return pm;    
    
    }
    
}
