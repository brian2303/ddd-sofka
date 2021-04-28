package co.com.sofka.dddsofka.usecase.recurso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.dddsofka.domain.recurso.Recurso;
import co.com.sofka.dddsofka.domain.recurso.command.CrearRecurso;

public class CrearRecursoUseCase extends UseCase<RequestCommand<CrearRecurso>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearRecurso> crearRecursoRequestCommand) {

        var command = crearRecursoRequestCommand.getCommand();
        var recurso = new Recurso(command.getRecursoId(),command.getCodigoBarras(),command.getNombreRecurso());

        emit().onResponse(new ResponseEvents(recurso.getUncommittedChanges()));
    }

}
