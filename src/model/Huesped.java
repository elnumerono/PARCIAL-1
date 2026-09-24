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
    /**
     * Metodo para Agregar reservas
     * @param reserva
     */
    public void agregarReserva(Reserva reserva) {
        this.listHuespedReservas.add(reserva);
    }

    /**
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "Huesped{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", paisProcedencia='" + paisProcedencia + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Reserva> getListHuespedReservas() {
        return listHuespedReservas;
    }

    public void setListHuespedReservas(List<Reserva> listHuespedReservas) {
        this.listHuespedReservas = listHuespedReservas;
    }

}
