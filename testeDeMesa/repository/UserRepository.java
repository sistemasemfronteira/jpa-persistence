package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.User;

public class UserRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }
}

