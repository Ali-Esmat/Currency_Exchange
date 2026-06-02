package com.exchange.exchange.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.exchange.exchange.service.CurrencyService;
import com.exchange.exchange.dto.ConversionRequest;
import com.exchange.exchange.dto.ConversionResponse;
@RestController
@RequestMapping("/api")
public class CurrencyController {
    private final CurrencyService currencyService;
    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @PostMapping("/convert")
    public ConversionResponse convert(@RequestBody ConversionRequest request){
        return currencyService.convertCurrency(request.getFrom(), request.getTo(), request.getAmount());

    }
}
