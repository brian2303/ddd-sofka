package co.com.sofka.dddsofka.domain.recurso.events;

import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.domain.generic.DomainEvent;

public class RecursoReservado extends DomainEvent {

    public RecursoReservado(RecursoId entityId) {
        super(entityId.value());
    }
}
