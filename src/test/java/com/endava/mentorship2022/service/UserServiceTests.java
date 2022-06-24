package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.UserNotFound;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.model.UserStatus;
import com.endava.mentorship2022.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.endava.mentorship2022.model.UserStatus.ACTIVE;
import static com.endava.mentorship2022.model.UserStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should find all users")
    void findAllUsersTest() {
        // given
        User user1 = new User(
                1L,
                "Stanciu",
                "Angel",
                "angel@gmail.com",
                "pass",
                "Romania, Bucuresti, Strada Gabroveni 030089",
                "+40721058124",
                LocalDate.of(2010, 1, 1),
                PENDING);

        User user2 = new User(
                1L,
                "Stanciu",
                "Angel",
                "angel@gmail.com",
                "pass",
                "Romania, Bucuresti, Strada Gabroveni 030089",
                "+40721058124",
                LocalDate.of(2010, 1, 1),
                PENDING);

        List<User> usersList = List.of(user1, user2);
        when(userRepository.findAll()).thenReturn(usersList);

        // when
        List<User> actualUsers = userService.findAll();

        // then
        assertThat(actualUsers).hasSize(2);
        assertThat(usersList).isEqualTo(actualUsers);
    }

    @Test
    @DisplayName("Should find a user by ID")
    void findUserByIdTest() throws UserNotFound {
        // given
        User userToBeFound = new User(
                1L,
                "Stanciu",
                "Angel",
                "angel@gmail.com",
                "pass",
                "Romania, Bucuresti, Strada Gabroveni 030089",
                "+40721058124",
                LocalDate.of(2010, 1, 1),
                PENDING);

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userToBeFound));

        // when
        User actualUser = userService.findById(anyLong());

        // then
        assertThat(actualUser).isEqualTo(userToBeFound);
    }

    @Test
    @DisplayName("Should throw UserNotFound Exception")
    void findUserById_ExceptionTest() {
        // given
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // then
        assertThrows(UserNotFound.class, () -> userService.findById(anyLong()));
    }

    @Test
    @DisplayName("Should update a user")
    void updateUserTest() {
        // given
        User userToUpdate = new User(
                1L,
                "Stanciu",
                "Angel",
                "angel@gmail.com",
                "pass",
                "Romania, Bucuresti, Strada Gabroveni 030089",
                "+40721058124",
                LocalDate.of(2010, 1, 1),
                PENDING);

        User newUser = new User(
                1L,
                "updated",
                "updated",
                "updated@gmail.com",
                "updated",
                "updated",
                "updated",
                LocalDate.of(2222, 2, 2),
                PENDING);

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userToUpdate));
        when(userRepository.save(userToUpdate)).thenReturn(newUser);

        // when
        User resultedUser = userService.update(anyLong(), newUser);

        //then
        assertThat(resultedUser).isEqualTo(newUser);
    }

    @Test
    @DisplayName("Should throw UserNotFound Exception")
    void updateUser_ExceptionTest() {
        // given
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // then
        assertThrows(UserNotFound.class, () -> userService.deleteById(anyLong()));
    }

    @Test
    @DisplayName("Should update user status")
    void updateUserStatusTest() {
        // given
        User user = new User(
                1L,
                "Stanciu",
                "Angel",
                "angel@gmail.com",
                "pass",
                "Romania, Bucuresti, Strada Gabroveni 030089",
                "+40721058124",
                LocalDate.of(2010, 1, 1),
                PENDING);

        User updatedUser = new User(
                1L,
                "Stanciu",
                "Angel",
                "angel@gmail.com",
                "pass",
                "Romania, Bucuresti, Strada Gabroveni 030089",
                "+40721058124",
                LocalDate.of(2010, 1, 1),
                ACTIVE);

        when(userRepository.save(user)).thenReturn(updatedUser);

        // when
        User resultedUser = userService.updateStatus(ACTIVE, user);

        // then
        assertThat(resultedUser).isEqualTo(updatedUser);
    }

}

