package yozhikovd.services;

import yozhikovd.models.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    User getUserById(int id);
    void addNewUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User findByUsername(String username);
  }
