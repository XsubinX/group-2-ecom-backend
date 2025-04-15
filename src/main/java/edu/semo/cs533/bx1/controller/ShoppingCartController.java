package edu.semo.cs533.bx1.controller;

import edu.semo.cs533.bx1.api.ShoppingCartApi;
import edu.semo.cs533.bx1.dao.CartItem;
import edu.semo.cs533.bx1.dao.ShoppingCart;
import edu.semo.cs533.bx1.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/cart")
public class ShoppingCartController implements ShoppingCartApi {

    private final ShoppingCartService service;

    @Autowired
    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    @Override
    @GetMapping(produces = "application/json")
    public ResponseEntity<ShoppingCart> getCart() {
        return ResponseEntity.ok(service.getCart());
    }

    @Override
    @PostMapping(produces = "application/json")
    public ResponseEntity<ShoppingCart> addToCart(CartItem cartItem) {
        ShoppingCart cart = service.getCart();
        cart.addToItems(cartItem);
        return ResponseEntity.ok(service.update(cart));
    }

    @Override
    @DeleteMapping(produces = "application/json")
    public ResponseEntity<Void> removeFromCart(Long cartItemId) {
        return null;
    }
}