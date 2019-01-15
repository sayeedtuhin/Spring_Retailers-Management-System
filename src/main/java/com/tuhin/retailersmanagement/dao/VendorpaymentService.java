/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Vendorpayment;
import org.springframework.stereotype.Service;

/**
 *
 * @author R34
 */@Service
public interface VendorpaymentService {
   public String insertVendorpayment(Vendorpayment pm);

    public Integer updateVendorpayment(int vendorpaymentid, Vendorpayment pm);

    public Integer deleteVendorpayment(int vendorpaymentid);

    public String viewVendorpayment();

    public Vendorpayment viewOneVendorpayment(int vendorpaymentid);  
}
