package com.group.libraryapp.ex.fruitstore.dto.response;

public class ShowFruitResponse {

    private final long salesAmount;

    private final long notSalesAmount;

    public ShowFruitResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
