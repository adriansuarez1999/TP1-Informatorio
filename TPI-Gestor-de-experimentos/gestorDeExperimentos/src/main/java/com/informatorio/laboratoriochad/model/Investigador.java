package com.informatorio.laboratoriochad.model;

public class Investigador {

    private String nombre;
    private int edad;
    private int cantidadExperimentos;

    public Investigador(String nombre, int edad, int cantidadExperimentos) {
        this.nombre = nombre;
        this.edad = edad;
        this.cantidadExperimentos = cantidadExperimentos;
    }

    public String getNombre() {

        return nombre;
    }

    public int getEdad() {

        return edad;
    }

    public void incrementarCantidadExperimentos () {

        this.cantidadExperimentos++;

    }

    public int getCantidadExperimentos() {

        return cantidadExperimentos;
    }
}
