package com.cattle.xchange.controllers;

import com.cattle.xchange.domain.user.UserService;
import com.cattle.xchange.domain.user.dtos.UserInsertDTO;
import com.cattle.xchange.domain.user.dtos.UserLoginDTO;
import com.cattle.xchange.domain.user.dtos.UserMinDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Insert User",
            description = "Insert User")
    @PostMapping
    public ResponseEntity<UserMinDTO> insert(@RequestBody UserInsertDTO dto) {
        return ResponseEntity.ok(
                new UserMinDTO(service.insert(
                        dto.document(),
                        dto.name(),
                        dto.lastName(),
                        dto.email(),
                        dto.password()
                ))
        );
    }

    @Operation(summary = "Find All Users",
            description = "Find All Users")
    @GetMapping("/")
    public ResponseEntity<List<UserMinDTO>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream().map(UserMinDTO::new).toList()
        );
    }

    @Operation(summary = "Find User by Id",
            description = "Find User by Id")
    @GetMapping("/{id}")
    public ResponseEntity<UserMinDTO> findUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                new UserMinDTO(service.findUserById(id))
        );
    }

    @Operation(summary = "Find User by document",
            description = "Find User by cpf field")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserMinDTO> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(
                new UserMinDTO(service.findByCpf(cpf))
        );
    }

    @Operation(summary = "Login User",
            description = "Login User with email and password")
    @PostMapping("/login")
    public ResponseEntity<UserMinDTO> login(@RequestBody UserLoginDTO dto) {
        return ResponseEntity.ok(
                new UserMinDTO(service.login(dto))
        );
    }
}
