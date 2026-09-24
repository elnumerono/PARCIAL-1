package model;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    //Atributos clase Hotel
    private String nombreComercial, nit, direccion, pagWeb;
    private int telefono;

    //Relaciones clase Hotel
    private List<Servicio> listHotelServicios;
    private List<Huesped> listHotelHuespedes;
    private List<Habitacion> listHotelHabitaciones;
    private List<Reserva> listHotelReservas;

    /**
     * Metodo constructor de la clase Hotel
     *
     * @param nombreComercial del Hotel
     * @param nit             del Hotel
     * @param direccion       del Hotel
     * @param pagWeb          del Hotel
     * @param telefono        del Hotel
     */
    public Hotel(String nombreComercial, String nit, String direccion, String pagWeb, int telefono) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.pagWeb = pagWeb;
        this.telefono = telefono;

        this.listHotelServicios = new ArrayList<>();
        this.listHotelHuespedes = new ArrayList<>();
        this.listHotelHabitaciones = new ArrayList<>();
        this.listHotelReservas = new ArrayList<>();
    }
}