package com.informatorio.laboratoriochad.service;

import com.informatorio.laboratoriochad.interfaces.IExperimentoService;
import com.informatorio.laboratoriochad.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExperimentoService implements IExperimentoService {

    private List<Experimento> repoExperimentos = new ArrayList<>();
    private InvestigadorService investigadorService;

    public ExperimentoService(InvestigadorService investigadorService) {
        this.investigadorService = investigadorService;
    }

    @Override
    public ExperimentoQuimico registrarExperimentoQuimico(String nombre, int duracionMinutos, Resultado resultado, String tipoReactivo, Investigador investigador) {
        ExperimentoQuimico exp = new ExperimentoQuimico(
                nombre, duracionMinutos, resultado, tipoReactivo, investigador
        );

        investigador.incrementarCantidadExperimentos();
        repoExperimentos.add(exp);

        return exp;
    }

    @Override
    public ExperimentoFisico registrarExperimentoFisico(String nombre, int duracionMinutos, Resultado resultado, String instrumento, List<Investigador> investigadores) {
        ExperimentoFisico exp = new ExperimentoFisico(
                nombre, duracionMinutos, resultado, instrumento, investigadores
        );

        for (Investigador inv : investigadores)
            inv.incrementarCantidadExperimentos();

        repoExperimentos.add(exp);
        return exp;
    }

    @Override
    public List<Experimento> listarExperimentos() {
        return repoExperimentos;
    }

    @Override
    public int contarExitos() {
        return (int) repoExperimentos.stream()
                .filter(Experimento::isExitoso)
                .count();
    }

    @Override
    public int contarFallos() {
        return (int) repoExperimentos.stream()
                .filter(e -> !e.isExitoso())
                .count();
    }

    @Override
    public Experimento experimentoMayorDuracion() {
        return repoExperimentos.stream()
                .max(Comparator.comparingInt(Experimento::getDuracionMinutos))
                .orElse(null);
    }

    @Override
    public double promedioDuracion() {
        return repoExperimentos.stream()
                .mapToInt(Experimento::getDuracionMinutos)
                .average()
                .orElse(0);
    }

    @Override
    public double porcentajeExitos() {
        if (repoExperimentos.isEmpty()) return 0;
        return (contarExitos() * 100.0) / repoExperimentos.size();
    }

    @Override
    public Investigador investigadorConMasExperimentos() {
        return investigadorService.listarInvestigadores().stream()
                .max(Comparator.comparingInt(Investigador::getCantidadExperimentos))
                .orElse(null);
    }
}
