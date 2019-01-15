/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.PurchaseDetailService;
import com.tuhin.retailersmanagement.model.Purchasedetail;
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
 */
@Repository
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPurchasedetail(ArrayList<Purchasedetail> purchasedetails) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        for (Purchasedetail pdetails : purchasedetails) {
            s.save(pdetails);
        }
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updatePurchasedetail(int purchasedetailid, Purchasedetail purchasedetails) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Purchasedetail oneproductobject = (Purchasedetail) s.get(Purchasedetail.class, purchasedetailid);
        oneproductobject.setPurchaseid(purchasedetails.getPurchaseid());
        // oneproductobject.setEmailid(pm.getEmailid());
        oneproductobject.setProductid(purchasedetails.getProductid());
        oneproductobject.setQuantity(purchasedetails.getQuantity());
        oneproductobject.setPrice(purchasedetails.getPrice());
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
    public String deletePurchasedetail(int purchasedetailid) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Purchasedetail pm = (Purchasedetail) s.get(Purchasedetail.class, purchasedetailid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewPurchasedetail() {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Purchasedetail> productslist = s.createQuery("from Purchasedetail").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Purchasedetail viewOnePurchasedetail(int purchasedetailid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Purchasedetail pm = (Purchasedetail) s.get(Purchasedetail.class, purchasedetailid);
        t.commit();
        s.close();
        return pm;
    }

}
