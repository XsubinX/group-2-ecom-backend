package edu.semo.cs533.bx1.controller;

import edu.semo.cs533.bx1.api.UserApi;
import edu.semo.cs533.bx1.dao.EcomUser;
import edu.semo.cs533.bx1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/users")
public class UserController implements UserApi {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    @GetMapping(path = "/currentUser", produces = "application/json")
    public ResponseEntity<EcomUser> getCurrentUser() {
        return ResponseEntity.ok(service.getCurrentUser());
    }

}