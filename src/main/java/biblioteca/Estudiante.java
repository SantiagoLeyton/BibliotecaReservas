package main.java.biblioteca;

public class Estudiante {
    private final String identificador;
    private final String nombre;

    public Estudiante(String identificador, String nombre) {
        if(identificador == null || nombre == null || identificador.isBlank() || nombre.isBlank()) {
            throw new IllegalArgumentException("Identificador y nombre no puede estar vacio.");
        } 
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public String getIdenticador() { return identificador; }
    public String getNombre() { return nombre; }
}