package com.informatorio.laboratoriochad.interfaces;

import com.informatorio.laboratoriochad.model.Investigador;

import java.util.List;

public interface IInvestigadorService {

    Investigador registrarInvestigador (String nombre, int edad);
    List<Investigador> listarInvestigadores ();
    void exportarInvestigadoresCSV(String rutaArchivo);
    Investigador buscarPorNombre(String nombre);

}
