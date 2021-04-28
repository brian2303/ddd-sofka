package co.com.sofka.dddsofka.domain.solicitante.events;

import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.dddsofka.domain.reserva.values.FechaDevolucion;
import co.com.sofka.dddsofka.domain.reserva.values.FechaReserva;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.domain.generic.DomainEvent;

public class ReservaGenerada extends DomainEvent {

    private final RecursoId recursoId;
    private final FechaReserva fechaReserva;
    private final FechaDevolucion fechaDevolucion;

    public ReservaGenerada(RecursoId recursoId,FechaReserva fechaReserva,FechaDevolucion fechaDevolucion)
    {
        super("prestamos.solicitante.reservagenerada");
        this.recursoId = recursoId;
        this.fechaReserva = fechaReserva;
        this.fechaDevolucion = fechaDevolucion;
    }


    public RecursoId getRecursoId() {
        return recursoId;
    }

    public FechaReserva getFechaReserva() {
        return fechaReserva;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }
}
