package main.java.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        RepositorioSalas salas = new RepositorioSalasMemoria();
        RepositorioReservas reservas = new RepositorioReservasMemoria();

        ReservaFacade fachada = new ReservaFacade(salas, reservas);
        Estudiante laura = new Estudiante("E001", "Laura");

        System.out.println("--- PRUEBA FACHADA Y REPOSITORIOS ---");
        fachada.realizarReserva(
            laura,
            LocalDate.now().plusDays(7),
            LocalTime.of(14, 0),
            2,
            4,
            new SeleccionPorCapacidad()
        ).ifPresent(System.out::println);
    }
}