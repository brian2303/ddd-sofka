package co.com.sofka.dddsofka.usecase.solicitante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.dddsofka.domain.solicitante.Solicitante;
import co.com.sofka.dddsofka.domain.solicitante.command.GenerarReserva;

public class generarReservaUseCase extends UseCase<RequestCommand<GenerarReserva>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<GenerarReserva> generarReservaRequestCommand) {
        var command = generarReservaRequestCommand.getCommand();
        var solicitante = Solicitante.from(command.getSolicitanteId(),retrieveEvents());
        solicitante.generarReserva(
                command.getSolicitanteId(),
                command.getRecursoId(),
                command.getFechaReserva(),
                command.getFechaDevolucion()
        );
        emit().onResponse(new ResponseEvents(solicitante.getUncommittedChanges()));
    }
}
