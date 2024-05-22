package com.group.libraryapp.ex.day7.domain;

import com.group.libraryapp.ex.fruitstore.dto.request.FruitRequest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column
    private String name;


    @Column
    private long price;

    @Column
    private LocalDate warehousingDate;
    @Column
    private boolean status;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public boolean isStatus() {
        return status;
    }

    public Fruit2(FruitRequest request) {
        this.name = request.getName();
        this.price = request.getPrice();
        this.warehousingDate = request.getWarehousingDate();
        this.status = false;
    }

    protected Fruit2() {

    }

    public void updateStatus(Long id) {
        this.status = true;
    }
}
