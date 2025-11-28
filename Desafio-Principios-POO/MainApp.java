package desafioPrincipiosDePOO;

public class MainApp {
    public static void main(String[] args) {

        Alumno alumno = new Alumno("Sheron", 5);


        alumno.getExam().setNota(0, 70); // Nota 1
        alumno.getExam().setNota(1, 50); // Nota 2
        alumno.getExam().setNota(2, 60); // Nota 3

        alumno.getExam().calcularNota4SegunRegla();

        alumno.getExam().setNota(4, 85);


        alumno.printReport();


        Persona p = alumno;
        System.out.println("-- Usando referencia Persona (polimorfismo) --");
        System.out.println("Tipo: " + p.getTipo() + ", nombre: " + p.getNombre());
    }
}
