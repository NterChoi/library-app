package com.group.libraryapp.ex.day6.repository;

import java.util.ArrayList;
import java.util.List;

public class FruitMemoryRepository implements FruitRepository {

    private final List<String> fruits = new ArrayList<>();
    @Override
    public void saveFruitInfo(String name) {
        fruits.add(name);
    }
}
