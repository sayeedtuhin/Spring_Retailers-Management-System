/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.model;

/**
 *
 * @author R34
 */
public class Cart {
     int pid;
    String pname;
    int qty ;
    double price;
    double total; 

    public Cart(int pid, String pname, int qty, double price, double total) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.total = total;
         this.qty = qty;
    }

    

  

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

  

    
@Override
    public String toString() {
        String s = "pid=" + pid + "!pname=" + pname + "!qty=" + qty + "!price=" + price + "!total=" + total + "!";
        return s;
    }
   
    
}
