package main.java.biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Sala> salas = List.of(
            new Sala("A", "Sala A", 2),
            new Sala("B", "Sala B", 4),
            new Sala("C", "Sala C", 6),
            new Sala("D", "Sala D", 8)
        );

        System.out.println("Salas de la biblioteca:");
        salas.forEach(System.out::println);

        System.out.println("--- CASO POSITIVO ---");
        Reserva reservaValida = new ReservaBuilder()
            .estudiante(new Estudiante("E001", "Laura"))
            .fecha(LocalDate.now().plusDays(7))
            .horaInicio(LocalTime.of(14, 0))
            .duracionHoras(2)
            .cantidadPersonas(4)
            .sala(new Sala("B", "Sala B", 4))
            .build();

        System.out.println(reservaValida);

        System.out.println("-----------------");

        System.out.println("--- CASO NEGATIVO ---");
        try {Reserva reservaInvalida = new ReservaBuilder()
                .estudiante(new Estudiante("E002", "Brandon"))
                .fecha(LocalDate.now().plusDays(5))
                .horaInicio(LocalTime.of(15, 30))
                .duracionHoras(2)
                .cantidadPersonas(16) //puse un número de estudiantes muy alto, por ende, debe de salir un error
                .sala(new Sala("C", "Sala C", 6))
                .build();

                System.out.println(reservaInvalida);
                
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada; " + e.getMessage());
        }
    }
}