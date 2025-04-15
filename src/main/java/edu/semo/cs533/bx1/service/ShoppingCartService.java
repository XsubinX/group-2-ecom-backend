package edu.semo.cs533.bx1.service;

import edu.semo.cs533.bx1.dao.ShoppingCart;
import edu.semo.cs533.bx1.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository repository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository repository) {
        this.repository = repository;
    }

    public ShoppingCart getCart() {
        return repository.findAll().stream().findFirst().orElseThrow(RuntimeException::new);
    }

    public ShoppingCart update(ShoppingCart cart) {
        return repository.save(cart);
    }
}
