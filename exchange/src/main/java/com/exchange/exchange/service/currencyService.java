package com.exchange.exchange.service;
import org.springframework.stereotype.Service;

@Service
public class currencyService {
    public double convertCurrency(String from, String to, double amount){
        if(from.equals("USD") && to.equals("EUR")){
            return amount * 0.9;
        }
        throw new RuntimeException("Currency conversion not supported");
    }
}
