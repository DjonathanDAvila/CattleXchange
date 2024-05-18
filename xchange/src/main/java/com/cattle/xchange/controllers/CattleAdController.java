package com.cattle.xchange.controllers;

import com.cattle.xchange.domain.cattleAd.CattleAd;
import com.cattle.xchange.domain.cattleAd.CattleAdService;
import com.cattle.xchange.domain.cattleAd.dtos.CattleAdInsertDTO;
import com.cattle.xchange.domain.cattleAd.dtos.CattleAdMinDTO;
import com.cattle.xchange.domain.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattleAd.enums.SexEnum;
import com.cattle.xchange.domain.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.*;

@RestController
@RequestMapping("/cattle")
public class CattleAdController {

    @Autowired
    private CattleAdService _cattleService;

    @Autowired
    private UserService _userService;


    @Operation(summary = "Insert Cattle Ads",
            description = "Insert Cattle Ads")
    @PostMapping("/")
    public ResponseEntity<CattleAdMinDTO> insert(@RequestBody CattleAdInsertDTO dto) {
        if (_userService.findUserById(dto.userCod()) == null)
            return ResponseEntity.notFound().build();


        return ResponseEntity.ok(
                new CattleAdMinDTO(_cattleService.insert(
                        dto.title(),
                        dto.desc(),
                        dto.unitValue(),
                        dto.quantity(),
                        dto.breed(),
                        dto.sex(),
                        dto.userCod(),
                        dto.city(),
                        dto.state(),
                        dto.status(),
                        dto.cattleAdImages()
                ))
        );
    }


    @Operation(summary = "Find all Cattle Ads",
            description = "Returns all Cattle Ads data with pagination")
    @GetMapping
    public ResponseEntity<List<CattleAdMinDTO>> findAllCattleAds(Pageable pageable) {
        List<CattleAd> cattleList = _cattleService.findCattleAds(pageable);

        if (cattleList == null || cattleList.isEmpty())
            return ResponseEntity.noContent().build();


        List<CattleAdMinDTO> cattleListDTO = new ArrayList<>();

        for (CattleAd cattle : cattleList) {
            CattleAdMinDTO cattleDTO = new CattleAdMinDTO(cattle);
            cattleListDTO.add(cattleDTO);
        }


        return ResponseEntity.ok(cattleListDTO);
    }


    @Operation(summary = "Find Cattle Ads by Id",
            description = "Returns Cattle Ads data by Id")
    @GetMapping("/{id}")
    public ResponseEntity<CattleAdMinDTO> findCattleAdById(@PathVariable UUID id) {
        Optional<CattleAd> optionalCattle = _cattleService.findCattleAdById(id);

        if (optionalCattle.isPresent()) {
            CattleAd cattle = optionalCattle.get();
            CattleAdMinDTO cattleDTO = new CattleAdMinDTO(cattle);
            return ResponseEntity.ok(cattleDTO);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Operation(summary = "Remove Cattle Ads by Id",
            description = "Remove Cattle Ads data by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {

        if (!_cattleService.findCattleAdById(id).isPresent())
            return ResponseEntity.notFound().build();


        _cattleService.delete(id);

        return ResponseEntity.ok().body("Anúncio removido");
    }

    @Operation(summary = "Find Cattle Ads by attributes",
            description = "Find Cattle Ads by sex, city, state, maxPrice and breed with pagination")
    @GetMapping("/search")
    public ResponseEntity<Page<CattleAdMinDTO>> findByCriteria(
            @RequestParam(required = false) SexEnum sex,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) BreedEnum breed,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                _cattleService.findByCriteria(sex, city, state, maxPrice, breed, pageable)
                        .map(CattleAdMinDTO::new)
        );
    }

    @Operation(summary = "Find All Cattle Ads by user",
            description = "Find All Cattle Ads by user with pagination")
    @GetMapping("/user")
    public ResponseEntity<Page<CattleAdMinDTO>> findByUser(
            @RequestParam UUID userId,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                _cattleService.findByUser(userId, pageable)
                        .map(CattleAdMinDTO::new)
        );
    }
}
