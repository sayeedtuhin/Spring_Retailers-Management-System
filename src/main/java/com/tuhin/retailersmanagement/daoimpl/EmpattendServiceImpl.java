/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.daoimpl;

import com.google.gson.Gson;
import com.tuhin.retailersmanagement.dao.EmpattendService;
import com.tuhin.retailersmanagement.model.Empattend;
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
public class EmpattendServiceImpl implements EmpattendService{
      @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertEmpattend(Empattend pm) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(pm);
        t.commit();
        s.close();
        return null;    
    }

    @Override
    public Integer updateEmpattend(int empattendid, Empattend pm) {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Empattend emp = (Empattend) s.get(Empattend.class, empattendid);
        emp.setEmpid(pm.getEmpid());
       // oneproductobject.setEmailid(pm.getEmailid());
        emp.setAttenddate(pm.getAttenddate());
        emp.setArivaltime(pm.getArivaltime());
        emp.setDeparturetime(pm.getDeparturetime());
         emp.setOvertime(pm.getOvertime());
         emp.setOffday(pm.getOffday());
         emp.setEnddate(pm.getEnddate());

        s.update(emp);
        t.commit();
        s.close();
        return null;    }

    @Override
    public Integer deleteEmpattend(int empattendid) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Empattend pm = (Empattend) s.get(Empattend.class, empattendid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;    }

    @Override
    public String viewEmpattend() {
 Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Empattend> attendList = s.createQuery("from Empattend").list();
        Gson g = new Gson();
        String attendListlistgson = g.toJson(attendList);
        t.commit();
        s.close();
        return attendListlistgson;    }

    @Override
    public Empattend viewOneEmpattend(int empattendid) {
Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Empattend pm = (Empattend) s.get(Empattend.class, empattendid);
        t.commit();
        s.close();
        return pm;       }
    
}
