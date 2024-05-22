package com.group.libraryapp.ex.day7.controller;

import com.group.libraryapp.ex.day7.service.FruitService2;
import com.group.libraryapp.ex.fruitstore.dto.request.FruitRequest;
import com.group.libraryapp.ex.fruitstore.dto.request.SellInfoRequest;
import com.group.libraryapp.ex.fruitstore.dto.response.CountResponse;
import com.group.libraryapp.ex.fruitstore.dto.response.ShowFruitResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController2 {

    private final FruitService2 fruitService2;

    public FruitController2(FruitService2 fruitService2) {
        this.fruitService2 = fruitService2;
    }

    @PostMapping("/api/v3/fruit")
    public void saveFruitInfo(@RequestBody FruitRequest request) {
        fruitService2.saveFruitInfo(request);
    }

    @PutMapping("/api/v3/fruit")
    public void sellFruit(@RequestBody SellInfoRequest request) {
        fruitService2.sellFruit(request);
    }

    @GetMapping("/api/v3/fruit/stat")
    public ShowFruitResponse showFruitInfo(@RequestParam String name) {
        ShowFruitResponse response = fruitService2.showFruitInfo(name);
        return response;
    }

    @GetMapping("/api/v1/fruit/count")
    public CountResponse CountFruit(@RequestParam String name) {
        long count = fruitService2.countFruit(name);
        CountResponse response = new CountResponse(count);
        return response;
    }
}
