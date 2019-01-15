/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * vendorpaymentid, vendorid, user, ammount, paydate, remarks, purchaseid
 * @author R34
 */@Entity
public class Vendorpayment {
  @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int  vendorpaymentid;
  @Column
  private int  vendorid;
   @Column
  private String  user;
    @Column
    private double  ammount;
    @Temporal(TemporalType.DATE)
    private Date paydate;
     @Column
     private String  remarks;
      @Column
 private int  purchaseid;
      @Column
      private String status="payment success";

    public int getVendorpaymentid() {
        return vendorpaymentid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVendorpaymentid(int vendorpaymentid) {
        this.vendorpaymentid = vendorpaymentid;
    }

    public int getVendorid() {
        return vendorid;
    }

    public void setVendorid(int vendorid) {
        this.vendorid = vendorid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(int purchaseid) {
        this.purchaseid = purchaseid;
    }

}
