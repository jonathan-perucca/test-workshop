package com.example.integration;

import java.sql.*;

public class UserRepository {

    DatabaseManager database;

    public UserRepository(DatabaseManager database) {
        this.database = database;
    }

    public User insertUser(User user) throws SQLException {
        final Connection connection = database.getConnection();
        final String sql = "insert into user (name, type) VALUES (?, ?)";

        final PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, user.getName());
        statement.setString(2, user.getRole().name());
        statement.executeUpdate();
        final ResultSet resultSet = statement.getGeneratedKeys();

        if(resultSet.next()) {
            user.setId(resultSet.getLong(1));
            return user;
        }
        return null;
    }

}