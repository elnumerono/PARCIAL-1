package model;

import java.util.ArrayList;
import java.util.List;

public class Huesped {

    //Atributos clase Huesped
    private String nombreCompleto, documentoIdentidad, correoElectronico, paisProcedencia;
    private int telefono;

    //Relaciones clase Huesped
    private List<Reserva> listHuespedReservas;

    /**
     * Metodo constructor de la clase Huesped
     * @param nombreCompleto del Huesped
     * @param documentoIdentidad del Huesped
     * @param correoElectronico del Huesped
     * @param paisProcedencia del Huesped
     * @param telefono del Huesped
     */
    public Huesped(String nombreCompleto, String documentoIdentidad, int telefono, String correoElectronico, String paisProcedencia){
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.paisProcedencia = paisProcedencia;

        this.listHuespedReservas = new ArrayList<>();
    }

}
