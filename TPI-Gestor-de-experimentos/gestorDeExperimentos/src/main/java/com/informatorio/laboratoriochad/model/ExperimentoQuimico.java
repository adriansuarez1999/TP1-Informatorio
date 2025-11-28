package com.informatorio.laboratoriochad.model;

public class ExperimentoQuimico extends Experimento {

    private String tipoReactivo;

    public ExperimentoQuimico(String nombre, int duracionMinutos, Resultado resultado, String tipoReactivo) {
        super(nombre, duracionMinutos, resultado);
        this.tipoReactivo = tipoReactivo;
    }

    public String getTipoReactivo() {
        return tipoReactivo;
    }


}
