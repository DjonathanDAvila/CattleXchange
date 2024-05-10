package com.cattle.xchange.controllers;

import com.cattle.xchange.domain.cattleAd.dtos.CattleAdMinDTO;
import com.cattle.xchange.domain.cattleBuy.CattleBuy;
import com.cattle.xchange.domain.cattleBuy.CattleBuyService;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyInsertDTO;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cattlebuy")
public class CattleBuyController {

    @Autowired
    private CattleBuyService cattleBuyService;

    @GetMapping("/")
    public ResponseEntity<List<CattleBuyMinDTO>> findAll() {
        return ResponseEntity.ok(
                cattleBuyService.findAll()
                        .stream().map(CattleBuyMinDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CattleBuyMinDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                new CattleBuyMinDTO(cattleBuyService.findById(id))
        );
    }

    @GetMapping("/user")
    public ResponseEntity<Page<CattleBuyMinDTO>> findByUserId(
                                    @RequestParam UUID userId,
                                    Pageable pageable) {
        return ResponseEntity.ok(
                cattleBuyService.findByUserId(userId, pageable)
                        .map(CattleBuyMinDTO::new)
        );
    }

    @PostMapping
    public ResponseEntity<CattleBuyMinDTO> create(@RequestBody CattleBuyInsertDTO cattleBuyInsertDTO) {
        return ResponseEntity.ok(
                    new CattleBuyMinDTO(cattleBuyService.create(cattleBuyInsertDTO))
        );
    }
}
