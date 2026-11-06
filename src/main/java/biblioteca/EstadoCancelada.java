package main.java.biblioteca;

public class EstadoCancelada implements EstadoReserva {
    @Override
    public void confirmar(Reserva reserva) {
        System.out.println("No se puede confirmar la reserva " + reserva.getCodigo() + " porque está Cancelada.");
    }

    @Override
    public void cancelar(Reserva reserva) {
        System.out.println("La reserva " + reserva.getCodigo() + " ya se encuentra Cancelada.");
    }

    @Override
    public String getNombre() {
        return "Cancelada";
    }
}