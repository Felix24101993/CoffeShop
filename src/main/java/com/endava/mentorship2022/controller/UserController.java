package com.endava.mentorship2022.controller;

import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User newUser) {
        User userToUpdate = userService.findById(id);
        userToUpdate.setFirstName(newUser.getFirstName());
        userToUpdate.setLastName(newUser.getLastName());
        userToUpdate.setEmail(newUser.getEmail());
        userToUpdate.setPassword(newUser.getPassword());
        userToUpdate.setAddress(newUser.getAddress());
        userToUpdate.setPhoneNumber(newUser.getPhoneNumber());
        userToUpdate.setBirthDate(newUser.getBirthDate());
        userToUpdate.setStatus(newUser.getStatus());
        return userService.save(userToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
