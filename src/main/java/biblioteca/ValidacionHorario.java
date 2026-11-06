package main.java.biblioteca;

import java.time.LocalTime;

public class ValidacionHorario extends ManejadorValidacion {
    private static final LocalTime HORA_APERTURA = LocalTime.of(7, 0);
    private static final LocalTime HORA_CIERRE = LocalTime.of(20, 0);

    @Override
    public boolean validar(SolicitudReserva solicitud) {
        LocalTime inicio = solicitud.getHoraInicio();
        LocalTime fin = inicio.plusHours(solicitud.getDuracionHoras());

        if (inicio.isBefore(HORA_APERTURA) || fin.isAfter(HORA_CIERRE)) {
            System.out.println("Error de Validación: El horario solicitado (" + inicio + " a " + fin + ") está fuera del servicio de la biblioteca (07:00 a 20:00).");
            return false;
        }

        return validarSiguiente(solicitud);
    }
}