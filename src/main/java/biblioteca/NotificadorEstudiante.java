package main.java.biblioteca;

public class NotificadorEstudiante implements ObservadorReserva {
    @Override
    public void actualizar(Reserva reserva, String estadoAnterior, String estadoNuevo) {
        System.out.println("Notificación a " + reserva.getEstudiante().getNombre() + ": su reserva " + reserva.getCodigo() + " cambió de " + estadoAnterior + " a " + estadoNuevo + ".");
    }
}