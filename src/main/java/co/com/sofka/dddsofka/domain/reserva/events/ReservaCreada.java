package co.com.sofka.dddsofka.domain.reserva.events;

import co.com.sofka.dddsofka.domain.reserva.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class ReservaCreada extends DomainEvent {

    private final ReservaId reservaId;
    private final FechaReserva fechaReserva;
    private final FechaDevolucion fechaDevolucion;


    public ReservaCreada(ReservaId reservaId,FechaReserva fechaReserva,FechaDevolucion fechaDevolucion){
        super("prestamos.reserva.reservacreada");
        this.reservaId = reservaId;
        this.fechaReserva = fechaReserva;
        this.fechaDevolucion = fechaDevolucion;
    }

    public ReservaId getReservaId() {
        return reservaId;
    }

    public FechaReserva getFechaReserva() {
        return fechaReserva;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }
}
