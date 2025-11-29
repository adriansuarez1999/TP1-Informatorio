package com.informatorio.laboratoriochad.service;

import com.informatorio.laboratoriochad.interfaces.IInvestigadorService;
import com.informatorio.laboratoriochad.model.Investigador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvestigadorService implements IInvestigadorService {

    private final Map<String, Investigador> repo = new HashMap<>();

    public InvestigadorService() {
    }


    @Override
    public Investigador registrarInvestigador(String nombre, int edad) {
        Investigador inv = new Investigador(nombre, edad, 0);
        repo.put(nombre, inv);
        return inv;
    }

    @Override
    public List<Investigador> listarInvestigadores() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public void exportarInvestigadoresCSV(String rutaArchivo) {
        CSVExportService.exportarInvestigadores(listarInvestigadores(), rutaArchivo);

    }

    @Override
    public Investigador buscarPorNombre(String nombre) {
        return repo.get(nombre);
    }
}
