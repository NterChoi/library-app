package com.group.libraryapp.ex.day7.domain;

import com.group.libraryapp.ex.fruitstore.dto.response.CountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FruitRepository2 extends JpaRepository<Fruit2, Long> {
    @Query("SELECT SUM(f.price) FROM Fruit2 f WHERE f.status = TRUE")
    public long findTotalPriceOfActiveFruits();

    @Query("SELECT SUM(f.price) FROM Fruit2 f WHERE f.status = FALSE")
    public long findTotalPriceOfInactiveFruits();

    @Query("SELECT COUNT(f) FROM Fruit2 f WHERE f.name = :name")
    long countByName(String name);
}