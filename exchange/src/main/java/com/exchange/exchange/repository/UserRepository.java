package com.exchange.exchange.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exchange.exchange.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    
}
