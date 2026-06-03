package com.exchange.exchange.service;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;
import com.exchange.exchange.entity.ConversionHistory;
import com.exchange.exchange.repository.ConversionHistoryRepository;
import com.exchange.exchange.client.ExchangeRateClient;
import com.exchange.exchange.dto.ConversionResponse;
import com.exchange.exchange.dto.ExchangeRateResponse;
import com.exchange.exchange.dto.UpdateConversionRequest;
@Service
public class CurrencyService {
    private final ConversionHistoryRepository repository;
    private final ExchangeRateClient exchangeRateClient;

    public CurrencyService(ConversionHistoryRepository repository,ExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
        this.repository = repository;
    }

    public List<ConversionHistory> getHistory() {
        return repository.findAll();
    }

    public ConversionHistory getHistoryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Conversion not found"));
    
    }

    public void deleteHistoryById(Long id){
        repository.deleteById(id);
    }

    public ConversionResponse convertCurrency(String from, String to, double amount){
        ExchangeRateResponse response = exchangeRateClient.getRates(from);
        Map<String, Double> rates = response.getRates();
        Double rate = rates.get(to);
        if(rate != null){
            double convertedAmount = amount * rate;

            ConversionHistory history = new ConversionHistory();
            
            history.setFromCurrency(from);
            history.setToCurrency(to);
            history.setAmount(amount);
            history.setRate(rate);
            history.setConvertedAmount(convertedAmount);
            
            repository.save(history);
            
            return new ConversionResponse(from, to, amount, rate, convertedAmount);
        } else 
            throw new RuntimeException("Unsupported currency: " + to);
    }

    public ConversionHistory updateHistory(Long id, UpdateConversionRequest request){
        ConversionHistory history = repository.findById(id).orElseThrow(() -> new RuntimeException("Conversion not found"));
        history.setAmount(request.getAmount());
        history.setConvertedAmount(request.getAmount() * history.getRate());
        return repository.save(history);
    }
}
