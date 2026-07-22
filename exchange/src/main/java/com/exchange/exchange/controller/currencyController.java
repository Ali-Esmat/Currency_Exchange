package com.exchange.exchange.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.exchange.exchange.service.CurrencyService;
import com.exchange.exchange.dto.ConversionRequest;
import com.exchange.exchange.dto.ConversionResponse;
import com.exchange.exchange.dto.UpdateConversionRequest;
import com.exchange.exchange.entity.ConversionHistory;

@RestController
@RequestMapping("/api")
public class CurrencyController {
    private final CurrencyService currencyService;
    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @PostMapping("/convert")
    public ConversionResponse convert(@Valid @RequestBody ConversionRequest request){
        return currencyService.convertCurrency(request.getFrom(), request.getTo(), request.getAmount());

    }

    @GetMapping("/history")
    public List<ConversionHistory> getHistory() {
        return currencyService.getHistory();
    }

    @GetMapping("/history/{id}")
    public ConversionHistory getHistoryById(@PathVariable Long id){
        return currencyService.getHistoryById(id);
    }

    @DeleteMapping("/history/{id}")
    public void deleteHistoryById(@PathVariable Long id){
        currencyService.deleteHistoryById(id);
    }

    // for learning purposes only.
    @PutMapping("/history/{id}")
    public ConversionHistory updateHistory(@PathVariable Long id, @Valid @RequestBody UpdateConversionRequest request){
        return currencyService.updateHistory(id, request);
    }
}
