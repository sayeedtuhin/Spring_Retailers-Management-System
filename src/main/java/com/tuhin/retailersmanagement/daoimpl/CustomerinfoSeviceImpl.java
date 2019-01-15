/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.CustomerinfoService;
import com.tuhin.retailersmanagement.model.Customerinfo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author C13
 */@Repository
public class CustomerinfoSeviceImpl implements CustomerinfoService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertCustomerinfo(Customerinfo cm) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;    
    }

    @Override
    public String updateCustomerinfo(Customerinfo cm) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(cm);
        t.commit();
        s.close();
        return null;    }

    @Override
    public Integer deleteCustomerinfo(int id) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customerinfo cm = (Customerinfo) s.get(Customerinfo.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;    }

    @Override
    public String viewCustomerinfo() {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Customerinfo> categorieslist = s.createQuery("from Customerinfo").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;     
    }

    @Override
    public Customerinfo viewOneCustomerinfo(int id) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customerinfo cm = (Customerinfo) s.get(Customerinfo.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;    
    }
    
}
