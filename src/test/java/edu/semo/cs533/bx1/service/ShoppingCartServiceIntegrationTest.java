package edu.semo.cs533.bx1.service;

import edu.semo.cs533.bx1.dao.CartItem;
import edu.semo.cs533.bx1.dao.Category;
import edu.semo.cs533.bx1.dao.EcomUser;
import edu.semo.cs533.bx1.dao.Product;
import edu.semo.cs533.bx1.dao.ShoppingCart;
import edu.semo.cs533.bx1.repository.CartItemRepository;
import edu.semo.cs533.bx1.repository.CategoryRepository;
import edu.semo.cs533.bx1.repository.ProductRepository;
import edu.semo.cs533.bx1.repository.ShoppingCartRepository;
import edu.semo.cs533.bx1.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShoppingCartServiceIntegrationTest {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    void addItemToCartTest() {
        EcomUser user = new EcomUser();
        user = userRepository.save(user);

        Category category = new Category();
        category.setName("TVs");
        category = categoryRepository.save(category);

        Product product = new Product("Test Product", "A test product description", 10.0, category, "image_url");
        product = productRepository.save(product);

        ShoppingCart cart = new ShoppingCart();
        cart.setUser(user);
        shoppingCartRepository.save(cart);

        ShoppingCart updatedCart = shoppingCartService.addItemToCart(user.getId(), product.getId(), 5);

        Assertions.assertNotNull(updatedCart);
        Assertions.assertFalse(updatedCart.getItems().isEmpty());
        Assertions.assertEquals(5, updatedCart.getItems().get(0).getQuantity());
        Assertions.assertEquals(product.getId(), updatedCart.getItems().get(0).getProduct().getId());
    }

    @Test
    @Transactional
    void removeItemFromCartTest() {
        EcomUser user = new EcomUser();
        user = userRepository.save(user);

        Category category = new Category();
        category.setName("TVs");
        category = categoryRepository.save(category);

        Product product = new Product("Test Product", "A test product description", 10.0, category, "image_url");
        product = productRepository.save(product);

        ShoppingCart cart = new ShoppingCart();
        cart.setUser(user);
        shoppingCartRepository.save(cart);

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(3);
        cartItem = cartItemRepository.save(cartItem);

        cart.getItems().add(cartItem);
        shoppingCartRepository.save(cart);

        ShoppingCart updatedCart = shoppingCartService.removeItemFromCart(user.getId(), cartItem.getCartItemId());

        Assertions.assertNotNull(updatedCart);
        Assertions.assertTrue(updatedCart.getItems().isEmpty());
    }
}
