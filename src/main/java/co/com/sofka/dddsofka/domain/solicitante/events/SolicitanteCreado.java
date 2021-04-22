package co.com.sofka.dddsofka.domain.solicitante.events;

import co.com.sofka.dddsofka.domain.solicitante.values.NombreSolicitante;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.domain.generic.DomainEvent;

public class SolicitanteCreado extends DomainEvent {

    private final SolicitanteId solicitanteId;
    private final NombreSolicitante nombreSolicitante;

    public SolicitanteCreado(SolicitanteId solicitanteId, NombreSolicitante nombreSolicitante) {
        super("prestamos.solicitante.solicitantecreado");
        this.solicitanteId = solicitanteId;
        this.nombreSolicitante = nombreSolicitante;
    }

    public SolicitanteId getSolicitanteId() {
        return solicitanteId;
    }

    public NombreSolicitante getNombreSolicitante() {
        return nombreSolicitante;
    }
}
