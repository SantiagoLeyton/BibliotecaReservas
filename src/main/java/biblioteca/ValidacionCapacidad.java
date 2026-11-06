package main.java.biblioteca;

public class ValidacionCapacidad extends ManejadorValidacion {
    @Override
    public boolean validar(SolicitudReserva solicitud) {
        if (solicitud.getCantidadPersonas() > solicitud.getSala().getCapacidad()) {
            System.out.println("Error de Validación: La cantidad de personas (" + solicitud.getCantidadPersonas() + ") excede la capacidad de la " + solicitud.getSala().getNombre() + " (Máx: " + solicitud.getSala().getCapacidad() + ").");
            return false;
        }

        return validarSiguiente(solicitud);
    }
}