package edu.semo.cs533.bx1.service;

import edu.semo.cs533.bx1.dao.CartItem;
import edu.semo.cs533.bx1.dao.Product;
import edu.semo.cs533.bx1.dao.ShoppingCart;
import edu.semo.cs533.bx1.repository.CartItemRepository;
import edu.semo.cs533.bx1.repository.ProductRepository;
import edu.semo.cs533.bx1.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository,
            CartItemRepository cartItemRepository,
            ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public ShoppingCart addItemToCart(Long userId, Long productId, int quantity) {
        ShoppingCart cart = getCartByUserId(userId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        cartItemRepository.save(cartItem);
        cart.getItems().add(cartItem);
        return shoppingCartRepository.save(cart);
    }

    public ShoppingCart removeItemFromCart(Long userId, Long cartItemId) {
        ShoppingCart cart = getCartByUserId(userId);
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found: " + cartItemId));

        cart.getItems().remove(cartItem);
        cartItemRepository.delete(cartItem);
        return shoppingCartRepository.save(cart);
    }

    public ShoppingCart getCartByUserId(Long userId) {
        return shoppingCartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user: " + userId));
    }

    public ShoppingCart getCart() {
        return shoppingCartRepository.findAll().stream().findFirst().orElseThrow(RuntimeException::new);
    }

    public ShoppingCart update(ShoppingCart cart) {
        return shoppingCartRepository.save(cart);
    }
}
