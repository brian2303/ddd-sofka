package co.com.sofka.dddsofka.domain.solicitante.events;

import co.com.sofka.dddsofka.domain.reserva.values.ReservaId;
import co.com.sofka.dddsofka.domain.solicitante.values.FechaFinSancion;
import co.com.sofka.dddsofka.domain.solicitante.values.SancionId;
import co.com.sofka.domain.generic.DomainEvent;

public class SancionGenerada extends DomainEvent {

    private final SancionId sancionId;
    private final FechaFinSancion fechaFinSancion;

    public SancionGenerada(SancionId sancionId, FechaFinSancion fechaFinSancion) {
        super("prestamos.solicitante.sanciongenerada");
        this.sancionId = sancionId;
        this.fechaFinSancion = fechaFinSancion;
    }

    public SancionId getSancionId() {
        return sancionId;
    }

    public FechaFinSancion getFechaFinSancion() {
        return fechaFinSancion;
    }
}
