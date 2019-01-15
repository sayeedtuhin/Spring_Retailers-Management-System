/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * purchasedetailid, purchaseid, productid, quantity, rate
 *
 * @author R34
 */
@Entity
public class Purchasedetail {

    @Id
    private int purchasedetailid;
    @Column
    private int purchaseid;
    @Column
    private int productid;
    @Column
    private int quantity;
    @Column
    private double price;
    @Transient
    private int totalstock;

    public int getPurchasedetailid() {
        return purchasedetailid;
    }

    public int getTotalstock() {
        return totalstock;
    }

    public void setTotalstock(int totalstock) {
        this.totalstock = totalstock;
    }

    public void setPurchasedetailid(int purchasedetailid) {
        this.purchasedetailid = purchasedetailid;
    }

    public int getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(int purchaseid) {
        this.purchaseid = purchaseid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   

}
