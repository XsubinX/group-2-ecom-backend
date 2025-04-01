package edu.semo.cs533.bx1.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Product", description = "The product API")
public interface ProductApi {

    @Operation(
            summary = "Fetch all products",
            description = "fetches all product entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<Product>> list();

    @Operation(
            summary = "Adds a product",
            description = "Adds a product to the list of products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully added a product"),
            @ApiResponse(responseCode = "409", description = "duplicate product")
    })
    ResponseEntity<Void> add(@RequestBody Product product);
}