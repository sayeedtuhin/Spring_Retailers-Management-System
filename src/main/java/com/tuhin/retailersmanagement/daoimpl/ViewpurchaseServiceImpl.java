/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.ViewpurchaseService;
import com.tuhin.retailersmanagement.model.Purchase;
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
 */@Repository
public class ViewpurchaseServiceImpl implements ViewpurchaseService{
      @Autowired
    SessionFactory sessionFactory;

    @Override
    public String updatePurchaseservice(int purchaseid, Purchase purchase) {
    return null;    
    }

    @Override
    public String deletePurchaseservice(int purchaseid) {
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
    public String viewPurchaseservice() {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Purchase> purchaseList = s.createQuery("from Purchase order by purchaseid").list();
        List<Purchasedetail> purchaseDetailList = s.createQuery("from Purchasedetail order by purchaseid").list();
        //adding blank orderdetails
        for (int i = 0; i < purchaseList.size(); i++) {
            purchaseList.get(i).setPurchasedetail(new ArrayList<Purchasedetail>());
        }
        List<Integer> parentId = new ArrayList<>();
        List<Integer> childId = new ArrayList<>();
        //list all orderid from order
        for (int i = 0; i < purchaseList.size(); i++) {
            parentId.add(purchaseList.get(i).getPurchaseid());            
        }
        //list all orderid from orderdetails
        for (int i = 0; i < purchaseDetailList.size(); i++) {
            childId.add(purchaseDetailList.get(i).getPurchaseid());            
        }
        //List<OrderDetails> subchild;
        try {
            int index=0;
            for (Integer i : childId) {
            if (parentId.contains(i)) {
                //subchild = new ArrayList<>();
                System.out.println(parentId.indexOf(i)+" Match Found " + i);
                //subchild.add(orderDetailList.get(index));                
                purchaseList.get(parentId.indexOf(i)).getPurchasedetail().add(purchaseDetailList.get(index));
                index++;
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //orderList.addAll(orderDetailList);
        //for (int i = 0; i < orderDetailList.size(); i++) {
            //if(orderList.get(i).getOrderid()!=0)
            //if(orderDetailList.get(i).getOrderid()==orderList.get(i).getOrderid()){
            //orderList.get(0).setOrderDetails(orderDetailList);
            //}            
        //}
        Gson g = new Gson();
        String orderListgson = g.toJson(purchaseList);
        t.commit();
        s.close();
        System.out.println("-----"+orderListgson);
        return orderListgson;       
    
    }

    @Override
    public Purchase viewOnePurchaseservice(int purchaseid) {
   return null;
    }

    @Override
    public int showallpurchase() {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Purchase> st = s.createQuery("from Purchase").list();
        int a=st.size();
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return a;   
    }
    
}
