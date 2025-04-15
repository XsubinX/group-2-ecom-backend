package edu.semo.cs533.bx1.api;

import edu.semo.cs533.bx1.dao.CartItem;
import edu.semo.cs533.bx1.dao.ShoppingCart;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Shopping Cart", description = "The Shopping Cart API")
public interface ShoppingCartApi {

    @Operation(
            summary = "Get cart",
            description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<ShoppingCart> getCart();

    @Operation(
            summary = "Adds an item to cart",
            description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "success"),
            @ApiResponse(responseCode = "409", description = "duplicate")
    })
    ResponseEntity<ShoppingCart> addToCart(@RequestBody CartItem cartItem);

    @Operation(
            summary = "Removes an item from the cart",
            description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "success"),
            @ApiResponse(responseCode = "409", description = "duplicate")
    })
    ResponseEntity<Void> removeFromCart(Long cartItemId);
}