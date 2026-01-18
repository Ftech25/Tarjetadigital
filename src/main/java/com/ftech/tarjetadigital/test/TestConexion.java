
package com.ftech.tarjetadigital.test;
import com.ftech.tarjetadigital.config.ConexionBD;
import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {
        try (Connection con = ConexionBD.getConexion()) {
            System.out.println("✅ Conectado a MySQL correctamente");
        } catch (Exception e) {
            System.out.println("❌ Error de conexión");
            e.printStackTrace();
        }
    }
}
