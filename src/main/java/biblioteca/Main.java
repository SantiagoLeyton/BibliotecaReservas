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

        ReservaFacade fachada = new ReservaFacade(salas, reservas, observadores);
        Estudiante laura = new Estudiante("E001", "Laura");

        System.out.println("--- PRUEBA ESTACIÓN 7: STATE Y OBSERVER ---");
        
        Reserva reserva = fachada.realizarReserva(
            laura,
            LocalDate.now().plusDays(7),
            LocalTime.of(14, 0),
            2,
            4,
            new SeleccionPorCapacidad()
        ).orElseThrow();

        System.out.println("\nEstado actual de la reserva:");
        System.out.println(reserva);

        System.out.println("\n--- CANCELANDO RESERVA ---");
        reserva.cancelar();
        System.out.println(reserva);

        System.out.println("\n--- INTENTANDO CONFIRMAR RESERVA CANCELADA ---");
        reserva.confirmar();
    }
}