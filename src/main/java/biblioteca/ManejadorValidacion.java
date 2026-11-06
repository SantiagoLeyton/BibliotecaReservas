package main.java.biblioteca;

public abstract class ManejadorValidacion {
    protected ManejadorValidacion siguiente;

    public void setSiguiente(ManejadorValidacion siguiente) {
        this.siguiente = siguiente;
    }

    public abstract boolean validar(SolicitudReserva solicitud);

    protected boolean validarSiguiente(SolicitudReserva solicitud) {
        if (siguiente == null) {
            return true;
        }
        return siguiente.validar(solicitud);
    }
}