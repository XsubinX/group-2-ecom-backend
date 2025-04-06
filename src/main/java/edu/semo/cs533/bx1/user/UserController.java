package edu.semo.cs533.bx1.user;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<EcomUser>> list() {
        // var list = service.getAllUsers();
        return ResponseEntity.ok(new ArrayList<>());
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> add(EcomUser user) {
        // service.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}