package com.cattle.xchange.controllers;

import com.cattle.xchange.domain.cattleAd.dtos.CattleAdMinDTO;
import com.cattle.xchange.domain.cattleBuy.CattleBuy;
import com.cattle.xchange.domain.cattleBuy.CattleBuyService;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyInsertDTO;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyMinDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cattlebuy")
public class CattleBuyController {

    @Autowired
    private CattleBuyService cattleBuyService;

    @Operation(summary = "Find All Cattle Buy",
            description = "Find All Cattle Buy with pagination")
    @GetMapping("/")
    public ResponseEntity<List<CattleBuyMinDTO>> findAll() {
        return ResponseEntity.ok(
                cattleBuyService.findAll()
                        .stream().map(CattleBuyMinDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @Operation(summary = "Find Cattle Buy by Id",
            description = "Find Cattle Buy by Id")
    @GetMapping("/{id}")
    public ResponseEntity<CattleBuyMinDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                new CattleBuyMinDTO(cattleBuyService.findById(id))
        );
    }

    @Operation(summary = "Find All Cattle Buy by user",
            description = "Find All Cattle Buy by user with pagination")
    @GetMapping("/user")
    public ResponseEntity<Page<CattleBuyMinDTO>> findByUserId(
                                    @RequestParam UUID userId,
                                    Pageable pageable) {
        return ResponseEntity.ok(
                cattleBuyService.findByUserId(userId, pageable)
                        .map(CattleBuyMinDTO::new)
        );
    }

    @Operation(summary = "Insert Cattle Buy",
            description = "Insert Cattle Buy")
    @PostMapping
    public ResponseEntity<CattleBuyMinDTO> create(@RequestBody CattleBuyInsertDTO cattleBuyInsertDTO) {
        return ResponseEntity.ok(
                    new CattleBuyMinDTO(cattleBuyService.create(cattleBuyInsertDTO))
        );
    }
}
