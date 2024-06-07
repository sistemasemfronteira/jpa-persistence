/**
 * Neste exemplo de CRUD simples com JPA em um projeto java.
 * Facinho, serve para aqueles como eu que querem se benecifiar
 * de uma abordagem Orientada a Objetos na hora de persistir os dados e
 * reduzir a quantidade "desnecessária" de código.
 * 
 * Criado por: Iago H. L. de Souza. 
 */

package com.example;

import java.util.List;

import com.example.dao.UserDao;
import com.example.model.User;

public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // Create
        User newUser = new User();
        newUser.setName("Iago");
        newUser.setEmail("iago@example.com");
        userDao.addUser(newUser);
        System.out.println("Usuário adicionado.");

        // Read
        List<User> users = userDao.getAllUsers();
        System.out.println("Todos os usuários:");
        for (User user : users) {
            System.out.println(user.getName() + " - " + user.getEmail());
        }

        // Update
        User existingUser = users.get(0);
        existingUser.setName("Iago Updated");
        existingUser.setEmail("iago.updated@example.com");
        userDao.updateUser(existingUser);
        System.out.println("Usuários atualizados.");

        // Read by ID
        User userById = userDao.getUserById(existingUser.getId());
        System.out.println("ID do usuário:");
        System.out.println(userById.getName() + " - " + userById.getEmail());

        // Delete
        userDao.deleteUser(existingUser.getId());
        System.out.println("Usuário deletado.");

        // Verify Deletion
        users = userDao.getAllUsers();
        System.out.println("Todos os usuários após a exclusão:");
        for (User user : users) {
            System.out.println(user.getName() + " - " + user.getEmail());
        }

        userDao.close();
    }
}
