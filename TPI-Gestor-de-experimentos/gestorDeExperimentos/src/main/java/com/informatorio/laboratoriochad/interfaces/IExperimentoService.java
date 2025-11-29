package com.informatorio.laboratoriochad.interfaces;

import com.informatorio.laboratoriochad.model.*;

import java.util.List;

public interface IExperimentoService {

    ExperimentoQuimico registrarExperimentoQuimico(String nombre, int duracionMinutos,
                                                       Resultado resultado, String tipoReactivo,
                                                       Investigador investigador);

    ExperimentoFisico registrarExperimentoFisico (String nombre, int duracionMinutos,
                                                      Resultado resultado, String instrumento,
                                                      List<Investigador> investigadores);

    List<Experimento> listarExperimentos ();
    int contarExitos ();
    int contarFallos ();
    Experimento experimentoMayorDuracion ();
    double promedioDuracion ();
    double porcentajeExitos ();
    Investigador investigadorConMasExperimentos ();

}
