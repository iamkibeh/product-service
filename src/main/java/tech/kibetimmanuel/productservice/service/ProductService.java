package tech.kibetimmanuel.productservice.service;

import tech.kibetimmanuel.productservice.dto.ProductRequest;
import tech.kibetimmanuel.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
}
