package com.cattle.xchange.controllers;

import com.cattle.xchange.domain.cattleBuy.CattleBuy;
import com.cattle.xchange.domain.cattleBuy.CattleBuyService;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyInsertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cattlebuy")
public class CattleBuyController {

    @Autowired
    private CattleBuyService cattleBuyService;

    @GetMapping("/")
    public ResponseEntity<List<CattleBuy>> findAll() {
        return ResponseEntity.ok(cattleBuyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CattleBuy> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(cattleBuyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CattleBuy> create(@RequestBody CattleBuyInsertDTO cattleBuyInsertDTO) {
        return ResponseEntity.ok(cattleBuyService.create(cattleBuyInsertDTO));
    }
}
