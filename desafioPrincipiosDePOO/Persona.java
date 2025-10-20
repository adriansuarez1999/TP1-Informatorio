package desafioPrincipiosDePOO;


public abstract class Persona {
    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método abstracto: obliga a las subclases a indicar su tipo (polimorfismo)
    public abstract String getTipo();
}

