/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Receivepayment;
import org.springframework.stereotype.Service;

/**
 *
 * @author R34
 */@Service
public interface ReceivepaymentService {
  public String insertReceivepayment(Receivepayment pm);

    public Integer updateReceivepayment(int receiveid, Receivepayment pm);

    public Integer deleteReceivepayment(int receiveid);

    public String viewReceivepayment();

    public Receivepayment viewOneReceivepayment(int receiveid);   
}
