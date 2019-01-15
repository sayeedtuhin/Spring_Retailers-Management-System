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
 * @author User
 */@Service
public interface PurchaseService {
     public String insertPurchase(Purchase pm);

    public Integer updatePurchase(int purchaseid, Purchase pm);

    public Integer deletePurchase(int purchaseid);

    public String viewPurchase();

    public Purchase viewOnePurchase(int purchaseid);
}
