package Fichero;

import java.io.Serializable;

public class Nave implements Serializable {
    private String nombre;
    private transient double peso;
    private double velocidad;

    public Nave(String nombre, double peso, double velocidad) {
        this.nombre = nombre;
        this.peso = peso;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", velocidad=" + velocidad +
                '}';
    }
}
