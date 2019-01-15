/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * stockid, productid, totalstock
 * @author R34
 */@Entity
public class Stock {
  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private int stockid;
  @Column
  private int productid;
  @Column
   private int totalstock;

    public int getStockid() {
        return stockid;
    }

    public void setStockid(int stockid) {
        this.stockid = stockid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getTotalstock() {
        return totalstock;
    }

    public void setTotalstock(int totalstock) {
        this.totalstock = totalstock;
    }
  
}
