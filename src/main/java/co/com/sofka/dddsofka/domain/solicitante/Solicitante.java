package co.com.sofka.dddsofka.domain.solicitante;

import co.com.sofka.dddsofka.domain.solicitante.events.SolicitanteCreado;
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


    private Solicitante(SolicitanteId entityId) {
        super(entityId);
        subscribe(new SolicitanteEventChange(this));
    }
}
