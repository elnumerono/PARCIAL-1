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
    //GESTIÓN DE HUÉSPEDES

    /**
     * Metodo para buscar Huesped
     * @param documento del huesped
     * @return
     */
    public Huesped buscarHuesped(String documento) {
        for (Huesped h : listHotelHuespedes) {
            if (h.getDocumentoIdentidad().equals(documento)) return h;
        }
        return null;
    }

    /**
     * Metodo para buscar huesped por telefono
     * @param tel del huesped
     * @return
     */

    public Huesped buscarHuespedPorTelefono(int tel) {
        for (Huesped h : listHotelHuespedes) {
            if (h.getTelefono() == tel) return h;
        }
        return null;
    }

    /**
     * Metodo para registrar huesped
     * @param nombre del huesped
     * @param doc del huesped
     * @param tel del huesped
     * @param email del huesped
     * @param pais del huesped
     * @return
     */
    public boolean registrarHuesped(String nombre, String doc, int tel, String email, String pais) {
        if (buscarHuesped(doc) == null) {
            listHotelHuespedes.add(new Huesped(nombre, doc, tel, email, pais));
            return true;
        }
        return false;
    }

    //GESTIÓN DE HABITACIONES

    /**
     * Metodo para buscar habitacion
     * @param numero de la habitacion
     * @return
     */
    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion h : listHotelHabitaciones) {
            if (h.getNumero() == numero) return h;
        }
        return null;
    }

    /**
     * Metodo para registrar habitacion
     * @param numero de la habitacion
     * @param piso de la habitacion
     * @param tipo de la habitacion
     * @param capacidad de la habitacion
     * @param precio de la habitacion
     * @param estado de la habitacion
     * @return
     */
    public boolean registrarHabitacion(int numero, int piso, String tipo, int capacidad, double precio, String estado) {
        if (buscarHabitacion(numero) == null) {
            listHotelHabitaciones.add(new Habitacion(numero, piso, tipo, capacidad, precio, estado));
            return true;
        }
        return false;
    }
}