package co.com.sofka.dddsofka.domain.reserva.events;

import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.dddsofka.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.DomainEvent;

public class RecursoAgregado extends DomainEvent {

    private final RecursoId recursoId;

    public RecursoAgregado(RecursoId recursoId) {
        super("prestamos.reserva.recursoagregado");
        this.recursoId = recursoId;
    }

    public RecursoId getRecursoId() {
        return recursoId;
    }
}
