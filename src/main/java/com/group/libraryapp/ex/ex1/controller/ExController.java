package com.group.libraryapp.ex.ex1.controller;

import com.group.libraryapp.ex.ex1.dto.request.CalculatorMultiNumber;
import com.group.libraryapp.ex.ex1.dto.request.CalculatorRequest;
import com.group.libraryapp.ex.ex1.dto.response.CalculatorResponse;
import com.group.libraryapp.ex.ex1.dto.response.DateResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class ExController {

    @GetMapping("/api/v1/calc")
    public CalculatorResponse plusMinusMultiplyCalculator(CalculatorRequest request) {

        return new CalculatorResponse(request);
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DateResponse dayOfTheWeek(@RequestParam String date) {

        return new DateResponse(date);

    }

    @PostMapping("/api/v1/multi-number-sum")
    public int multiNumberSum(@RequestBody CalculatorMultiNumber request) {
        int[] numbers = request.getNumbers();
        int sum = Arrays.stream(numbers).sum();
        return sum;
    }
}
