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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author C13
 */
@Entity
public class Customerinfo {

    @Id
    private int customerid;
    @Column
    private String customername;
    @Column
    private String customeraddress;
    @Column
    private String customerphone;
    @Column
    private String shopname;
    @Transient
    MultipartFile pimage;

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public MultipartFile getPimage() {
        return pimage;
    }

    public void setPimage(MultipartFile pimage) {
        this.pimage = pimage;
    }

}
