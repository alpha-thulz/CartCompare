package za.co.tyaphile.priceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tyaphile.priceapi.model.Product;
import za.co.tyaphile.priceapi.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/v1/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/api/v1/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/api/v1/products/{value}")
    public List<Product> getProducts(@PathVariable String value) {
        return productService.getProductsByName(value);
    }

    @PostMapping("/api/v1/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(product);
    }
}