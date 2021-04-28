package co.com.sofka.dddsofka.domain.reserva;

import co.com.sofka.dddsofka.domain.reserva.events.RecursoAgregado;
import co.com.sofka.dddsofka.domain.reserva.events.ReservaCreada;
import co.com.sofka.domain.generic.EventChange;

public class ReservaEventChange extends EventChange {

    public ReservaEventChange(Reserva reserva) {
        apply((ReservaCreada event) ->{
            reserva.fechaReserva = event.getFechaReserva();
            reserva.fechaDevolucion = event.getFechaDevolucion();
        });

        apply((RecursoAgregado event)->{
           reserva.recursoId = event.getRecursoId();
        });
    }
}
