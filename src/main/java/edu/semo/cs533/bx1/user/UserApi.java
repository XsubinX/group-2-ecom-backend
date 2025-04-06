package edu.semo.cs533.bx1.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User", description = "The User API")
public interface UserApi {

    @Operation(
            summary = "Fetch all Users",
            description = "fetches all User entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<EcomUser>> list();

    @Operation(
            summary = "Adds a User",
            description = "Adds a User to the list of Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully added a User"),
            @ApiResponse(responseCode = "409", description = "duplicate User")
    })
    ResponseEntity<Void> add(@RequestBody EcomUser user);
}