package com.group.libraryapp.ex.day6.repository;

import com.group.libraryapp.ex.fruitstore.dto.response.ShowFruitResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

@Primary
public class FruitMySqlRepository implements FruitRepository{
    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruitInfo(String name, long price, LocalDate warehousingDate) {
        String sql = "INSERT INTO fruit(name, price, warehousingDate) VALUES (?, ?, ?) ";
        jdbcTemplate.update(sql, name, price, warehousingDate);
    }

    public void sellFruitInfo(long id) {
        String sql = "UPDATE fruit SET status = TRUE WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public ShowFruitResponse showFruitInfo(String name) {
        String saleSql = "SELECT sum(price) from fruit where status = TRUE";
        String notSaleSql = "SELECT sum(price) from fruit where status = FALSE";

        Long salesAmount = jdbcTemplate.queryForObject(saleSql, Long.class);
        Long notSalesAmount = jdbcTemplate.queryForObject(notSaleSql, Long.class);

        return new ShowFruitResponse(salesAmount, notSalesAmount);

    }

    @Override
    public void saveFruitInfo(String name) {

    }
}
