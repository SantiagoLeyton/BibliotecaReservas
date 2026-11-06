package main.java.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class ReservaBuilder {
    private Estudiante estudiante;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private int duracionHoras;
    private int cantidadPersonas;
    private Sala sala;

    public ReservaBuilder estudiante(Estudiante valor) {
        this.estudiante = valor;
        return this;
    }
    public ReservaBuilder fecha(LocalDate valor) {
        this.fecha = valor;
        return this;
    }
    public ReservaBuilder horaInicio(LocalTime valor) {
        this.horaInicio = valor;
        return this;
    }
    public ReservaBuilder duracionHoras(int valor) {
        this.duracionHoras = valor;
        return this;
    }
    public ReservaBuilder cantidadPersonas(int valor) {
        this.cantidadPersonas = valor;
        return this;
    }
    public ReservaBuilder sala(Sala valor) {
        this.sala = valor;
        return this;
    }

    public Reserva build() {
        if (estudiante == null || fecha == null || horaInicio == null || sala == null) {
            throw new IllegalStateException("Tienes que poner mínimo al estudiante, la fecha, la hora de inicio y la sala.");
        } else if (fecha.isBefore(LocalDate.now()) || duracionHoras <= 0 || cantidadPersonas <= 0) {
            throw new IllegalStateException("Verifica que los siguientes datos sean correcto: fecha, duración y cantidad de personas");
        } else if (sala.getCapacidad() < cantidadPersonas) {
            throw new IllegalStateException("La cantidad de personas excede la capacidad de la sala!");
        }

    String codigo = "R-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    /* La línea anterior nos crea un código de hasta 36 caracteres, pero reducido a solo 8,
    convertido en String y poniendo todo en mayusculas */
    
    return new Reserva(codigo, estudiante, fecha, horaInicio, duracionHoras, cantidadPersonas, sala);
    }
}