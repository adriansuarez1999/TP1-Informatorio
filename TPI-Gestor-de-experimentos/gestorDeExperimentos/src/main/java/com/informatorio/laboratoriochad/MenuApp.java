package com.informatorio.laboratoriochad;

import com.informatorio.laboratoriochad.model.*;
import com.informatorio.laboratoriochad.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuApp {

    private static InvestigadorService investigadorService = new InvestigadorService();
    private static ExperimentoService experimentoService = new ExperimentoService(investigadorService);
    private static CSVExportService csvExportService = new CSVExportService();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n===== LABORATORIO CHAD =====");
            System.out.println("1. Registrar Investigador");
            System.out.println("2. Registrar Experimento Químico");
            System.out.println("3. Registrar Experimento Físico");
            System.out.println("4. Listar Experimentos");
            System.out.println("5. Mostrar total de éxitos y fallos");
            System.out.println("6. Experimento de mayor duración");
            System.out.println("7. Reporte: promedio duración y % de éxito");
            System.out.println("8. Investigador con más experimentos");
            System.out.println("9. Exportar investigadores a CSV");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            ejecutarOpcion(opcion);

        } while (opcion != 0);

    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {

            case 1 -> registrarInvestigador();
            case 2 -> registrarExperimentoQuimico();
            case 3 -> registrarExperimentoFisico();
            case 4 -> listarExperimentos();
            case 5 -> mostrarExitosFallos();
            case 6 -> mostrarMayorDuracion();
            case 7 -> mostrarReporte();
            case 8 -> mostrarInvestigadorConMasExperimentos();
            case 9 -> exportarCSV();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción inválida.");
        }
    }


    //  OPCIONES DEL MENÚ

    private static void registrarInvestigador() {
        System.out.print("Nombre del Investigador: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = leerEntero();

        Investigador inv = investigadorService.registrarInvestigador(nombre, edad);
        System.out.println("Investigador registrado: " + inv.getNombre());
    }

    private static void registrarExperimentoQuimico() {

        System.out.print("Nombre del experimento: ");
        String nombre = scanner.nextLine();

        System.out.print("Duración en minutos: ");
        int duracion = leerEntero();

        Resultado resultado = leerResultado();

        System.out.print("Tipo de reactivo: ");
        String tipoReactivo = scanner.nextLine();

        System.out.print("Nombre del investigador responsable: ");
        String nombreInv = scanner.nextLine();

        Investigador inv = investigadorService.buscarPorNombre(nombreInv);

        if (inv == null) {
            System.out.println("Investigador no encontrado.");
            return;
        }

        experimentoService.registrarExperimentoQuimico(nombre, duracion, resultado, tipoReactivo, inv);
        System.out.println("Experimento químico registrado.");
    }

    private static void registrarExperimentoFisico() {

        System.out.print("Nombre del experimento: ");
        String nombre = scanner.nextLine();

        System.out.print("Duración en minutos: ");
        int duracion = leerEntero();

        Resultado resultado = leerResultado();

        System.out.print("Instrumento utilizado: ");
        String instrumento = scanner.nextLine();

        List<Investigador> investigadores = new ArrayList<>();

        System.out.print("Cantidad de investigadores participantes: ");
        int cantidad = leerEntero();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre del investigador #" + (i + 1) + ": ");
            String nombreInv = scanner.nextLine();

            Investigador inv = investigadorService.buscarPorNombre(nombreInv);
            if (inv != null) {
                investigadores.add(inv);
            } else {
                System.out.println("Investigador no encontrado, ignorado.");
            }
        }

        experimentoService.registrarExperimentoFisico(nombre, duracion, resultado, instrumento, investigadores);
        System.out.println("Experimento físico registrado.");
    }

    private static void listarExperimentos() {
        List<Experimento> lista = experimentoService.listarExperimentos();

        if (lista.isEmpty()) {
            System.out.println("No hay experimentos registrados.");
            return;
        }

        System.out.println("\n=== LISTADO DE EXPERIMENTOS ===");
        for (Experimento e : lista) {
            System.out.println("- " + e.getNombre() + " | Tipo: " + e.getClass().getSimpleName() +
                    " | Resultado: " + e.getResultado());
        }
    }

    private static void mostrarExitosFallos() {
        System.out.println("Total de éxitos: " + experimentoService.contarExitos());
        System.out.println("Total de fallos: " + experimentoService.contarFallos());
    }

    private static void mostrarMayorDuracion() {
        Experimento e = experimentoService.experimentoMayorDuracion();

        if (e == null) {
            System.out.println("No hay experimentos registrados.");
            return;
        }

        System.out.println("Experimento de mayor duración: " + e.getNombre() +
                " (" + e.getDuracionMinutos() + " min)");
    }

    private static void mostrarReporte() {
        System.out.println("Promedio de duración: " + experimentoService.promedioDuracion());
        System.out.println("Porcentaje de éxitos: " + experimentoService.porcentajeExitos() + "%");
    }

    private static void mostrarInvestigadorConMasExperimentos() {
        Investigador inv = experimentoService.investigadorConMasExperimentos();

        if (inv == null) {
            System.out.println("No hay investigadores con experimentos.");
            return;
        }

        System.out.println("Investigador con más experimentos:");
        System.out.println(inv.getNombre() + " – " + inv.getCantidadExperimentos() + " experimentos");
    }

    private static void exportarCSV() {
        System.out.print("Nombre del archivo CSV (ej: investigadores.csv): ");
        String ruta = scanner.nextLine();

        csvExportService.exportarInvestigadores(
                investigadorService.listarInvestigadores(),
                ruta
        );

        System.out.println("Archivo exportado correctamente: " + ruta);
    }


    //  MÉTODOS DE APOYO

    private static int leerEntero() {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private static Resultado leerResultado() {
        System.out.print("Resultado (1=ÉXITO, 2=FALLO): ");
        int op = leerEntero();
        return (op == 1) ? Resultado.EXITO : Resultado.FALLO;
    }
}
