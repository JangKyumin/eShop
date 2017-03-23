package com.numbedme.app.service.impl;

import com.numbedme.app.model.Customer;
import com.numbedme.app.model.Product;
import com.numbedme.app.repository.CustomerRepository;
import com.numbedme.app.repository.ProductRepository;
import com.numbedme.app.service.ProductService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 15.02.2017.
 */

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        repository.updateProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        repository.deleteProduct(product);
    }

    @Override
    public void persistProduct(Product product) {
        repository.persistProduct(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return repository.findAllProducts();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findByPattern(String pattern) {
        return repository.findByPattern(pattern);
    }

    @Override
    public List<Product> findCustomerProducts(Customer customer) {
        if (customer == null){
            throw new NullPointerException("Customer entity is null");
        }
        Hibernate.initialize(customer);
        return customer.getProducts();
    }
}
