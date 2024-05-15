package com.group.libraryapp.ex.ex1.dto.response;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateResponse {
    private Enum<DayOfWeek> dayOfTheWeek;

    public DateResponse(String date) {
        LocalDate parsed = LocalDate.parse(date);
        this.dayOfTheWeek = parsed.getDayOfWeek();
    }

    public Enum<DayOfWeek> getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
