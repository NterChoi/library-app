package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스를 Controller(API의 진입점)로 설정
public class CalculatorController {
    @GetMapping("/add") // GET/add
    public int addTwoNumbers(CalculatorAddRequest request) { // 쿼리를 통해 넘어온 데이터를 함수 파라미터에 넣을 때 @RequestParam이 필요 dto 객체를 사용하면 @RequestParam 제거 가능
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply") //POST/multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }


}
