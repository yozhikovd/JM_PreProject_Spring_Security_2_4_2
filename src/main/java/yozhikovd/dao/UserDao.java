package yozhikovd.dao;

import org.springframework.stereotype.Repository;
import yozhikovd.models.Role;
import yozhikovd.models.User;

import java.util.List;


public interface UserDao {
    List<User> userList();
    User getUserById(int id);
    void addNewUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User findByUsername(String username);
}
