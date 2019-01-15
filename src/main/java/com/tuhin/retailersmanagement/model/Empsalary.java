/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author C13
 */
@Entity
public class Empsalary {

    @Id
    private int salaryid;
    @Column
    private int empid;
    @Column
    private String month;
     @Temporal(TemporalType.DATE)

    private Date salarydate;
    @Column
    private double basicsalary;
    @Column
    private double overtimepayment;
    @Column
    private double incentives;
    @Column
    private double total;
    
    public int getSalaryid() {
        return salaryid;
    }

    public void setSalaryid(int salaryid) {
        this.salaryid = salaryid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    

    public Date getSalarydate() {
        return salarydate;
    }

    public void setSalarydate(Date salarydate) {
        this.salarydate = salarydate;
    }

    public double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public double getOvertimepayment() {
        return overtimepayment;
    }

    public void setOvertimepayment(double overtimepayment) {
        this.overtimepayment = overtimepayment;
    }

    public double getIncentives() {
        return incentives;
    }

    public void setIncentives(double incentives) {
        this.incentives = incentives;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   
   

}
