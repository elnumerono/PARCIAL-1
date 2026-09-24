package model;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

    //Atributos clase Reserva
    private String codigoReserva, fechaRealizacion, fechaEntrada, fechaSalida, estado, metodoPago;
    private double valorTotal;

    //Relaciones clase Reserva
    private List<Habitacion> listReservaHabitaciones;
    private List<Servicio> listReservaServicios;
    private Huesped huesped;

    /**
     * Metodo constructor de la clase Reserva
     * @param codigoReserva de la Reserva
     * @param fechaRealizacion de la Reserva
     * @param fechaEntrada de la Reserva
     * @param fechaSalida de la Reserva
     * @param estado de la Reserva
     * @param metodoPago de la Reserva
     * @param valorTotal de la Reserva
     * @param huesped de la Reserva
     */

    public Reserva(String codigoReserva, String fechaRealizacion, String fechaEntrada, String fechaSalida, String estado, String metodoPago, double valorTotal, Huesped huesped){
        this.codigoReserva = codigoReserva;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
        this.huesped = huesped;

        this.listReservaHabitaciones = new ArrayList<>();
        this.listReservaServicios = new ArrayList<>();
    }
}
