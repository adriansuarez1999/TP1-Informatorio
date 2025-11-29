package com.informatorio.laboratoriochad.model;

public class ExperimentoQuimico extends Experimento {

    private String tipoReactivo;
    private Investigador investigador;

    public ExperimentoQuimico(String nombre, int duracionMinutos, Resultado resultado,
                                String tipoReactivo, Investigador investigador) {
        super(nombre, duracionMinutos, resultado);
        this.tipoReactivo = tipoReactivo;
        this.investigador = investigador;
    }

    public String getTipoReactivo() {
        return tipoReactivo;
    }

    public Investigador getInvestigador() {
        return investigador;
    }
}
