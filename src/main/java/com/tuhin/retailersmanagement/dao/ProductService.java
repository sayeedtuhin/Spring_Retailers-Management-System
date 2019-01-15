/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuhin.retailersmanagement.dao;

import com.tuhin.retailersmanagement.model.Product;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */@Service
public interface ProductService {
   public String insertProduct(Product cm);

    public String updateProduct(Product cm);

    public Integer deleteProduct(int id);

    public String viewProduct();
public String viewProductt(int id);
    public Product viewOneProduct(int id); 
}
