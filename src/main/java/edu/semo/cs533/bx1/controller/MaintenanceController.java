package edu.semo.cs533.bx1.controller;

import edu.semo.cs533.bx1.api.MaintenanceApi;
import edu.semo.cs533.bx1.service.MaintenanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/maintenance")
public class MaintenanceController implements MaintenanceApi {

    private final MaintenanceService service;

    public MaintenanceController(MaintenanceService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/db/reset")
    public ResponseEntity<Void> resetDatabase() {
        service.resetDatabase();
        return ResponseEntity.ok().build();
    }
}
