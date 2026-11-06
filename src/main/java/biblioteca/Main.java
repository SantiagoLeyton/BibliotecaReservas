package main.java.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioSalas salas = new RepositorioSalasMemoria();
        RepositorioReservas reservas = new RepositorioReservasMemoria();

        List<ObservadorReserva> observadores = List.of(
            new NotificadorEstudiante(),
            new RegistroEventos()
        );

        ManejadorValidacion horario = new ValidacionHorario();
        ManejadorValidacion capacidad = new ValidacionCapacidad();
        ManejadorValidacion estudianteVal = new ValidacionEstudiante();

        horario.setSiguiente(capacidad);
        capacidad.setSiguiente(estudianteVal);

        ReservaFacade fachada = new ReservaFacade(salas, reservas, observadores, horario);
        Estudiante laura = new Estudiante("E001", "Laura");

        System.out.println("--- PRUEBA ESTACIÓN 8: CASO EXITOSO ---");
        fachada.realizarReserva(
            laura,
            LocalDate.now().plusDays(2),
            LocalTime.of(10, 0),
            2,
            4,
            new SeleccionPorCapacidad()
        );

        System.out.println("\n--- PRUEBA ESTACIÓN 8: FALLO POR HORARIO (21:00) ---");
        fachada.realizarReserva(
            laura,
            LocalDate.now().plusDays(2),
            LocalTime.of(21, 0),
            2,
            4,
            new SeleccionPorCapacidad()
        );

        System.out.println("\n--- PRUEBA ESTACIÓN 8: FALLO POR CAPACIDAD ---");
        fachada.realizarReserva(
            laura,
            LocalDate.now().plusDays(2),
            LocalTime.of(14, 0),
            2,
            50,
            new SeleccionPorCapacidad()
        );
    }
}