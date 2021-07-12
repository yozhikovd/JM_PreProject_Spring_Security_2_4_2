package yozhikovd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yozhikovd.dao.UserDao;
import yozhikovd.models.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


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
}
