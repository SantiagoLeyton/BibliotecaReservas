package main.java.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private final String codigo;
    private final Estudiante estudiante;
    private final LocalDate fecha;
    private final LocalTime horaInicio;
    private final int duracionHoras;
    private final int cantidadPersonas;
    private final Sala sala;
    private EstadoReserva estado = new EstadoPendiente();
    private final List<ObservadorReserva> observadores = new ArrayList<>();

    public Reserva(String codigo, Estudiante estudiante, LocalDate fecha, LocalTime horaInicio, int duracionHoras, int cantidadPersonas, Sala sala) {
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracionHoras = duracionHoras;
        this.cantidadPersonas = cantidadPersonas;
        this.sala = sala;
    }

    public void agregarObservador(ObservadorReserva observador) {
        if (observador != null) {
            observadores.add(observador);
        }
    }

    public void retirarObservador(ObservadorReserva observador) {
        observadores.remove(observador);
    }

    public void setEstado(EstadoReserva nuevoEstado) {
        String anterior = this.estado.getNombre();
        this.estado = nuevoEstado;
        for (ObservadorReserva observador : List.copyOf(observadores)) {
            observador.actualizar(this, anterior, nuevoEstado.getNombre());
        }
    }

    public void confirmar() {
        estado.confirmar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public String getCodigo() { return codigo; }
    public Estudiante getEstudiante() { return estudiante; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public int getDuracionHoras() { return duracionHoras; }
    public int getCantidadPersonas() { return cantidadPersonas; }
    public Sala getSala() { return sala; }
    public EstadoReserva getEstado() { return estado; }

    @Override
    public String toString() {
        return "Reserva " + codigo + " | " + estudiante.getNombre() + " | " + fecha + " " + horaInicio + " | " + sala + " | Estado: " + estado.getNombre();
    }
}