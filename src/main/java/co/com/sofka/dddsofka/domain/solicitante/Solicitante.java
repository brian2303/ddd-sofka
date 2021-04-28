package co.com.sofka.dddsofka.domain.solicitante;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.dddsofka.domain.reserva.Reserva;
import co.com.sofka.dddsofka.domain.reserva.values.FechaDevolucion;
import co.com.sofka.dddsofka.domain.reserva.values.FechaReserva;
import co.com.sofka.dddsofka.domain.reserva.values.ReservaId;
import co.com.sofka.dddsofka.domain.solicitante.events.ReservaGenerada;
import co.com.sofka.dddsofka.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.dddsofka.domain.solicitante.values.NombreSolicitante;
import co.com.sofka.dddsofka.domain.solicitante.values.SancionId;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Solicitante extends AggregateEvent<SolicitanteId> {

    protected NombreSolicitante nombreCompleto;
    protected Map<SancionId,Sancion> sanciones;
    protected Boolean activo;

    public Solicitante(SolicitanteId solicitanteId, NombreSolicitante nombreSolicitante){
        super(solicitanteId);
        this.nombreCompleto = nombreSolicitante;
        appendChange(new SolicitanteCreado(solicitanteId,nombreSolicitante)).apply();
    }

    public void generarReserva(SolicitanteId solicitanteId,RecursoId recursoId, FechaReserva fechaReserva, FechaDevolucion fechaDevolucion){
        sanciones.values()
            .forEach(sancion -> {
                if (sancion.estaActiva()){
                    throw new BusinessException(solicitanteId.value(),"El solicitante presenta sanciones activas");
                }
            });
        appendChange(new ReservaGenerada(recursoId,fechaReserva,fechaDevolucion)).apply();
    }

    public static Solicitante from(SolicitanteId solicitanteId, List<DomainEvent> events){
        var solicitante = new Solicitante(solicitanteId);
        events.forEach(solicitante::applyEvent);
        return solicitante;
    }

    private Solicitante(SolicitanteId entityId) {
        super(entityId);
        subscribe(new SolicitanteEventChange(this));
    }
}
