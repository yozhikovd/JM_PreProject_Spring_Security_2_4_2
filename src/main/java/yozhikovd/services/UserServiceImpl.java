package yozhikovd.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yozhikovd.dao.UserDao;
import yozhikovd.models.User;
import java.util.List;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }


    @Override
    @Transactional
    public void addNewUser(User user) {
        userDao.addNewUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
