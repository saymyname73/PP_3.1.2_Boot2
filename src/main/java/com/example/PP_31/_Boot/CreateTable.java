package com.example.PP_31._Boot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_web", "root", "root");
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE `my_web`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `surname` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `age` INT NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`));;");
            statement.execute("INSERT INTO users(name, surname, age) VALUES ('name1', 'surname1', 22);");
            statement.execute("INSERT INTO users(name, surname, age) VALUES ('name2', 'surname2', 23);");
            statement.execute("INSERT INTO users(name, surname, age) VALUES ('name3', 'surname3', 24);");
            statement.execute("INSERT INTO users(name, surname, age) VALUES ('name4', 'surname4', 25);");
            statement.execute("INSERT INTO users(name, surname, age) VALUES ('name5', 'surname5', 26);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
