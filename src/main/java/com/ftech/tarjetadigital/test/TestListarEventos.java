
package com.ftech.tarjetadigital.test;
import com.ftech.tarjetadigital.dao.EventoDAO;
import com.ftech.tarjetadigital.model.Evento;

public class TestListarEventos {
      public static void main(String[] args) {

        EventoDAO dao = new EventoDAO();

        for (Evento e : dao.listarEventos()) {
            System.out.println(
                e.getIdEvento() + " - " +
                e.getTitulo() + " - " +
                e.getModelo()
            );
        }
    }
    

}
