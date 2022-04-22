package br.com.hetso.springjwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Example endpoints")
@RestController
@RequestMapping(value = "/api/example")
public class ExampleController {
    
    @Operation(summary = "Public endpoint without need authentication")
    @GetMapping("/public")
    public ResponseEntity<String> publicAccess() {
        return ResponseEntity.ok("Success public access");
    }

    @Operation(summary = "Private endpoint with need authentication")
    @GetMapping("/authenticated")
    public ResponseEntity<String> authenticatedAccess() {
        return ResponseEntity.ok("Success authenticated access");
    }

    @Operation(summary = "Private endpoint with need authentication and MANAGER or ADMIN permission")
    @GetMapping("/manager")
    public ResponseEntity<String> managerAccess() {
        return ResponseEntity.ok("Success manager access");
    }

    @Operation(summary = "Private endpoint with need authentication and ADMIN permission")
    @GetMapping("/admin")
    public ResponseEntity<String> adminAccess() {
        return ResponseEntity.ok("Success admin access");
    }
}
