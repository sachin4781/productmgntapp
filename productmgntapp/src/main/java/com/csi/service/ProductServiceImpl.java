package com.csi.service;

import com.csi.model.Product;
import com.csi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    @Autowired
    ProductRepo productRepoImpl;

    public Product savedata(Product product) {
        return productRepoImpl.save(product);
    }

    public List<Product> getalldata() {
        return productRepoImpl.findAll();
    }

    public Optional<Product> getdatabyid(int productid) {
        return productRepoImpl.findById(productid);
    }

    public List<Product> getdatabyname(String productname) {
        return getalldata().stream().filter(prod -> prod.getProductname().equals(productname)).collect(Collectors.toList());
    }

    public List<Product> sortbyname() {
        return getalldata().stream().sorted(Comparator.comparing(Product::getProductname)).collect(Collectors.toList());
    }

    public List<Product> sortbyprice() {
        return getalldata().stream().sorted(Comparator.comparingDouble(Product::getProductprice)).collect(Collectors.toList());
    }

    public Product updatedata(Product product) {
        return productRepoImpl.save(product);
    }

    public void deletedatabyid(int productid) {
        productRepoImpl.deleteById(productid);
    }

    public void deletealldata() {
        productRepoImpl.deleteAll();
    }

}
