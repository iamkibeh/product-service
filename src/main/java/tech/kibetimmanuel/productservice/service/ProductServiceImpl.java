package tech.kibetimmanuel.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.kibetimmanuel.productservice.dto.ProductRequest;
import tech.kibetimmanuel.productservice.dto.ProductResponse;
import tech.kibetimmanuel.productservice.model.Product;
import tech.kibetimmanuel.productservice.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepo;
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepo.save(product);
        log.info("Product with id {} created", product.getId());
        return mapProductToDto(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(this::mapProductToDto).toList();
    }

    private ProductResponse mapProductToDto(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
