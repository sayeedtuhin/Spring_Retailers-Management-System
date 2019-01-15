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
 * saledetailid, saleid, productid, quantity, rate
 *
 * @author R34
 */
@Entity
public class Saledetail {

    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int saledetailid;
    @Column
    private int saleid;
    @Column
    private int productid;
    @Column
    private int quantity;
    @Column
    private double price;

    public int getSaledetailid() {
        return saledetailid;
    }

    public void setSaledetailid(int saledetailid) {
        this.saledetailid = saledetailid;
    }

    public int getSaleid() {
        return saleid;
    }

    public void setSaleid(int saleid) {
        this.saleid = saleid;
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
