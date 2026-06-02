package com.exchange.exchange.service;
import org.springframework.stereotype.Service;

import java.util.Map;
import com.exchange.exchange.dto.ConversionResponse;
import com.exchange.exchange.client.ExchangeRateClient;
import com.exchange.exchange.dto.ExchangeRateResponse;
@Service
public class CurrencyService {
    private final ExchangeRateClient exchangeRateClient;

    public CurrencyService(ExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    public ConversionResponse convertCurrency(String from, String to, double amount){
        ExchangeRateResponse response = exchangeRateClient.getRates(from);
        Map<String, Double> rates = response.getRates();
        Double rate = rates.get(to);
        if(rate != null){
            double convertedAmount = amount * rate;
            return new ConversionResponse(from, to, amount, rate, convertedAmount);
        } else 
            throw new RuntimeException("Unsupported currency: " + to);
    }
}
