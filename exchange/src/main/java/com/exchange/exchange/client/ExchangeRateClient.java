package com.exchange.exchange.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.exchange.exchange.dto.ExchangeRateResponse;
@Service
public class ExchangeRateClient {
    private final RestClient restClient;
    public ExchangeRateClient() {
        this.restClient = RestClient.create();
    }
    public ExchangeRateResponse getRates(String baseCurrency){
        String url = "https://open.er-api.com/v6/latest/" + baseCurrency;
        return restClient.get().uri(url).retrieve().body(ExchangeRateResponse.class);
    }
}
