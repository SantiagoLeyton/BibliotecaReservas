package main.java.biblioteca;

public class ValidacionEstudiante extends ManejadorValidacion {
    @Override
    public boolean validar(SolicitudReserva solicitud) {
        if (solicitud.getEstudiante() == null || solicitud.getEstudiante().getIdentificador() == null || solicitud.getEstudiante().getIdentificador().isEmpty()) {
            System.out.println("Error de Validación: El estudiante ingresado no es válido o carece de identificación.");
            return false;
        }

        return validarSiguiente(solicitud);
    }
}