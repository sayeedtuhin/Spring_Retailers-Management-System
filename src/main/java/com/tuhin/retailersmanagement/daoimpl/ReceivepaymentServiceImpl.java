/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.ReceivepaymentService;
import com.tuhin.retailersmanagement.model.Receivepayment;
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
public class ReceivepaymentServiceImpl implements ReceivepaymentService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertReceivepayment(Receivepayment pm) {
Session s = sessionFactory.openSession();

        Transaction t = s.getTransaction();
        t.begin();
       
        
        
        
        s.save(pm);
        t.commit();
        s.close();
        return null;     
    }

    @Override
    public Integer updateReceivepayment(int receiveid, Receivepayment pm) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Receivepayment emp = (Receivepayment) s.get(Receivepayment.class, receiveid);
        emp.setCustomerid(pm.getCustomerid());
        // oneproductobject.setEmailid(pm.getEmailid());
        emp.setSaleid(pm.getSaleid());
        emp.setUser(pm.getUser());
        emp.setAmmount(pm.getAmmount());
        emp.setDate(pm.getDate());
        emp.setRemarks(pm.getRemarks());
        //emp.setTotal(pm.getTotal());

        s.update(emp);
        t.commit();
        s.close();
        return null;   
    }

    @Override
    public Integer deleteReceivepayment(int receiveid) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Receivepayment pm = (Receivepayment) s.get(Receivepayment.class, receiveid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;   
    }

    @Override
    public String viewReceivepayment() {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Receivepayment> payList = s.createQuery("from Receivepayment").list();
        Gson g = new Gson();
        String paylistgson = g.toJson(payList);
        t.commit();
        s.close();
        return paylistgson;     
    }

    @Override
    public Receivepayment viewOneReceivepayment(int receiveid) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Receivepayment pm = (Receivepayment) s.get(Receivepayment.class, receiveid);
        t.commit();
        s.close();
        return pm;     
    }
    
}
