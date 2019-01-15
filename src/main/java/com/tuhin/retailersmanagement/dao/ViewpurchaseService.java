/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Purchase;
import org.springframework.stereotype.Service;

/**
 *
 * @author R34
 */@Service
public interface ViewpurchaseService {
   public String updatePurchaseservice(int purchaseid, Purchase purchase);

    public String deletePurchaseservice(int purchaseid);

    public String viewPurchaseservice();

    public Purchase viewOnePurchaseservice(int purchaseid);
    public int showallpurchase();
}
