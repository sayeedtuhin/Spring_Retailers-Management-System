/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Saledetail;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author R34
 */@Service
public interface SaleDetailService {
   public String insertSaledetail(ArrayList<Saledetail> saledetails);

    public String updateSaledetail(int saledetailid, Saledetail saledetails);

    public String deleteSaledetail(int saledetailid);

    public String viewSaledetail();

    public Saledetail viewOneSaledetail(int saledetailid);   
}
