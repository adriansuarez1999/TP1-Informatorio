package segundaParte;

public class bonusPorProgreso {
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

        int contadorMejorNota = 0;
        for (int i = 1; i < notaExamen.length; i++) {
            if (notaExamen[i] > notaExamen[i - 1]) {
                contadorMejorNota++;

            }
        }
        if (contadorMejorNota == notaExamen.length - 1) {
            System.out.println("¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento");

        } else {
            System.out.println("Sos un Stone Beta, te falta crecer");
        }
    }
}
