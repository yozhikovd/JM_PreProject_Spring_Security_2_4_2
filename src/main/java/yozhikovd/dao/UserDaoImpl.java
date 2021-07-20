package yozhikovd.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yozhikovd.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @SuppressWarnings(value = "error")
    public List<User> userList() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User getUserById(final int id) {
        return userList().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void addNewUser(User user) {
        entityManager.persist(user);
        System.out.println("Пользователь с именем " + user.getLastName() + user.getName() +" успешно добавлен");
    }

    @Override
    public void updateUser(int id, User user) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        entityManager.merge(userToUpdate);
    }

    @Override
    public void deleteUser(int id) {
        User userToDelete = getUserById(id);
        entityManager.remove(userToDelete);
    }
}
