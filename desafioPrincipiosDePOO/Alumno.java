package desafioPrincipiosDePOO;


public class Alumno extends Persona implements Reportable {

    private ExamScores exam;

    public Alumno(String nombre, int cantidadDePruebas) {
        super(nombre);
        this.exam = new ExamScores(cantidadDePruebas);
    }

    public ExamScores getExam() {
        return exam;
    }

    @Override
    public String getTipo() {
        return "Alumno";
    }

    @Override
    public void printReport() {
        System.out.println("Reporte de " + getTipo() + ": " + nombre);
        System.out.println("Notas: " + exam.notasToString());
        System.out.println("Promedio: " + exam.promedio());
        System.out.println("Notas ordenadas (desc): " + java.util.Arrays.toString(exam.obtenerNotasOrdenadasDesc()));
        System.out.println("Posición máxima (índice): " + exam.posicionMaxima());
        System.out.println("Posición mínima (índice): " + exam.posicionMinima());
        System.out.println("Variación máxima entre pruebas consecutivas: " + exam.variacionMaxima());
    }
}


