package com.group.libraryapp.ex.day6.service;

import com.group.libraryapp.ex.day6.repository.FruitMySqlRepository;
import com.group.libraryapp.ex.fruitstore.dto.request.FruitRequest;
import com.group.libraryapp.ex.fruitstore.dto.request.SellInfoRequest;
import com.group.libraryapp.ex.fruitstore.dto.response.ShowFruitResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitMySqlRepository fruitMySqlRepository;

    public FruitService(JdbcTemplate jdbcTemplate) {
        fruitMySqlRepository = new FruitMySqlRepository(jdbcTemplate);
    }

    public void saveFruitInfo(FruitRequest request) {
        fruitMySqlRepository.saveFruitInfo(request.getName(), request.getPrice(), request.getWarehousingDate());
    }

    public void sellFruitInfo(SellInfoRequest request) {
        fruitMySqlRepository.sellFruitInfo(request.getId());
    }

    public ShowFruitResponse showFruitInfo(String name) {
        return fruitMySqlRepository.showFruitInfo(name);
    }
}
