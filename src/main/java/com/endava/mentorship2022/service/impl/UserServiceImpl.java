package com.endava.mentorship2022.service.impl;

import com.endava.mentorship2022.exception.UserNotFound;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.UserRepository;
import com.endava.mentorship2022.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new UserNotFound("The user with the id: " + id + " doesn't exists"));
    }
}
