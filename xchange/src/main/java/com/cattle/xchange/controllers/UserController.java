package com.cattle.xchange.controllers;

import com.cattle.xchange.domain.user.UserService;
import com.cattle.xchange.domain.user.dtos.UserInsertDTO;
import com.cattle.xchange.domain.user.dtos.UserLoginDTO;
import com.cattle.xchange.domain.user.dtos.UserMinDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "USER", description = "Methods of User API")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Find All Users",
            description = "Response is a list of User Objects.")
    @GetMapping("/")
    public ResponseEntity<List<UserMinDTO>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream().map(UserMinDTO::new).toList()
        );
    }

    @Operation(summary = "Find User by Id",
            description = "Response an User Object by Id.")
    @GetMapping("/{id}")
    public ResponseEntity<UserMinDTO> findUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                new UserMinDTO(service.findUserById(id))
        );
    }

    @Operation(summary = "Find User by document",
            description = "Response is an User Object by document.")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserMinDTO> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(
                new UserMinDTO(service.findByCpf(cpf))
        );
    }
}
