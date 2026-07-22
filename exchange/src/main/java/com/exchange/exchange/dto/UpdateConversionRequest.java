package com.exchange.exchange.dto;

import jakarta.validation.constraints.Positive;

public class UpdateConversionRequest {
    @Positive(message = "Amount must be greater than zero")
    private double amount;

    public UpdateConversionRequest() {
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    
}
