package segundaParte;

public class rankingEntreVariosAlumnos {
    public static void main(String[] args) {
        int[][] notas = {
                { 60, 70, 30, 50, 100 }, // nota del alumno 1
                { 100, 50, 90, 80, 100 }, // nota del alumno 2
                { 20, 40, 100, 50, 70 }, // nota del alumno 3
                { 80, 70, 80, 70, 90 }, // nota del alumno 4
        };

        int mejorAlumno = 0;
        double mejorPromedio = 0;

        int alumnoMasRegular = 0;
        int menorDesviacion = 0;

        int peorAlumnoPrueba3 = 0;
        int peorNotaPrueba3 = notas[0][2]; // se empieza con el examen 3 del primer alumno

        // Bucle para recorrer alumnos
        for (int i = 0; i < notas.length; i++) {
            int suma = 0;
            int max = notas[i][0];
            int min = notas[i][0];

            // recorre las 5 notas de cada alumno
            for (int j = 0; j < notas[i].length; j++) {
                int nota = notas[i][j];
                suma += nota;

                if (nota > max) {
                    max = nota;
                }
                if (nota < min) {
                    min = nota;
                }

                if (j == 2 && nota < peorNotaPrueba3) { // Revisar la tercera prueba y guarda la peor nota con el indice
                                                        // del alumno
                    peorNotaPrueba3 = nota;
                    peorAlumnoPrueba3 = i;
                }
            }

            // calcula promedio
            double promedio = (double) suma / notas[i].length;
            if (i == 0 || promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorAlumno = i;
            }

            // calcula desviación (la diferencia entre nota mayor y menor)
            int desviacion = max - min;
            if (i == 0 || desviacion < menorDesviacion) {
                menorDesviacion = desviacion;
                alumnoMasRegular = i;
            }
        }

        // Resultados
        System.out.println("Mejor promedio: estudiante " + (mejorAlumno + 1) + " con " + mejorPromedio);
        System.out
                .println("Más regular: estudiante " + (alumnoMasRegular + 1) + " (desviación " + menorDesviacion + ")");
        System.out.println(
                "Peor en la 3ra prueba: estudiante " + (peorAlumnoPrueba3 + 1) + " (nota " + peorNotaPrueba3 + ")");
    }
}
