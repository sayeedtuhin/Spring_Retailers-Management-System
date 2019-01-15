/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.SaleDetailService;
import com.tuhin.retailersmanagement.model.Saledetail;
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
public class SaleDetailServiceImpl implements SaleDetailService{
  @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertSaledetail(ArrayList<Saledetail> saledetails) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        for (Saledetail details : saledetails) {
            s.save(details);
        }
        t.commit();
        s.close();
        return null;    }

    @Override
    public String updateSaledetail(int saledetailid, Saledetail saledetails) {
    Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Saledetail oneproductobject = (Saledetail) s.get(Saledetail.class, saledetailid);
//        oneproductobject.setPurchaseid(purchasedetails.getPurchaseid());
//        // oneproductobject.setEmailid(pm.getEmailid());
//        oneproductobject.setProductid(purchasedetails.getProductid());
//        oneproductobject.setQuantity(purchasedetails.getQuantity());
//        oneproductobject.setPrice(purchasedetails.getPrice());
//        oneproductobject.setProductid(pm.getPurchaseid());
//
//        oneproductobject.setProductid(pm.getProductid());
//        oneproductobject.setQuantity(pm.getRate());
//        oneproductobject.setRate(pm.getRate());

        s.update(oneproductobject);
        t.commit();
        s.close();
        return null;   
    }

    @Override
    public String deleteSaledetail(int saledetailid) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Saledetail pm = (Saledetail) s.get(Saledetail.class, saledetailid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;    
    }

    @Override
    public String viewSaledetail() {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Saledetail> productsdetaillist = s.createQuery("from Saledetail").list();
        Gson g = new Gson();
        String productsdetaillistgson = g.toJson(productsdetaillist);
        t.commit();
        s.close();
        return productsdetaillistgson;    
    }

    @Override
    public Saledetail viewOneSaledetail(int saledetailid) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Saledetail pm = (Saledetail) s.get(Saledetail.class, saledetailid);
        t.commit();
        s.close();
        return pm;    }

  
}
