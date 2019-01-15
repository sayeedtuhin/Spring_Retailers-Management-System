/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.PurchaseService;
import com.tuhin.retailersmanagement.model.Purchase;
import com.tuhin.retailersmanagement.model.Purchasedetail;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository

public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPurchase(Purchase pm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //Purchasedetail p = new Purchasedetail();
//        p.setPurchaseid(pm.getPurchaseid());
//       p.setProductid(pm.getProductid());
//       p.setQuantity(pm.getQuantity());
//       p.setPrice(pm.getPrice());
        s.save(pm);
//        s.save(p);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer updatePurchase(int purchaseid, Purchase pm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Purchase oneproductobject = (Purchase) s.get(Purchase.class, purchaseid);
//        oneproductobject.setVendorid(pm.getVendorid());
//        // oneproductobject.setEmailid(pm.getEmailid());
//        oneproductobject.setDate(pm.getDate());
//        oneproductobject.setStatus(pm.getStatus());
//        oneproductobject.setBilltotal(pm.getBilltotal());
////        oneproductobject.setProductid(pm.getPurchaseid());
////
//        oneproductobject.setProductid(pm.getProductid());
//        oneproductobject.setQuantity(pm.getQuantity());
//        oneproductobject.setPrice(pm.getPrice());

        s.update(oneproductobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer deletePurchase(int purchaseid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Purchase pm = (Purchase) s.get(Purchase.class, purchaseid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewPurchase() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Purchase> productslist = s.createQuery("from Purchase").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Purchase viewOnePurchase(int purchaseid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Purchase pm = (Purchase) s.get(Purchase.class, purchaseid);
        t.commit();
        s.close();
        return pm;
    }

}
