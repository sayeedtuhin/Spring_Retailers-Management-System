/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.SaleService;
import com.tuhin.retailersmanagement.model.Sale;
import com.tuhin.retailersmanagement.model.Saledetail;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author R34
 */
@Repository
public class SaleServiceImpl implements SaleService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertSale(Sale pm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //Saledetail q = new Saledetail();
//        q.setSaleid(pm.getSaleid());
//        q.setProductid(pm.getProductid());
//        q.setQuantity(pm.getQuantity());
//        q.setRate(pm.getRate());
        s.save(pm);
        //s.save(q);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer updateSale(int saleid, Sale pm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Sale saleobject = (Sale) s.get(Sale.class, saleid);
//        saleobject.setCustomerid(pm.getCustomerid());
//        //saleobject.setEmailid(pm.getEmailid());
//        saleobject.setSaledate(pm.getSaledate());
//        saleobject.setBilltotal(pm.getBilltotal());
//        saleobject.setStatus(pm.getStatus());
//        saleobject.setSaleid(pm.getSaleid());
//
//        saleobject.setProductid(pm.getProductid());
//        saleobject.setQuantity(pm.getRate());
//        saleobject.setRate(pm.getRate());

        s.update(saleobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer deleteSale(int saleid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Sale pm = (Sale) s.get(Sale.class, saleid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewSale() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Sale> productslist = s.createQuery("from Sale").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Sale viewOneSale(int saleid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Sale pm = (Sale) s.get(Sale.class, saleid);
        t.commit();
        s.close();
        return pm;
    }

}
