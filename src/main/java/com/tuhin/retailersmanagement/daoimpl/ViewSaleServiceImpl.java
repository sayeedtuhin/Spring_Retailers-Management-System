/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.ViewSaleService;
import com.tuhin.retailersmanagement.model.Sale;
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
public class ViewSaleServiceImpl implements ViewSaleService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String updateSaleservice(int saleid, Sale sale) {
 return null;   
    }

    @Override
    public String deleteSaleservice(int saleid) {
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
    public String viewSaleservice() {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Sale> saleList = s.createQuery("from Sale order by saleid").list();
        List<Saledetail> saleDetailList = s.createQuery("from Saledetail order by saleid").list();
        //adding blank orderdetails
        for (int i = 0; i < saleList.size(); i++) {
            saleList.get(i).setSaledetail(new ArrayList<Saledetail>());
        }
        List<Integer> parentId = new ArrayList<>();
        List<Integer> childId = new ArrayList<>();
        //list all orderid from order
        for (int i = 0; i < saleList.size(); i++) {
            parentId.add(saleList.get(i).getSaleid());            
        }
        //list all orderid from orderdetails
        for (int i = 0; i < saleDetailList.size(); i++) {
            childId.add(saleDetailList.get(i).getSaleid());            
        }
        //List<OrderDetails> subchild;
        try {
            int index=0;
            for (Integer i : childId) {
            if (parentId.contains(i)) {
                //subchild = new ArrayList<>();
                System.out.println(parentId.indexOf(i)+" Match Found " + i);
                //subchild.add(orderDetailList.get(index));                
                saleList.get(parentId.indexOf(i)).getSaledetail().add(saleDetailList.get(index));
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
        String orderListgson = g.toJson(saleList);
        t.commit();
        s.close();
        System.out.println("-----"+orderListgson);
        return orderListgson;       
        
    
    }

    @Override
    public Sale viewOneSaleservice(int saleid) {
return null;    
    
    }

    @Override
    public int showallsel() {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Sale> st = s.createQuery("from Sale").list();
        int a=st.size();
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return a;     
    }
    
}
