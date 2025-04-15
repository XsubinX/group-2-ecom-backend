package edu.semo.cs533.bx1.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Maintenance", description = "The Maintenance API")
public interface MaintenanceApi {

    @Operation(
            summary = "Reset the database",
            description = "This operation resets the database to its initial state by clearing all data "
                    + "and reinitializing necessary values.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Database successfully reset"),
            @ApiResponse(responseCode = "500", description = "Error occurred while resetting the database")
    })
    ResponseEntity<Void> resetDatabase();
}
