package com.example.crud.api.controllers;

import com.example.crud.api.dtos.request.RequestProductDTOPost;
import com.example.crud.api.dtos.request.RequestProductDTOUpdate;
import com.example.crud.domain.model.Product;
import com.example.crud.domain.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// indicando que isso e um controller
@RestController

//definindo a endpoint pra classe
@RequestMapping("/products")
public class ProductsController {


    // injetar uma instancia do repository no controller
    @Autowired
    private ProductRepository repository;


    // metodo quando ocorre a requisicao get
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<Product> registerProduct(@RequestBody @Valid RequestProductDTOPost data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        System.out.println(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProductDTOUpdate data) {
        Product product = repository.getReferenceById(data.id());
        product.setName(data.id());
        product.setPrice_in_cents(data.price_in_cents());
        return ResponseEntity.ok(product);
    }

}
