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

}
