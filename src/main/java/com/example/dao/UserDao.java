package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.example.model.User;

public class UserDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDao() {
        emf = Persistence.createEntityManagerFactory("example-unit");
        em = emf.createEntityManager();
    }

    public void addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void deleteUser(int id) {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
