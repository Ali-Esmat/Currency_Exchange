package com.exchange.exchange.dto;

public class conversionResponse {
    
    private double convertedAmount;
    
    public conversionResponse() {
    }
    public conversionResponse(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
    public double getConvertedAmount() {
        return convertedAmount;
    }
}
