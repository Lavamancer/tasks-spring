package com.example.tasks.service;

import com.example.tasks.config.exception.NotFoundException;
import com.example.tasks.domain.Authority;
import com.example.tasks.domain.User;
import com.example.tasks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired UserRepository userRepository;
    @Autowired AuthorityService authorityService;


    public void init() {
        if (userRepository.findAll().isEmpty()) {
            create("john@doe.com", "1234");
            create("jane@doe.com", "1234");
        }
    }

    public User create(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.getAuthorities().add(authorityService.findByType(Authority.Type.ROLE_USER));
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        if (!userRepository.existsByEmailAndPassword(email, password)) {
            throw new NotFoundException();
        }

        // todo crear token
        // todo devolver el token en vez del usuario

        return userRepository.findByEmail(email);
    }


    public User findById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException();
        }
        return userRepository.getOne(id);
    }

}
