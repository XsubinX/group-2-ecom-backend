package edu.semo.cs533.bx1.product;

import java.util.List;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/v1/products")
public class ProductController implements ProductApi {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @Override
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Product>> list() {
        var list = service.getAllProducts();
        return ResponseEntity.ok(list);
    }

    @Override
    @PostMapping
    public ResponseEntity<Product> add(Product product, UriComponentsBuilder uriBuilder) {
        val saved = service.saveProduct(product);
        var location = uriBuilder
                .path("/products/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(saved);
    }
}