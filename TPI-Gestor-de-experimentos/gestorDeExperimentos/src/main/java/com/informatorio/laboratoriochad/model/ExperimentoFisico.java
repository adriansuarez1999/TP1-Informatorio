package com.informatorio.laboratoriochad.model;

import java.util.List;

public class ExperimentoFisico extends Experimento {

    private String instrumento;
    private List<Investigador> investigadores;

    public ExperimentoFisico(String nombre, int duracionMinutos, Resultado resultado,
                                String instrumento, List<Investigador> investigadores) {
        super(nombre, duracionMinutos, resultado);
        this.instrumento = instrumento;
        this.investigadores = investigadores;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }
}
