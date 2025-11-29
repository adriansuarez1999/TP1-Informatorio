package com.informatorio.laboratoriochad.service;

import com.informatorio.laboratoriochad.model.Investigador;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.List;

public class CSVExportService {

    public static void exportarInvestigadores(List<Investigador> investigadores, String rutaArchivo) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(rutaArchivo))) {


            String[] header = {"nombre", "edad", "cantidad_experimentos"};
            writer.writeNext(header);


            for (Investigador inv : investigadores) {
                String[] fila = {
                        inv.getNombre(),
                        String.valueOf(inv.getEdad()),
                        String.valueOf(inv.getCantidadExperimentos())
                };
                writer.writeNext(fila);
            }

            System.out.println("CSV exportado correctamente ➜ " + rutaArchivo);

        } catch (Exception e) {
            System.out.println("Error al exportar CSV: " + e.getMessage());
        }
    }
}
