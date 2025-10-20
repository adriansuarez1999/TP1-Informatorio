package desafioPrincipiosDePOO;

import java.util.Arrays;

public class ExamScores {

    private int[] notas;

    public ExamScores(int size) {
        this.notas = new int[size];

        Arrays.fill(this.notas, 0);
    }


    public void setNota(int index, int value) {
        if (index >= 0 && index < notas.length) {
            notas[index] = value;
        }
    }


    public int[] getNotas() {
        return Arrays.copyOf(notas, notas.length);
    }


    public void calcularNota4SegunRegla() {
        if (notas.length > 3) {
            if (notas[1] < 60) {
                notas[3] = 100;
            } else {
                notas[3] = notas[1];
            }
        }
    }


    public double promedio() {
        if (notas.length == 0) return 0;
        int suma = 0;
        for (int n : notas) suma += n;
        return (double) suma / notas.length;
    }


    public int[] obtenerNotasOrdenadasDesc() {
        int[] copia = Arrays.copyOf(notas, notas.length);
        Arrays.sort(copia);

        for (int i = 0; i < copia.length / 2; i++) {
            int tmp = copia[i];
            copia[i] = copia[copia.length - 1 - i];
            copia[copia.length - 1 - i] = tmp;
        }
        return copia;
    }


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


    public int variacionMaxima() {
        if (notas.length < 2) return 0;
        int variacionMaxima = 0;
        for (int i = 1; i < notas.length; i++) {
            int variacion = Math.abs(notas[i] - notas[i - 1]);
            if (variacion > variacionMaxima) variacionMaxima = variacion;
        }
        return variacionMaxima;
    }


    public String notasToString() {
        return Arrays.toString(notas);
    }
}

