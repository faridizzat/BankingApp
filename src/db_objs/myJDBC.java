package db_objs;

import io.github.cdimascio.dotenv.Dotenv;

import java.math.BigDecimal;
import java.sql.*;

public class myJDBC {


    //database configuration
    //get from ENV
    private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String DB_USERNAME = dotenv.get("DB_USERNAME");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    //if valid return an object with the user's information
    public static User validateLogin(String username, String password) {
        try {
            //establish a connection to the database using configuration
            Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME, DB_PASSWORD);

            //create sql query
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ?"
            );

            //replace the ? with values
            //parameter index referring to the iteration of the ? so 1 is the first ? and 2 is the second ?

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            //execute query and store into a result set
            ResultSet resultSet = preparedStatement.executeQuery();

            //next() returns true or false
            //true - query returned data and result set now points to the first row
            //false = query returned no data nad result set equals to null

            if (resultSet.next()) {
                //success
                //get id
                int userId = resultSet.getInt("id");

                //get current balance
                BigDecimal current_balance = resultSet.getBigDecimal("current_balance");

                //return user object
                return new User(userId, username, password, current_balance);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //not valid user
        return null;
    }

    //register new user to the db
    //true - register
    //false - register fails
    public static boolean register(String username, String password) {
        try {
            //check if username has already been taken
            if (!checkUsername(username)) {
                try {
                    Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME, DB_PASSWORD);

                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT INTO users (username, password)" + "VALUES(?,?)"
                    );
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    preparedStatement.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return false;

            }

        }
        catch (

        )
    }

    public static boolean checkUsername (String username) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users where username = ?"
            );
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
