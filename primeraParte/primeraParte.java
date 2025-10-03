package primeraParte;

public class primeraParte {
    public static void main(String[] args) {
        // 1era Parte
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

        System.out.println("Nota del exámen 1: " + notaExamen[0]); // Imprime en la
        // pantalla la nota 1
        System.out.println("Nota del exámen 2: " + notaExamen[1]); // Imprime en la
        // pantalla la nota 2
        System.out.println("Nota del exámen 3: " + notaExamen[2]); // Imprime en la
        // pantalla la nota 3
        System.out.println("Nota del exámen 4: " + notaExamen[3]); // Imprime en la
        // pantalla la nota 4
        System.out.println("Nota del exámen 5: " + notaExamen[4]); // Imprime en la
        // pantalla la nota 5
    }
}
