package com.exchange.exchange.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;

@Entity
public class ConversionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double rate;
    private double convertedAmount;

    public ConversionHistory() {
    }
    
    public Long getId() {
        return id;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }
    public String getFromCurrency() {
        return fromCurrency;
    }
    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }
    public String getToCurrency() {
        return toCurrency;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getRate() {
        return rate;
    }
    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
    public double getConvertedAmount() {
        return convertedAmount;
    }

}
