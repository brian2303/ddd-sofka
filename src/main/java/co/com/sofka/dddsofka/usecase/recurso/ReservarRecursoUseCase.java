package co.com.sofka.dddsofka.usecase.recurso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.dddsofka.domain.recurso.Recurso;
import co.com.sofka.dddsofka.domain.reserva.events.RecursoAgregado;

public class ReservarRecursoUseCase extends UseCase<TriggeredEvent<RecursoAgregado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<RecursoAgregado> inputEvent) {
        var event = inputEvent.getDomainEvent();
        var recurso = Recurso.from(event.getRecursoId(),retrieveEvents());
        recurso.asignarAReserva();
        emit().onResponse(new ResponseEvents(recurso.getUncommittedChanges()));
    }

}
