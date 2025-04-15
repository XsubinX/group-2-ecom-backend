package edu.semo.cs533.bx1.service;

import edu.semo.cs533.bx1.dao.EcomUser;
import edu.semo.cs533.bx1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public EcomUser getCurrentUser() {
        return repository.findAll().stream().findFirst().orElseThrow(RuntimeException::new);
    }
}

