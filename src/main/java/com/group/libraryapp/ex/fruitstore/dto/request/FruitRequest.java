package com.group.libraryapp.ex.fruitstore.dto.request;

import java.time.LocalDate;

public class FruitRequest {

    private final String name;

    private final LocalDate warehousingDate;

    private final long price;

    public FruitRequest(String name, LocalDate localDate, long price) {
        this.name = name;
        this.warehousingDate = localDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }



    public long getPrice() {
        return price;
    }
}
