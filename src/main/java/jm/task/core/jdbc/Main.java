package jm.task.core.jdbc;

import java.util.ArrayList;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final User user1 = new User("Alexandr", "Kyvyrzhik", (byte) 28);
    private static final User user2 = new User("Todia", "Karabudzhak", (byte) 8);
    private static final User user3 = new User("Ivan", "Karaman", (byte) 52);
    private static final User user4 = new User("Nikolay", "Delibal", (byte) 50);
//    private static final User user5 = new User("Maria", "Mihalchyk", (byte) 20);
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();

        userServiceImpl.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userServiceImpl.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userServiceImpl.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userServiceImpl.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
//        userServiceImpl.saveUser(user5.getName(), user5.getLastName(), user5.getAge());

        userServiceImpl.getAllUsers();

        userServiceImpl.cleanUsersTable();

        userServiceImpl.getAllUsers();

        userServiceImpl.dropUsersTable();

        userServiceImpl.getAllUsers();

    }
}
