package za.co.tyaphile.priceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tyaphile.priceapi.model.Product;
import za.co.tyaphile.priceapi.repo.ProductRepo;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return StreamSupport.stream(productRepo.findAll().spliterator(), false).toList();
    }

    public Product getProductById(long id) {
        return productRepo.findById(String.valueOf(id)).orElseThrow();
    }

    public List<Product> getProductsByName(String name) {
        return getAllProducts().stream().filter(x ->
            x.getProduct_name().toLowerCase().contains(name.toLowerCase()) ||
            x.getProduct_description().toLowerCase().contains(name.toLowerCase())
        ).toList();
    }

    public void saveProduct(Product product) {
        productRepo.save(product);
    }
}