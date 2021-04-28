package co.com.sofka.dddsofka.usecase.solicitante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.dddsofka.domain.solicitante.Solicitante;
import co.com.sofka.dddsofka.domain.solicitante.command.CrearSolicitante;

public class CrearSolicitanteUseCase extends UseCase<RequestCommand<CrearSolicitante>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearSolicitante> crearSolicitanteRequestCommand) {
        var command = crearSolicitanteRequestCommand.getCommand();
        var solicitante = new Solicitante(command.getSolicitanteId(),command.getNombreSolicitante());
        emit().onResponse(new ResponseEvents(solicitante.getUncommittedChanges()));
    }
}
