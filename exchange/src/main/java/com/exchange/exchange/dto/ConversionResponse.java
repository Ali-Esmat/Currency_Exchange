package com.exchange.exchange.dto;

public class ConversionResponse {
    
    private String from;
    private String to;
    private double amount;
    private double exchangeRate;
    private double convertedAmount;
    
    public ConversionResponse() {
    }
    public ConversionResponse(String from, String to, double amount, double exchangeRate, double convertedAmount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.exchangeRate = exchangeRate;
        this.convertedAmount = convertedAmount;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getRate() {
        return exchangeRate;
    }
    public void setRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
    public double getConvertedAmount() {
        return convertedAmount;
    }
}
