package model;
public class Servicio {

    //Atributos clase Servicio
    private String codigo, nombre, descripcion, disponibilidad;
    private double precio;

    /**
     * Metodo constructor de la clase Servicio
     * @param codigo del Servicio
     * @param nombre del Servicio
     * @param descripcion del Servicio
     * @param disponibilidad del Servicio
     * @param precio del Servicio
     */
    public Servicio(String codigo, String nombre, String descripcion, double precio, String disponibilidad){
        this.codigo = codigo;
        this.nombre= nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    /**
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "Servicio{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", disponibilidad='" + disponibilidad + '\'' +
                ", precio=" + precio +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
