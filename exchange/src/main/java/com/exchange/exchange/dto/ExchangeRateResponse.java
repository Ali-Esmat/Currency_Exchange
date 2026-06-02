package com.exchange.exchange.dto;

import java.util.Map;
public class ExchangeRateResponse {
    private String result;
    private String baseCode;
    private Map<String, Double> rates;
    
    public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result = result;   
    }
    public String getBaseCode(){
        return baseCode;
    }
    public void setBaseCode(String baseCode){
        this.baseCode = baseCode;
    }
    public Map<String, Double> getRates(){
        return rates;
    }
    public void setRates(Map<String, Double> rates){
        this.rates = rates;
    }
}
