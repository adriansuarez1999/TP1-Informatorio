package com.informatorio.laboratoriochad.model;

public abstract class Experimento {

    private String nombre;
    private int duracionMinutos;
    private Resultado resultado;

    public Experimento() {
    }

    public Experimento(String nombre, int duracionMinutos, Resultado resultado) {
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        this.resultado = resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public boolean isExito () {
        return this.resultado == Resultado.EXITO;
    }
}
