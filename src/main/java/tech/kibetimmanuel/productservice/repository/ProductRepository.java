package tech.kibetimmanuel.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.kibetimmanuel.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
