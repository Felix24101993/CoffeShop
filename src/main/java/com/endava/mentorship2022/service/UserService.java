package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

}
