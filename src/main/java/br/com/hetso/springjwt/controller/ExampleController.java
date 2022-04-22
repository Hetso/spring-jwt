package br.com.hetso.springjwt.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/example")
public class ExampleController {
    
    @GetMapping("/public")
    public ResponseEntity<String> publicAccess() {
        return ResponseEntity.ok("Success public access");
    }

    @GetMapping("/authenticated")
    public ResponseEntity<String> authenticatedAccess() {
        return ResponseEntity.ok("Success authenticated access");
    }

    @GetMapping("/manager")
    public ResponseEntity<String> managerAccess() {
        return ResponseEntity.ok("Success manager access");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> adminAccess() {
        return ResponseEntity.ok("Success admin access");
    }
}
