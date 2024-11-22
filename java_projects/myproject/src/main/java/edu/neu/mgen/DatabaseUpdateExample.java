package edu.neu.mgen;

import java.sql.*;

public class DatabaseUpdateExample {
    public static void main(String[] args) {
        // information for the database connection
        String jdbcURL = "jdbc:mysql://localhost:3306/mydatabase"; 
        String username = "root"; 
        String password = "empty"; // password for the database

        Connection connection = null;

        try {
            // first step: connect to the database
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connected to the database!");

            // second step: select the record to update
            String selectQuery = "SELECT * FROM users WHERE id = 1"; 
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

            if (resultSet.next()) {
                // print out the original record
                System.out.println("original record:");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));

                // third step: update the record
                String newName = "Alice Updated"; 
                String newEmail = "alice.updated@example.com"; 

                // fourth step: execute the update
                String updateQuery = "UPDATE users SET name = ?, email = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, newName); // set the new name
                preparedStatement.setString(2, newEmail); // set the new email
                preparedStatement.setInt(3, resultSet.getInt("id")); // set the id of the record to update

                int rowsUpdated = preparedStatement.executeUpdate(); 
                if (rowsUpdated > 0) {
                    System.out.println("update successful!");
                }

                preparedStatement.close();
            } else {
                System.out.println("No records found for the given ID.");
            }

            // fifth step: read the updated record
            ResultSet updatedResultSet = selectStatement.executeQuery(selectQuery);
            if (updatedResultSet.next()) {
                System.out.println("record after update:");
                System.out.println("ID: " + updatedResultSet.getInt("id"));
                System.out.println("Name: " + updatedResultSet.getString("name"));
                System.out.println("Email: " + updatedResultSet.getString("email"));
            }

            // close the result set and statement
            resultSet.close();
            selectStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // make sure to close the connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("database connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
