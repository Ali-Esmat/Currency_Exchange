package com.exchange.exchange.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.exchange.exchange.service.currencyService;
import com.exchange.exchange.dto.conversionRequest;
import com.exchange.exchange.dto.conversionResponse;
@RestController
@RequestMapping("/api")
public class currencyController {
    private final currencyService currencyService;
    public currencyController(currencyService currencyService){
        this.currencyService = currencyService;
    }

    @PostMapping("/convert")
    public conversionResponse convert(@RequestBody conversionRequest request){
        double result = currencyService.convertCurrency(request.getFrom(), request.getTo(), request.getAmount());
        return new conversionResponse(result);
    }
}
