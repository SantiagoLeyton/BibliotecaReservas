package main.java.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class ReservaFacade {
    private final RepositorioSalas repositorioSalas;
    private final RepositorioReservas repositorioReservas;
    private final List<ObservadorReserva> observadores;
    private final ManejadorValidacion cadenaValidacion;

    public ReservaFacade(RepositorioSalas repositorioSalas, RepositorioReservas repositorioReservas, List<ObservadorReserva> observadores, ManejadorValidacion cadenaValidacion) {
        this.repositorioSalas = repositorioSalas;
        this.repositorioReservas = repositorioReservas;
        this.observadores = List.copyOf(observadores);
        this.cadenaValidacion = cadenaValidacion;
    }

    public Optional<Reserva> realizarReserva(
            Estudiante estudiante, 
            LocalDate fecha, 
            LocalTime hora, 
            int duracion, 
            int personas, 
            EstrategiaSeleccionSala estrategia) {

        List<Sala> disponibles = repositorioSalas.obtenerDisponibles();
        Optional<Sala> salaElegida = estrategia.seleccionar(disponibles, personas);

        if (salaElegida.isEmpty()) {
            System.out.println("No hay una sala disponible que cumpla la solicitud.");
            return Optional.empty();
        }

        SolicitudReserva solicitud = new SolicitudReserva(estudiante, fecha, hora, duracion, personas, salaElegida.get());

        if (!cadenaValidacion.validar(solicitud)) {
            System.out.println("Solicitud rechazada por la cadena de validación.");
            return Optional.empty();
        }

        Reserva reserva = new ReservaBuilder()
                .estudiante(estudiante)
                .fecha(fecha)
                .horaInicio(hora)
                .duracionHoras(duracion)
                .cantidadPersonas(personas)
                .sala(salaElegida.get())
                .build();

        observadores.forEach(reserva::agregarObservador);
        repositorioReservas.guardar(reserva);
        reserva.cambiarEstado("Confirmada"); 

        return Optional.of(reserva);
    }
}