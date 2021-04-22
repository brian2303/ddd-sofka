package co.com.sofka.dddsofka.domain.reserva;

import co.com.sofka.dddsofka.domain.reserva.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

public class Reserva extends AggregateEvent<ReservaId> {

    protected FechaReserva fechaReserva;
    protected FechaDevolucion fechaDevolucion;
    protected EstadoReserva estadoReserva;
    protected PrioridadReserva prioridadReserva;


    private Reserva(ReservaId entityId) {
        super(entityId);
    }
}
