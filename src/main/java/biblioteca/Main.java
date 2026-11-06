package main.java.biblioteca;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sala> disponibles = List.of(
            new Sala("A", "Sala A", 2),
            new Sala("B", "Sala B", 4),
            new Sala("C", "Sala C", 6),
            new Sala("D", "Sala D", 8)
        );

        System.out.println("--PRUEBAS PATRÓN STRATEGY--");

        // en este caso empecé buscando por capacidad, puse un total de 4 personas, por ende, tiene que pasarme la sala B
        EstrategiaSeleccionSala porCapacidad = new SeleccionPorCapacidad();
        Sala seleccionadaCapacidad = porCapacidad.seleccionar(disponibles, 4).orElse(null);
        System.out.println("Selección por capacidad (4 personas): " + seleccionadaCapacidad);

        // en este segundo caso quería que lo hallara por código y pedi la sala C para 4 personas
        EstrategiaSeleccionSala preferidaC = new SeleccionSalaPreferida("C");
        Sala seleccionadaPreferidaC = preferidaC.seleccionar(disponibles, 4).orElse(null);
        System.out.println("Selección preferida C (4 personas): " + seleccionadaPreferidaC);

        // por último, volví a pedir la sala B pero para 5 personas, esto tiene que devolver un NULL o error
        EstrategiaSeleccionSala preferidaB = new SeleccionSalaPreferida("B");
        Sala seleccionadaPreferidaB = preferidaB.seleccionar(disponibles, 5).orElse(null);
        System.out.println("Selección preferida B (5 personas): " + seleccionadaPreferidaB);
    }
}