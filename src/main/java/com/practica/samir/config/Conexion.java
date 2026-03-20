package com.practica.samir.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String DATABASE = "bd_carrito";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE 
                                      + "?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("¡Conexión establecida!");
        } catch (Exception ex) {
            System.err.println("Error durante la conexión: " + ex.getMessage());
            ex.printStackTrace();
        }
        return conn;
    }
}
