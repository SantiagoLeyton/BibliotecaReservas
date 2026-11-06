package main.java.biblioteca;

public class RegistroEventos implements ObservadorReserva {
    @Override
    public void actualizar(Reserva reserva, String estadoAnterior, String estadoNuevo) {
        System.out.println("Evento registrado: " + reserva.getCodigo() + " cambió de " + estadoAnterior + " a " + estadoNuevo + ".");
    }
}