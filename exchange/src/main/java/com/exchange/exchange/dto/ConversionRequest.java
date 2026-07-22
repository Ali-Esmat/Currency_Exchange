package com.exchange.exchange.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class ConversionRequest {
    
    @NotBlank(message = "Source currency is required")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Source currency must be a 3-letter ISO code, e.g. USD")
    private String from;    

    @NotBlank(message = "Target currency is required")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Target currency must be a 3-letter ISO code, e.g. EUR")
    private String to;

    @Positive(message = "Amount must be greater than zero")
    private double amount;

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
}
