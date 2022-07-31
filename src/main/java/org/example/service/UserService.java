package org.example.service;

import org.example.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(String name, int age, String city);
    void removeUser(Long id);
    void updateUser(User user);
}

