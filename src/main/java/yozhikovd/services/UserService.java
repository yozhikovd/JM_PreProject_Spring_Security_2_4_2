package yozhikovd.services;

import yozhikovd.models.Role;
import yozhikovd.models.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    User getUserById(int id);
    void addNewUser(User user);
    void updateUser(int id, User user);
    void deleteUser(int id);
    User findByUsername(String username);
    List<Role> getAllRoles();
    Role getRoleById(long id);
}
