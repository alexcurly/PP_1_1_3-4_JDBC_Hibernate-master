package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public static final String createUserTable = "CREATE TABLE IF NOT EXISTS Users" +
            "(id INT AUTO_INCREMENT PRIMARY KEY, " +
            "name VARCHAR(40) NOT NULL, " +
            "lastName VARCHAR(40) NOT NULL, " +
            "age INT NOT NULL)";

    public static final String dropUserTable = "DROP TABLE IF EXISTS Users";

    public static final String saveUserTable = "INSERT INTO Users(name, lastName, age) VALUES (?,?,?)";
    public static final String removeUserByIdTable = "DELETE FROM Users WHERE id = ?";
    public static final String getAllUsersTable = "SELECT id, name, lastName, age FROM Users";
    public static final String cleanUsersTableTable = "TRUNCATE TABLE Users";
    private final Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {

    }
    @Override
    public void createUsersTable() {
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(createUserTable);
            connection.commit();
            System.out.println("Table Users was created");
        } catch (SQLException e) {

            System.out.println("error of createUsersTable");
            e.printStackTrace();
//            try{
//                connection.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
        }
    }

    @Override
    public void dropUsersTable() {
        try(PreparedStatement preparedStatement = connection.prepareStatement(dropUserTable)) {
            connection.commit();
            System.out.println("table was dropped down");
        } catch (SQLException ex) {
            System.out.println("error of dropUsersTable");
        }
    }




    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(saveUserTable)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate(); // 0 or 1 what for?

            System.out.println("Data save user is done");
        } catch ( SQLException ex ) {
            System.out.println("saveUser Error");
            ex.printStackTrace();
        }
    }

//    @Override
//    public void removeUserById(long id) {
//        try(Statement statement = connection.createStatement()) {
//            statement.executeUpdate(removeUserByIdTable);
//            System.out.println("User's raw was removed");
//        } catch (SQLException ex) {
//            System.out.println("removeUserById Error");
//            ex.printStackTrace();
//        }
//    }
@Override
public void removeUserById(long id) {
    try (PreparedStatement statement = connection
            .prepareStatement(removeUserByIdTable)
    ) {
        statement.setLong(1, id);
        statement.executeUpdate();
        System.out.println("User's raw was removed");
    } catch (SQLException ex) {
        System.out.println("removeUserById Error");
            ex.printStackTrace();
    }
}

    @Override
    public List<User> getAllUsers() {
        List<User> allUser = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getAllUsersTable);
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastName"));
            user.setAge(resultSet.getByte("age"));
            allUser.add(user);
        }

        } catch (SQLException ex) {
            System.out.println("getAllUsers Error");
            ex.printStackTrace();
        }

        return allUser;
    }
    @Override
    public void cleanUsersTable() {
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(cleanUsersTableTable);
            System.out.println("Table was cleaned up! ");

        } catch (SQLException ex) {
            System.out.println("cleanUsersTable Error. Table wasn't cleaned");
            ex.printStackTrace();

        }
    }
}
