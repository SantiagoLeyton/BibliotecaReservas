package main.java.biblioteca;

public class EstadoPendiente implements EstadoReserva {
    @Override
    public void confirmar(Reserva reserva) {
        reserva.setEstado(new EstadoConfirmada());
    }

    @Override
    public void cancelar(Reserva reserva) {
        reserva.setEstado(new EstadoCancelada());
    }

    @Override
    public String getNombre() {
        return "Pendiente";
    }
}