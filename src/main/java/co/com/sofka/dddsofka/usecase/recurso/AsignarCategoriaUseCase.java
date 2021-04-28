package co.com.sofka.dddsofka.usecase.recurso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.dddsofka.domain.recurso.Recurso;
import co.com.sofka.dddsofka.domain.recurso.command.AsignarCategoria;

public class AsignarCategoriaUseCase extends UseCase<RequestCommand<AsignarCategoria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarCategoria> asignarCategoriaRequestCommand) {
        var command = asignarCategoriaRequestCommand.getCommand();
        var recurso = new Recurso(command.getRecursoId());
        recurso.asignarCategoria(command.getCategoriaId(),command.getNombreCategoria(),command.getExtraible());
        emit().onResponse(new ResponseEvents(recurso.getUncommittedChanges()));
    }
}
