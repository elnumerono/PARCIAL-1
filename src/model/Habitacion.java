package model;

public class Habitacion {

    //Atributos de la clase Habitacion
    private int numero, piso, capacidad;
    private String tipo, estado;
    private double precioPorNoche;

    /**
     * Metodo constructor de la clase Habitacion
     * @param numero de la Habitacion
     * @param piso de la Habitacion
     * @param capacidad de la Habitacion
     * @param tipo de la Habitacion
     * @param estado de la Habitacion
     * @param precioPorNoche de la Habitacion
     */
    public Habitacion(int numero, int piso, String tipo, int capacidad, double precioPorNoche, String estado){
        this.numero = numero;
        this.piso = piso;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.estado = estado;
    }
    /**
     * Metodo para cambiar Estado
     * @param nuevoEstado de habitacion
     */
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /**
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", piso=" + piso +
                ", capacidad=" + capacidad +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                ", precioPorNoche=" + precioPorNoche +
                '}';
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

}
