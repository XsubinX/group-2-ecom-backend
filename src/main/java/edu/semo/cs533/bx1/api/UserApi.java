package edu.semo.cs533.bx1.api;

import edu.semo.cs533.bx1.dao.EcomUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "User", description = "The User API")
public interface UserApi {

    @Operation(
            summary = "Fetch current user",
            description = "Fetch current user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<EcomUser> getCurrentUser();

}