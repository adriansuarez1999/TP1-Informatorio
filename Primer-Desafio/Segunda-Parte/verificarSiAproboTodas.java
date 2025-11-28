package segundaParte;

public class verificarSiAproboTodas {
    public static void main(String[] args) {
        int[] notaExamen = new int[5];
        notaExamen[0] = 70; // Nota 1
        notaExamen[1] = 50; // Nota 2
        notaExamen[2] = 60; // Nota 3

        if (notaExamen[1] < 60) {
            notaExamen[3] = 100; // Nota 4
        } else if (notaExamen[1] >= 60) {
            notaExamen[3] = notaExamen[1]; // Nota 4 = Nota 2
        }

        if (notaExamen[0] + notaExamen[2] > 150) {
            notaExamen[4] = 95; // Nota 5
        } else {
            notaExamen[4] = 70; // Nota 5, cuando la suma de la nota 1 y 3 es menor o igual a 150
        }

        int contador = 0;
        for (int i = 0; i < notaExamen.length; i++) { // Cuenta unicamente las notas desaprobadas
            if (notaExamen[i] < 60) {
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("Resultado: Aprobaste todas. ¡Backend Sensei!");
        } else if (contador == 5) {
            System.out.println("Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!");
        } else {
            System.out.println("Resultado: Algunas aprobadas. Sos un refactor en progreso.");
        }

    }

}
