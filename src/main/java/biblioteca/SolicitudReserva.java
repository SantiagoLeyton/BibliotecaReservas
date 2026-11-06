package main.java.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;

public class SolicitudReserva {
    private final Estudiante estudiante;
    private final LocalDate fecha;
    private final LocalTime horaInicio;
    private final int duracionHoras;
    private final int cantidadPersonas;
    private final Sala sala;

    public SolicitudReserva(Estudiante estudiante, LocalDate fecha, LocalTime horaInicio, int duracionHoras, int cantidadPersonas, Sala sala) {
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracionHoras = duracionHoras;
        this.cantidadPersonas = cantidadPersonas;
        this.sala = sala;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public int getDuracionHoras() { return duracionHoras; }
    public int getCantidadPersonas() { return cantidadPersonas; }
    public Sala getSala() { return sala; }
}