/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.VendorService;
import com.tuhin.retailersmanagement.model.Product;
import com.tuhin.retailersmanagement.model.Vendorinfo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */@Repository
public class VendorServiceImpl implements VendorService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertVendorinfo(Vendorinfo cm) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;    }

    @Override
    public String updateVendorinfo(Vendorinfo cm) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(cm);
        t.commit();
        s.close();
        return null;    }

    @Override
    public Integer deleteVendorinfo(int id) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Vendorinfo cm = (Vendorinfo) s.get(Vendorinfo.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;    }

    @Override
    public String viewVendorinfo() {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Vendorinfo> categorieslist = s.createQuery("from Vendorinfo").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;    }

    @Override
    public Vendorinfo viewOneVendorinfo(int id) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Vendorinfo cm = (Vendorinfo) s.get(Vendorinfo.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;//To change body of generated methods, choose Tools | Templates.
    }
    
}
