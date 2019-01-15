/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Sale;
import org.springframework.stereotype.Service;

/**
 *
 * @author R34
 */@Service
public interface ViewSaleService {
  public String updateSaleservice(int saleid, Sale sale);

    public String deleteSaleservice(int saleid);

    public String viewSaleservice();

    public Sale viewOneSaleservice(int saleid); 
     public int showallsel();
}
