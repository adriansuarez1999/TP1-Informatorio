package desafioPrincipiosDePOO;

import java.util.Arrays;

public class ExamScores {

    private int[] notas;

    public ExamScores(int size) {
        this.notas = new int[size];
        // opcional: inicializar con ceros
        Arrays.fill(this.notas, 0);
    }

    // Setter individual
    public void setNota(int index, int value) {
        if (index >= 0 && index < notas.length) {
            notas[index] = value;
        }
    }

    // Getter (copia para evitar exposición directa del array)
    public int[] getNotas() {
        return Arrays.copyOf(notas, notas.length);
    }

    // Calcula la nota 4 según la regla: si nota[1] < 60 => nota4 = 100, si no nota4 = nota[1]
    public void calcularNota4SegunRegla() {
        if (notas.length > 3) {
            if (notas[1] < 60) {
                notas[3] = 100;
            } else {
                notas[3] = notas[1];
            }
        }
    }

    // Promedio (suma / cantidad)
    public double promedio() {
        if (notas.length == 0) return 0;
        int suma = 0;
        for (int n : notas) suma += n;
        return (double) suma / notas.length;
    }

    // Devuelve una copia ordenada descendente (sin modificar el original)
    public int[] obtenerNotasOrdenadasDesc() {
        int[] copia = Arrays.copyOf(notas, notas.length);
        Arrays.sort(copia);
        // invertir para descendente
        for (int i = 0; i < copia.length / 2; i++) {
            int tmp = copia[i];
            copia[i] = copia[copia.length - 1 - i];
            copia[copia.length - 1 - i] = tmp;
        }
        return copia;
    }

    // Encuentra posicion de la nota maxima y minima (primera ocurrencia)
    public int posicionMaxima() {
        int pos = 0;
        for (int i = 1; i < notas.length; i++)
            if (notas[i] > notas[pos]) pos = i;
        return pos;
    }
    public int posicionMinima() {
        int pos = 0;
        for (int i = 1; i < notas.length; i++)
            if (notas[i] < notas[pos]) pos = i;
        return pos;
    }

    // Variación máxima entre pruebas consecutivas
    public int variacionMaxima() {
        if (notas.length < 2) return 0;
        int variacionMaxima = 0;
        for (int i = 1; i < notas.length; i++) {
            int variacion = Math.abs(notas[i] - notas[i - 1]);
            if (variacion > variacionMaxima) variacionMaxima = variacion;
        }
        return variacionMaxima;
    }

    // utilidad: mostrar notas como String
    public String notasToString() {
        return Arrays.toString(notas);
    }
}

