package yozhikovd.dao;

import yozhikovd.models.User;

import java.util.List;

public interface UserDao {
    List<User> userList();
    User getUserById(int id);

}
