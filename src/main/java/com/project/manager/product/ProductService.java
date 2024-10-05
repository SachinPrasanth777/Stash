package com.project.manager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public void save(ProductRequest request) {
        var product = Product.builder()
                .productName(request.getProductName())
                .productDesc(request.getProductDesc())
                .productPrice(request.getProductPrice())
                .productStock(request.getProductStock())
                .build();
        repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Product updateProduct(Integer id, ProductUpdate request) {
        Optional<Product> existingProductOptional = findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setProductName(request.getProductName());
            existingProduct.setProductDesc(request.getProductDesc());
            existingProduct.setProductPrice(request.getProductPrice());
            existingProduct.setProductStock(request.getProductStock());
            return repository.save(existingProduct);
        }
        return null;
    }
}
