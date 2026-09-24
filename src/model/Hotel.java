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
    // GESTIÓN DE SERVICIOS

    /**
     * Metodo para buscar servicio
     * @param codigo del servicio
     * @return
     */
    public Servicio buscarServicio(String codigo) {
        for (Servicio s : listHotelServicios) {
            if (s.getCodigo().equals(codigo)) return s;
        }
        return null;
    }

    /**
     * Metodo para registrar servicio
     * @param codigo del servicio
     * @param nombre del servicio
     * @param desc del servicio
     * @param precio del servicio
     * @param disp del servicio
     * @return
     */
    public boolean registrarServicio(String codigo, String nombre, String desc, double precio, String disp) {
        if (buscarServicio(codigo) == null) {
            listHotelServicios.add(new Servicio(codigo, nombre, desc, precio, disp));
            return true;
        }
        return false;
    }

    // GESTIÓN DE RESERVAS

    /**
     * Metodo para buscar reserva
     * @param codigo de la reserva
     * @return
     */
    public Reserva buscarReserva(String codigo) {
        for (Reserva r : listHotelReservas) {
            if (r.getCodigoReserva().equals(codigo)) return r;
        }
        return null;
    }

    /**
     * Metodo para crear Reserva
     * @param codigo de la reserva
     * @param fechaRealizacion de la reserva
     * @param fechaEntrada de la reserva
     * @param fechaSalida de la reserva
     * @param estado de la reserva
     * @param metodoPago de la reserva
     * @param valorTotal de la reserva
     * @param huesped de la reserva
     * @return
     */
    public boolean crearReserva(String codigo, String fechaRealizacion, String fechaEntrada, String fechaSalida, String estado, String metodoPago,
                                double valorTotal, Huesped huesped) {
        if (buscarReserva(codigo) == null) {
            Reserva nueva = new Reserva(codigo, fechaRealizacion, fechaEntrada, fechaSalida, estado, metodoPago, valorTotal, huesped);
            listHotelReservas.add(nueva);
            huesped.agregarReserva(nueva);
            return true;
        }
        return false;
    }

    // REQUERIMIENTOS ESPECIALES DEL PROBLEMA

    // Número perfecto en el teléfono de un huésped

    /**
     * Metodo para verificar num perfecto con num telefono
     * @param telefono del huesped
     * @return
     */
    public String verificarTelefonoPerfecto(int telefono) {
        Huesped h = buscarHuespedPorTelefono(telefono);
        if (h == null) return "No se encontró ningún huésped con ese número de teléfono.";

        int num = h.getTelefono();
        if (num <= 0) return "El número de teléfono no es válido para esta prueba.";

        int sumaDivisores = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sumaDivisores += i;
            }
        }

        if (sumaDivisores == num) {
            return "El número " + num + " del huésped " + h.getNombreCompleto() + " ES UN NÚMERO PERFECTO.";
        } else {
            return "El número " + num + " del huésped " + h.getNombreCompleto() + " NO es un número perfecto (Suma divisores: " + sumaDivisores + ").";
        }
    }

    // Ingresos acumulados por fecha de realización

    /**
     * Metodo para calcular ingresos por fecha
     * @param fecha de la reserva a mirar
     * @return
     */
    public double calcularIngresosPorFecha(String fecha) {
        double total = 0.0;
        for (Reserva r : listHotelReservas) {
            if (r.getFechaRealizacion().equals(fecha)) {
                total += r.getValorTotal();
            }
        }
        return total;
    }

    // Confirmar Reserva y actualizar estado de la habitación

    /**
     * Metodo para confirmar reserva actualizando el estado
     * @param codReserva de la reserva
     * @return
     */
    public boolean confirmarReserva(String codReserva) {
        Reserva r = buscarReserva(codReserva);
        if (r != null) {
            r.setEstado("Confirmada");
            for (Habitacion hab : r.getListReservaHabitaciones()) {
                hab.cambiarEstado("Reservada");
            }
            return true;
        }
        return false;
    }
// Metodo para validar que la habitación esté disponible en las fechas indicadas

    /**
     * Metodo para validar disponibilidad de habitacion
     * @param numHabitacion de la habitacion
     * @param fechaEntrada de la reserva
     * @param fechaSalida de la reserva
     * @return
     */
    public boolean validarDisponibilidadHabitacion(int numHabitacion, String fechaEntrada, String fechaSalida) {
        Habitacion hab = buscarHabitacion(numHabitacion);
        if (hab == null || hab.getEstado().equalsIgnoreCase("Mantenimiento")) {
            return false;
        }

        for (Reserva r : listHotelReservas) {
            // Si la reserva no está cancelada
            if (!r.getEstado().equalsIgnoreCase("Cancelada")) {
                for (Habitacion h : r.getListReservaHabitaciones()) {
                    if (h.getNumero() == numHabitacion) {
                        // Si coincide exactamente la fecha de entrada o salida
                        if (r.getFechaEntrada().equals(fechaEntrada) || r.getFechaSalida().equals(fechaSalida)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}