package main.java.biblioteca;

public interface EstadoReserva {
    void confirmar(Reserva reserva);
    void cancelar(Reserva reserva);
    String getNombre();
}