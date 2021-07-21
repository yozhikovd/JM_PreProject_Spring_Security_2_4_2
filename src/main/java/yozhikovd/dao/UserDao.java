package yozhikovd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yozhikovd.models.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    List<User> userList();
    User getUserById(int id);
    void addNewUser(User user);
    void updateUser(int id, User user);
    void deleteUser(int id);
    User findByUsername(String username);
}
