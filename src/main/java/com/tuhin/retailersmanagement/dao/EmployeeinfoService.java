/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Employeeinfo;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */@Service
public interface EmployeeinfoService {
    public String insertEmployeeinfo(Employeeinfo cm);

    public String updateEmployeeinfo(Employeeinfo cm);

    public Integer deleteEmployeeinfo(int id);

    public String viewEmployeeinfo();

    public Employeeinfo viewOneEmployeeinfo(int id);  
}
