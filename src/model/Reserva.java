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
    /**
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva='" + codigoReserva + '\'' +
                ", fechaRealizacion='" + fechaRealizacion + '\'' +
                ", fechaEntrada='" + fechaEntrada + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", estado='" + estado + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Habitacion> getListReservaHabitaciones() {
        return listReservaHabitaciones;
    }

    public void setListReservaHabitaciones(List<Habitacion> listReservaHabitaciones) {
        this.listReservaHabitaciones = listReservaHabitaciones;
    }

    public List<Servicio> getListReservaServicios() {
        return listReservaServicios;
    }

    public void setListReservaServicios(List<Servicio> listReservaServicios) {
        this.listReservaServicios = listReservaServicios;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
}
