package com.ftech.tarjetadigital.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    // Variables desde Docker / entorno
    private static final String DB_HOST =
            System.getenv().getOrDefault("DB_HOST", "localhost");

    private static final String DB_NAME =
            System.getenv().getOrDefault("DB_NAME", "tarjeta_digital");

    private static final String DB_USER =
            System.getenv().getOrDefault("DB_USER", "root");

    private static final String DB_PASS =
            System.getenv().getOrDefault("DB_PASS", "223348");

    private static final String URL =
            "jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME +
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
