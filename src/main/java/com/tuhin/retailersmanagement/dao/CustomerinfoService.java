/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Customerinfo;
import org.springframework.stereotype.Service;

/**
 *
 * @author C13
 */@Service
public interface CustomerinfoService {
   public String insertCustomerinfo(Customerinfo cm);

    public String updateCustomerinfo(Customerinfo cm);

    public Integer deleteCustomerinfo(int id);

    public String viewCustomerinfo();

    public Customerinfo viewOneCustomerinfo(int id);  
}
