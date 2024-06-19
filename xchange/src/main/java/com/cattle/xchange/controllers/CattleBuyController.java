package com.cattle.xchange.controllers;

import com.cattle.xchange.domain.cattleBuy.CattleBuyService;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyInsertDTO;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyMinDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cattlebuy")
@Tag(name = "CATTLE BUY", description = "Methods of Cattle Buy API")
public class CattleBuyController {

    @Autowired
    private CattleBuyService cattleBuyService;

    @Operation(summary = "Find All Cattle Buy",
            description = "Response is a list of Cattle Buy Objects.")
    @GetMapping("/")
    public ResponseEntity<List<CattleBuyMinDTO>> findAll() {
        return ResponseEntity.ok(
                cattleBuyService.findAll()
                        .stream().map(CattleBuyMinDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @Operation(summary = "Find Cattle Buy by Id",
            description = "Response is a Cattle Buy Object by Id.")
    @GetMapping("/{id}")
    public ResponseEntity<CattleBuyMinDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                new CattleBuyMinDTO(cattleBuyService.findById(id))
        );
    }

    @Operation(summary = "Find All Cattle Buy by user",
            description = "Response is a List of Cattle Buy Objects by user with pagination.")
    @GetMapping("/user")
    public ResponseEntity<Page<CattleBuyMinDTO>> findAllByCurrentUser(Pageable pageable) {
        return ResponseEntity.ok(
                cattleBuyService.findAllByCurrentUser(pageable)
                        .map(CattleBuyMinDTO::new)
        );
    }

    @Operation(summary = "Insert Cattle Buy",
            description = "Response is a Cattle Buy Object.")
    @PostMapping
    public ResponseEntity<CattleBuyMinDTO> create(@RequestBody CattleBuyInsertDTO cattleBuyInsertDTO) {
        return ResponseEntity.ok(
                    new CattleBuyMinDTO(cattleBuyService.create(cattleBuyInsertDTO))
        );
    }
}
