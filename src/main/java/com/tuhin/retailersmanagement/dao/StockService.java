/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Stock;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author R34
 */@Service
public interface StockService {
    public String insertStock(ArrayList<Stock> stocks);

    public Integer updateStock(int stockid, Stock pm);

    public Integer deleteStock(int stockid);

    public String viewStock();

    public Stock viewOneStock(int stockid); 
    public int showstock();
}
