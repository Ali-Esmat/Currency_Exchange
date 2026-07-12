package com.exchange.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exchange.exchange.entity.ConversionHistory;
import java.util.List;

public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Long> {
    List<ConversionHistory> findByUser_Email(String email);
}
