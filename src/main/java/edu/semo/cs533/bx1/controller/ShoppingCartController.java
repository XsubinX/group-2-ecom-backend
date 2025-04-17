package edu.semo.cs533.bx1.controller;

import edu.semo.cs533.bx1.api.ShoppingCartApi;
import edu.semo.cs533.bx1.dao.ShoppingCart;
import edu.semo.cs533.bx1.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cart")
public class ShoppingCartController implements ShoppingCartApi {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    @GetMapping("/{userId}")
    public ShoppingCart getCartByUserId(@PathVariable Long userId) {
        return shoppingCartService.getCartByUserId(userId);
    }

    @Override
    @PostMapping("/{userId}/item")
    public ShoppingCart addItemToCart(@PathVariable Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity) {
        return shoppingCartService.addItemToCart(userId, productId, quantity);
    }

    @Override
    @DeleteMapping("/{userId}/item")
    public ShoppingCart removeItemFromCart(@PathVariable Long userId,
            @RequestParam Long cartItemId) {
        return shoppingCartService.removeItemFromCart(userId, cartItemId);
    }
}
