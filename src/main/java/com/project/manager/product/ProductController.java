package com.project.manager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.manager.config.ResponseMessage;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> saveProduct(@RequestBody ProductRequest request) {
        productService.save(request);
        return new ResponseEntity<>(new ResponseMessage("Product saved successfully"), HttpStatus.CREATED);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        Optional<Product> productOptional = productService.findById(id);
        return productOptional
                .map(product -> new ResponseEntity<>(new ProductResponse(product), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> deleteProductById(@PathVariable Integer id) {
        boolean isDeleted = productService.deleteById(id);
        if (isDeleted) {
            return new ResponseEntity<>(new ResponseMessage("Product deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseMessage("Product not found"), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer id, @RequestBody ProductUpdate request) {
        Product updatedProduct = productService.updateProduct(id, request);
        if (updatedProduct != null) {
            return new ResponseEntity<>(new ProductResponse(updatedProduct), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
