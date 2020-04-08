package com.example.tasks.repository;

import com.example.tasks.domain.Token;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}
