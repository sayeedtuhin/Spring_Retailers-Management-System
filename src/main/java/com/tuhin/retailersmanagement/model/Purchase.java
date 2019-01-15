/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 * purchaseid, vendorid, emailid, date, status, billtotal
 *
 * @author User
 */
@Entity
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int purchaseid;
    @Column
    private int vendorid;
    private String admin;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column
    private String status="purchase";
    @Column
    private double billtotal;
    @Transient
    int productid;
  @Transient
     int quantity;
    @Transient
     double price;
     @Transient
    List<Purchasedetail> purchasedetail;

    public List<Purchasedetail> getPurchasedetail() {
        return purchasedetail;
    }

    public void setPurchasedetail(List<Purchasedetail> purchasedetail) {
        this.purchasedetail = purchasedetail;
    }

   
     

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(int purchaseid) {
        this.purchaseid = purchaseid;
    }

    public int getVendorid() {
        return vendorid;
    }

    public void setVendorid(int vendorid) {
        this.vendorid = vendorid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBilltotal() {
        return billtotal;
    }

    public void setBilltotal(double billtotal) {
        this.billtotal = billtotal;
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
