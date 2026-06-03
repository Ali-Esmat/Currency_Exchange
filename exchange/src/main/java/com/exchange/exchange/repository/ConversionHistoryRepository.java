package com.exchange.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exchange.exchange.entity.ConversionHistory;

public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Long> {
    
}
