package com.example.tasks.service;

import com.example.tasks.domain.Token;
import com.example.tasks.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.UUID;

@Transactional
@Service
public class TokenService {

    @Autowired TokenRepository tokenRepository;
    @Autowired UserService userService;


    public Token create(Long userId) {
        Token token = new Token();
        token.setTimestamp(ZonedDateTime.now().plusHours(12));
        token.setUuid(UUID.randomUUID().toString());
        token.setUser(userService.findById(userId));
        return tokenRepository.save(token);
    }


}
