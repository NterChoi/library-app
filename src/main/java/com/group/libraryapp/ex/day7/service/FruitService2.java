package com.group.libraryapp.ex.day7.service;

import com.group.libraryapp.ex.day7.domain.Fruit2;
import com.group.libraryapp.ex.day7.domain.FruitRepository2;
import com.group.libraryapp.ex.fruitstore.dto.request.FruitRequest;
import com.group.libraryapp.ex.fruitstore.dto.request.SellInfoRequest;
import com.group.libraryapp.ex.fruitstore.dto.response.CountResponse;
import com.group.libraryapp.ex.fruitstore.dto.response.ShowFruitResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FruitService2 {

    private final FruitRepository2 fruitRepository2;

    public FruitService2(FruitRepository2 fruitRepository2) {
        this.fruitRepository2 = fruitRepository2;
    }

    @Transactional
    public void saveFruitInfo(FruitRequest request) {
        fruitRepository2.save(new Fruit2(request));
    }
    @Transactional
    public void sellFruit(SellInfoRequest request) {
        Fruit2 fruit2 = fruitRepository2.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);
        fruit2.updateStatus(fruit2.getId());
    }

    @Transactional
    public ShowFruitResponse showFruitInfo(String name) {
        long salesAmount = fruitRepository2.findTotalPriceOfActiveFruits();
        long notSalesAmount = fruitRepository2.findTotalPriceOfInactiveFruits();
        ShowFruitResponse response = new ShowFruitResponse(salesAmount, notSalesAmount);

        return response;

    }
    @Transactional
    public long countFruit(String name) {
        return fruitRepository2.countByName(name);
    }
}
