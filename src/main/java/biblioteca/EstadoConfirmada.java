package main.java.biblioteca;

public class EstadoConfirmada implements EstadoReserva {
    @Override
    public void confirmar(Reserva reserva) {
        System.out.println("La reserva " + reserva.getCodigo() + " ya se encuentra en estado Confirmada.");
    }

    @Override
    public void cancelar(Reserva reserva) {
        reserva.setEstado(new EstadoCancelada());
    }

    @Override
    public String getNombre() {
        return "Confirmada";
    }
}