package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {


    @Autowired
    ProductServiceImpl productServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Product> savedata(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productServiceImpl.savedata(product));
    }


    @GetMapping("/getalldata")
    public ResponseEntity<List<Product>> getalldata() {
        return ResponseEntity.ok(productServiceImpl.getalldata());
    }

    @GetMapping("/getdatabyid/{productid}")

    public ResponseEntity<Optional<Product>> getdatabyid(@PathVariable int productid) {
        return ResponseEntity.ok(productServiceImpl.getdatabyid(productid));
    }

    @GetMapping("/getdatabyname/{productname}")

    public ResponseEntity<List<Product>> getdatabyname(@Valid @PathVariable String productname) {
        return ResponseEntity.ok(productServiceImpl.getdatabyname(productname));
    }

    @GetMapping("/sortbyname")

    public ResponseEntity<List<Product>> sortbyname() {
        return ResponseEntity.ok(productServiceImpl.sortbyname());
    }

    @GetMapping("/sortbyprice")
    public ResponseEntity<List<Product>> sortbyprice() {
        return ResponseEntity.ok(productServiceImpl.sortbyprice());
    }

    @PutMapping("/updatedata/{productid}")

    public ResponseEntity<Product> updatedata(@Valid @RequestBody Product product, @PathVariable int productid) {

        Product product1 = productServiceImpl.getdatabyid(productid).orElseThrow(() -> new RecordNotFoundException("Product Id Does Not Exist.."));

        product1.setProductid(product.getProductid());
        product1.setProductcode(product.getProductcode());
        product1.setProductname(product.getProductname());
        product1.setProductprice(product.getProductprice());
        product1.setProductlaunchdate(product.getProductlaunchdate());

        return new ResponseEntity<>(productServiceImpl.updatedata(product1), HttpStatus.CREATED);

    }

    @DeleteMapping("/deletedatabyid/{productid}")

    public ResponseEntity<String> deletedatabyid(@PathVariable int productid) {
        productServiceImpl.deletedatabyid(productid);
        return ResponseEntity.ok("Data Deleted SuccessFully...");
    }

    @DeleteMapping("deleteall")
    public ResponseEntity<String> deletealldata() {
        productServiceImpl.deletealldata();
        return ResponseEntity.ok("All Data Deleted SuccessFully..");
    }


}
