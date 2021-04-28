package co.com.sofka.dddsofka.domain.solicitante;

import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.dddsofka.domain.reserva.values.FechaDevolucion;
import co.com.sofka.dddsofka.domain.reserva.values.FechaReserva;
import co.com.sofka.dddsofka.domain.solicitante.events.ReservaGenerada;
import co.com.sofka.dddsofka.domain.solicitante.events.SancionGenerada;
import co.com.sofka.dddsofka.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.dddsofka.domain.solicitante.events.SolicitanteReactivado;
import co.com.sofka.dddsofka.domain.solicitante.values.FechaFinSancion;
import co.com.sofka.dddsofka.domain.solicitante.values.NombreSolicitante;
import co.com.sofka.dddsofka.domain.solicitante.values.SancionId;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.domain.generic.AggregateEvent;
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

    public void generarReserva(SolicitanteId solicitanteId, RecursoId recursoId, FechaReserva fechaReserva, FechaDevolucion fechaDevolucion){
        appendChange(new ReservaGenerada(recursoId,fechaReserva,fechaDevolucion)).apply();
    }

    public void generarSancion(SancionId sancionId, FechaFinSancion fechaFinSancion){
        appendChange(new SancionGenerada(sancionId,fechaFinSancion)).apply();
    }

    public void reactivarSolicitante(){
        appendChange(new SolicitanteReactivado()).apply();
    }

    private Solicitante(SolicitanteId entityId) {
        super(entityId);
        subscribe(new SolicitanteEventChange(this));
    }
}
