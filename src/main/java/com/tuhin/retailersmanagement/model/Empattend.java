/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *empattendid, empid, attenddate, arivaltime, departuretime, overtime
 * @author C13
 */
@Entity
public class Empattend {
 @Id
 private int empattendid;
 
  private int empid;
  
   @Temporal(TemporalType.DATE)
    private Date attenddate;
    private String arivaltime;
   
   
    private String departuretime;
   
  
    private String overtime;
    private String offday;
    
   @Temporal(TemporalType.DATE)
    private Date enddate;

    public String getArivaltime() {
        return arivaltime;
    }

    public void setArivaltime(String arivaltime) {
        this.arivaltime = arivaltime;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }
   
  
   

    public int getEmpattendid() {
        return empattendid;
    }

    public void setEmpattendid(int empattendid) {
        this.empattendid = empattendid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public Date getAttenddate() {
        return attenddate;
    }

    public void setAttenddate(Date attenddate) {
        this.attenddate = attenddate;
    }

    

   

    

   

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getOffday() {
        return offday;
    }

    public void setOffday(String offday) {
        this.offday = offday;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    
    
}
