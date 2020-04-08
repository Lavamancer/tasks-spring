package com.example.tasks.service;

import com.example.tasks.config.exception.NotFoundException;
import com.example.tasks.domain.Authority;
import com.example.tasks.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class AuthorityService {

    @Autowired AuthorityRepository authorityRepository;


    public void init() {
        if (authorityRepository.findAll().isEmpty()) {
            Authority authority = new Authority();
            authority.setType(Authority.Type.ROLE_ADMIN);
            authority.setName("Role Administrador");
            authorityRepository.save(authority);
            authority = new Authority();
            authority.setType(Authority.Type.ROLE_USER);
            authority.setName("Role Usuario");
            authorityRepository.save(authority);
        }
    }

    public Authority findByType(Authority.Type type) {
        if (!authorityRepository.existsById(type)) {
            throw new NotFoundException();
        }
        return authorityRepository.getOne(type);
    }

}
