/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Vendorinfo;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */@Service
public interface VendorService {
   public String insertVendorinfo(Vendorinfo cm);

    public String updateVendorinfo(Vendorinfo cm);

    public Integer deleteVendorinfo(int id);

    public String viewVendorinfo();

    public Vendorinfo viewOneVendorinfo(int id);  
}
