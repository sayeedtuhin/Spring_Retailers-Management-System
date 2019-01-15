/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.ProductService;
import com.tuhin.retailersmanagement.model.Product;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertProduct(Product cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateProduct(Product cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer deleteProduct(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Product cm = (Product) s.get(Product.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewProduct() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Product> categorieslist = s.createQuery("from Product").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public Product viewOneProduct(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Product cm = (Product) s.get(Product.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    @Override
    public String viewProductt(int id) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Product> categorieslist = s.createQuery("select sum(quantity) as quantity from Purchasedetail where productid in (select productid,producttype from Product where productid=:id)").setParameter("id", id).list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;     
    }

}
