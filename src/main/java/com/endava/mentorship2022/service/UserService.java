package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.UserNotFound;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new UserNotFound("The user with the id: " + id + " doesn't exists"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
