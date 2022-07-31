package org.example.dao;

import org.example.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(String name, int age, String city);
    void removeUser(Long id);
    void updateUser(User user);
}
