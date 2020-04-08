package com.example.tasks.repository;

import com.example.tasks.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAndPassword(String email, String password);

    User findByEmail(String email);

}