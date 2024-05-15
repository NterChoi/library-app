package com.group.libraryapp.ex.day6.controller;

import com.group.libraryapp.ex.day6.service.FruitService;
import com.group.libraryapp.ex.fruitstore.dto.request.FruitRequest;
import com.group.libraryapp.ex.fruitstore.dto.request.SellInfoRequest;
import com.group.libraryapp.ex.fruitstore.dto.response.ShowFruitResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {

    private final FruitService fruitService;
    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.fruitService = new FruitService(jdbcTemplate);
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v2/fruit")
    public void saveFruitInfo(@RequestBody FruitRequest request) {
        fruitService.saveFruitInfo(request);
    }

    @PutMapping("/api/v2/fruit")
    public void sellFruitInfo(@RequestBody SellInfoRequest request) {
        fruitService.sellFruitInfo(request);
    }

    @GetMapping("/api/v2/fruit/stat")
    public ResponseEntity<ShowFruitResponse> showFruitInfo(@RequestParam String name) {
        ShowFruitResponse response = fruitService.showFruitInfo(name);

        return ResponseEntity.ok(response);
    }
}
