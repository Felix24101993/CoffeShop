package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.UserNotFound;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.model.UserStatus;
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
        findById(id); // just call the method, if the user is not found it throws UserNotFound Exception
        userRepository.deleteById(id);
    }

    public User update(Long id, User newUser) {
        User userToUpdate = findById(id);
        userToUpdate.setFirstName(newUser.getFirstName());
        userToUpdate.setLastName(newUser.getLastName());
        userToUpdate.setEmail(newUser.getEmail());
        userToUpdate.setPassword(newUser.getPassword());
        userToUpdate.setAddress(newUser.getAddress());
        userToUpdate.setPhoneNumber(newUser.getPhoneNumber());
        userToUpdate.setBirthDate(newUser.getBirthDate());
        userToUpdate.setStatus(newUser.getStatus());
        return userRepository.save(userToUpdate);
    }

    public void updateStatus(UserStatus status, User user) {
        user.setStatus(status);
        userRepository.save(user);
    }

}
