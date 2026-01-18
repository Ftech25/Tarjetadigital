package com.ftech.tarjetadigital.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/tarjeta_digital?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "223348"; // o tu password

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
