package co.com.sofka.dddsofka.domain.solicitante.command;

import co.com.sofka.dddsofka.domain.solicitante.values.NombreSolicitante;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.domain.generic.Command;

public class CrearSolicitante implements Command {
    private final SolicitanteId solicitanteId;
    private final NombreSolicitante nombreSolicitante;

    public CrearSolicitante(SolicitanteId solicitanteId, NombreSolicitante nombreSolicitante) {
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
