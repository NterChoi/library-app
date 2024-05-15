package com.group.libraryapp.ex.fruitstore.controller;

import com.group.libraryapp.ex.fruitstore.dto.request.FruitRequest;
import com.group.libraryapp.ex.fruitstore.dto.request.SellInfoRequest;
import com.group.libraryapp.ex.fruitstore.dto.response.ShowFruitResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitStoreController {

    private final JdbcTemplate jdbcTemplate;

    public FruitStoreController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruitInfo(@RequestBody FruitRequest request) {
        String sql = "INSERT INTO fruit(name, price, warehousingDate) VALUES (?, ?, ?) ";
        jdbcTemplate.update(sql, request.getName(), request.getPrice(), request.getWarehousingDate());
    }

    @PutMapping("/api/v1/fruit")
    public void sellFruitInfo(@RequestBody SellInfoRequest request) {
        String sql = "UPDATE fruit SET status = TRUE WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @GetMapping("/api/v1/fruit/stat")
    public ShowFruitResponse showfruitInfo(@RequestParam String name) {
        String saleSql = "SELECT sum(price) from fruit where status = TRUE";
        String notSaleSql = "SELECT sum(price) from fruit where status = FALSE";

        Long salesAmount = jdbcTemplate.queryForObject(saleSql, Long.class);
        Long notSalesAmount = jdbcTemplate.queryForObject(notSaleSql, Long.class);

        return new ShowFruitResponse(salesAmount, notSalesAmount);

    }
}
