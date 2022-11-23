package com.example.PP_31._Boot.UserDao;


import com.example.PP_31._Boot.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        TypedQuery<User> query = entityManager.createQuery("from User where id=:i", User.class);
        query.setParameter("i", id);
        return query.getSingleResult();
    }

    @Transactional
    public void save(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }

    @Transactional
    public void update(int id, User user) {
        User u = show(id);
        u.setName(user.getName());
        u.setSurName(user.getSurName());
        u.setAge(user.getAge());
        entityManager.persist(u);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}