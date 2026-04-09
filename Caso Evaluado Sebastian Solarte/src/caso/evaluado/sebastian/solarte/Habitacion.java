/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso.evaluado.sebastian.solarte;

/**
 *
 * @author ssola
 */
public class Habitacion {

    private int numero;      // numero de habitacion
    private String tipo;      // habitacion simple o doble
    private double precio;     // precio de la habiatacion
    private String estado;      //libre, ocupada o sucia

    public Habitacion(int numero, String tipo, double precio, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }
// se crean los getterts and setters
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
// se crea el to string
    @Override
    public String toString() {
        return "Hab " + numero + " | " + tipo + " | $" + (int) precio + " | " + estado;
    }
}