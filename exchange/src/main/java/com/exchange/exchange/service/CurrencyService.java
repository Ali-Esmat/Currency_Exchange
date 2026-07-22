package com.exchange.exchange.service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;
import com.exchange.exchange.entity.ConversionHistory;
import com.exchange.exchange.entity.User;
import com.exchange.exchange.repository.ConversionHistoryRepository;
import com.exchange.exchange.repository.UserRepository;
import com.exchange.exchange.client.ExchangeRateClient;
import com.exchange.exchange.dto.ConversionResponse;
import com.exchange.exchange.dto.ExchangeRateResponse;
import com.exchange.exchange.dto.UpdateConversionRequest;
import com.exchange.exchange.exception.ConversionNotFoundException;
import com.exchange.exchange.exception.UnsupportedCurrencyException;


@Service
public class CurrencyService {
    private final UserRepository userRepository;
    private final ConversionHistoryRepository conversionHistoryRepository;
    private final ExchangeRateClient exchangeRateClient;

    public CurrencyService(UserRepository userRepository, ConversionHistoryRepository conversionHistoryRepository,ExchangeRateClient exchangeRateClient) {
        this.userRepository = userRepository;
        this.exchangeRateClient = exchangeRateClient;
        this.conversionHistoryRepository = conversionHistoryRepository;
    }

    public List<ConversionHistory> getHistory() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return conversionHistoryRepository.findByUser_Email(email);
    }

    public ConversionHistory getHistoryById(Long id) {
        return conversionHistoryRepository.findById(id).orElseThrow(() -> new ConversionNotFoundException(id));
    
    }

    public void deleteHistoryById(Long id){
        ConversionHistory history = conversionHistoryRepository.findById(id).orElseThrow(() -> new ConversionNotFoundException(id));
        conversionHistoryRepository.delete(history);
    }

    public ConversionResponse convertCurrency(String from, String to, double amount){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow();
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
            history.setUser(user);
            
            conversionHistoryRepository.save(history);
            
            return new ConversionResponse(from, to, amount, rate, convertedAmount);
        } else 
            throw new UnsupportedCurrencyException(to);
    }
    public ConversionHistory updateHistory(Long id, UpdateConversionRequest request){
        ConversionHistory history = conversionHistoryRepository.findById(id).orElseThrow(() -> new ConversionNotFoundException(id));
        history.setAmount(request.getAmount());
        history.setConvertedAmount(request.getAmount() * history.getRate());
        return conversionHistoryRepository.save(history);
    }
}
