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
 * @author User
 */
@Entity
public class Employeeinfo {

    @Id
    private int empid;
    @Column
    private String empname;
    @Column
    private String empaddress;
    @Column
    private String empnid;
    @Column
    private String empgender;
    @Column
    private String empphone;
    @Column
    private String empmail;
    @Transient
    MultipartFile pimage;

    public MultipartFile getPimage() {
        return pimage;
    }

    public void setPimage(MultipartFile pimage) {
        this.pimage = pimage;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpaddress() {
        return empaddress;
    }

    public void setEmpaddress(String empaddress) {
        this.empaddress = empaddress;
    }

    public String getEmpnid() {
        return empnid;
    }

    public void setEmpnid(String empnid) {
        this.empnid = empnid;
    }

    public String getEmpgender() {
        return empgender;
    }

    public void setEmpgender(String empgender) {
        this.empgender = empgender;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }

    public String getEmpmail() {
        return empmail;
    }

    public void setEmpmail(String empmail) {
        this.empmail = empmail;
    }

}
