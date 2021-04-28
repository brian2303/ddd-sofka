package co.com.sofka.dddsofka.usecase.reserva;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.dddsofka.domain.reserva.Reserva;
import co.com.sofka.dddsofka.domain.reserva.values.ReservaId;
import co.com.sofka.dddsofka.domain.solicitante.events.ReservaGenerada;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;

public class CrearReservaUseCase extends UseCase<TriggeredEvent<ReservaGenerada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ReservaGenerada> reservaGenerada) {
        var event = reservaGenerada.getDomainEvent();

        var reserva = new Reserva(new ReservaId(),event.getFechaReserva(),event.getFechaDevolucion());
        var service = getService(SolicitanteService.class).orElseThrow();
        var solicitante = service.findById(SolicitanteId.of(event.aggregateRootId()));

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
