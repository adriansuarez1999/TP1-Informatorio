package desafioPrincipiosDePOO;

public class MainApp {
    public static void main(String[] args) {
        // Crear un alumno con espacio para 5 notas (igual que tus scripts originales)
        Alumno alumno = new Alumno("Sheron", 5);

        // Cargar algunas notas (equivalente a lo que tenías en el array)
        alumno.getExam().setNota(0, 70); // Nota 1
        alumno.getExam().setNota(1, 50); // Nota 2
        alumno.getExam().setNota(2, 60); // Nota 3
        // Nota 4 se calculará según la regla:
        alumno.getExam().calcularNota4SegunRegla();
        // Podés setear manualmente la nota 5 si querés:
        alumno.getExam().setNota(4, 85);

        // Imprimir reporte completo
        alumno.printReport();

        // Ejemplo de polimorfismo: podemos referenciar a Alumno como Persona
        Persona p = alumno;
        System.out.println("-- Usando referencia Persona (polimorfismo) --");
        System.out.println("Tipo: " + p.getTipo() + ", nombre: " + p.getNombre());
    }
}


