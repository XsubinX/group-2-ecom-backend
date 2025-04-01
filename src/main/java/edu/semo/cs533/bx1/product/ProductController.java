package edu.semo.cs533.bx1.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        var t = service.list();
        return ResponseEntity.ok(t);
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> add(Product product) {
        var result = service.add(product);
        if (result == -1) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}