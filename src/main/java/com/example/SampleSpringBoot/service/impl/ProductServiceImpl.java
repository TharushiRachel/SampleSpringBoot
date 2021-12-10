package com.example.SampleSpringBoot.service.impl;

import com.example.SampleSpringBoot.entity.Product;
import com.example.SampleSpringBoot.repository.ProductRepository;
import com.example.SampleSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) throws Exception {
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    @Override
    public Product findProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(String id) {
       boolean exists = productRepository.existsById(id);
       if(!exists){
           throw new IllegalStateException("Product with id "+id+" does not exists");
       }

      productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) throws Exception {

        Product productDb = productRepository.findById(product.getId()).orElseThrow(() ->{
            throw new IllegalStateException("Product with " +product.getId()+ " does not exists");
        });

        productDb.setName(product.getName());
        productDb.setPrice(product.getPrice());
        productDb.setQuantity(product.getQuantity());

        return productRepository.save(productDb);
    }

    @Override
    public void retrieveProduct(Date date) {

    }
}
