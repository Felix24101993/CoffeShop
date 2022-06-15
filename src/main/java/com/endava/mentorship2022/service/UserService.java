package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();

    User findById(Long id);

}
