/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.EmployeeinfoService;
import com.tuhin.retailersmanagement.model.Employeeinfo;
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
public class EmployeeinfoServiceImpl implements EmployeeinfoService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertEmployeeinfo(Employeeinfo cm) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;      
    }

    @Override
    public String updateEmployeeinfo(Employeeinfo cm) {
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
    public Integer deleteEmployeeinfo(int id) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Employeeinfo cm = (Employeeinfo) s.get(Employeeinfo.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;     
    }

    @Override
    public String viewEmployeeinfo() {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Employeeinfo> categorieslist = s.createQuery("from Employeeinfo").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;    }

    @Override
    public Employeeinfo viewOneEmployeeinfo(int id) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Employeeinfo cm = (Employeeinfo) s.get(Employeeinfo.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;        }
    
}
