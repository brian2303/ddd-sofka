package co.com.sofka.dddsofka.domain.reserva;

import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.dddsofka.domain.reserva.events.RecursoAgregado;
import co.com.sofka.dddsofka.domain.reserva.events.ReservaCreada;
import co.com.sofka.dddsofka.domain.reserva.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Reserva extends AggregateEvent<ReservaId> {

    protected FechaDevolucion fechaDevolucion;
    protected FechaReserva fechaReserva;
    protected PrioridadReserva prioridadReserva;
    protected EstadoReserva estadoReserva;
    protected RecursoId recursoId;

    public Reserva(ReservaId reservaId,FechaReserva fechaReserva,FechaDevolucion fechaDevolucion){
        super(reservaId);
        appendChange(new ReservaCreada(reservaId,fechaReserva,fechaDevolucion)).apply();
    }

    public void agregarRecurso(RecursoId recursoId){
        appendChange(new RecursoAgregado(recursoId)).apply();
    }


    public static Reserva from(ReservaId reservaId, List<DomainEvent> events){
        var reserva = new Reserva(reservaId);
        events.forEach(reserva::applyEvent);
        return reserva;
    }

    private Reserva(ReservaId reservaId) {
        super(reservaId);
        subscribe(new ReservaEventChange(this));
    }
}
