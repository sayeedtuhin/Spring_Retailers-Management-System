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
 * receiveid, customerid, saleid, user, ammount, date, remarks
 * @author R34
 */@Entity
public class Receivepayment {
  @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int  receiveid;
  @Column
  private int  customerid;
  @Column
 private int  saleid; 
   @Column
  private String  user;
    @Column
    private double  ammount;
    @Temporal(TemporalType.DATE)
    private Date date;
     @Column
     private String  remarks;
      @Column 
     private String status="Receive Success";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(int receiveid) {
        this.receiveid = receiveid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getSaleid() {
        return saleid;
    }

    public void setSaleid(int saleid) {
        this.saleid = saleid;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
        
}
