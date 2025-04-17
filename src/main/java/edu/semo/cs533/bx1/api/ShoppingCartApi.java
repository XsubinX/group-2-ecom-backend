package edu.semo.cs533.bx1.api;

import edu.semo.cs533.bx1.dao.ShoppingCart;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Shopping Cart", description = "The Shopping Cart API")
public interface ShoppingCartApi {

    @Operation(summary = "Get Shopping Cart by User ID", description = "Retrieves the shopping cart associated with the specified user ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved shopping cart", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Shopping cart not found for user ID")
    })
    ShoppingCart getCartByUserId(@PathVariable Long userId);

    @Operation(summary = "Add Item to Shopping Cart", description = "Adds an item to the shopping cart.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Item added successfully", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Shopping cart or product not found")
    })
    ShoppingCart addItemToCart(@PathVariable Long userId, @RequestParam Long productId, @RequestParam int quantity);

    @Operation(summary = "Remove Item from Shopping Cart", description = "Removes an item from the shopping cart.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Item removed successfully", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Shopping cart or cart item not found")
    })
    ShoppingCart removeItemFromCart(@PathVariable Long userId, @RequestParam Long cartItemId);
}
