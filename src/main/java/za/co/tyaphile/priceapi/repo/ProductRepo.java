package za.co.tyaphile.priceapi.repo;

import org.springframework.data.repository.CrudRepository;
import za.co.tyaphile.priceapi.model.Product;

public interface ProductRepo extends CrudRepository<Product, String> { }