package main.java.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private final String codigo;
    private final Estudiante estudiante;
    private final LocalDate fecha;
    private final LocalTime horaInicio;
    private final int duracionHoras;
    private final int cantidadPersonas;
    private final Sala sala;
    private String estado = "Pendiente"; //se pone en pendiente ya que aún no tenemos la clase de estado creada

    public Reserva(String codigo, Estudiante estudiante, LocalDate fecha, LocalTime horaInicio, int duracionHoras, int cantidadPersonas, Sala sala /*, Estado estado*/) {
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracionHoras = duracionHoras;
        this.cantidadPersonas = cantidadPersonas;
        this.sala = sala;
        //this.estado = estado;
    }

    public String getCodigo() { return codigo; }
    public Estudiante getEstudiante() { return estudiante; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public int getDuracionHoras() { return duracionHoras; }
    public int getCantidadPersonas() { return cantidadPersonas; }
    public Sala getSala() { return sala; }
    //public Estado getEstado() { return estado; }

    @Override 
    public String toString() {
        return "Reserva " + codigo + " | " + estudiante.getNombre() + " | " + fecha + " " + horaInicio + " | " + sala + " |  Estado: " + estado;
    }
}