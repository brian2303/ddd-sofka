package co.com.sofka.dddsofka.usecase.recurso;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.dddsofka.domain.recurso.command.CrearRecurso;
import co.com.sofka.dddsofka.domain.recurso.events.RecursoCreado;
import co.com.sofka.dddsofka.domain.recurso.values.CodigoBarras;
import co.com.sofka.dddsofka.domain.recurso.values.NombreRecurso;
import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearRecursoUseCaseTest {

    @Test
    void crearRecurso(){

        var id = RecursoId.of("swder231");
        var codigoBarras = new CodigoBarras("cxsa323r");
        var nombre = new NombreRecurso("VideoBeam");

        var command = new CrearRecurso(id,codigoBarras,nombre);
        var useCase = new CrearRecursoUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        RecursoCreado event = (RecursoCreado) events.get(0);

        Assertions.assertEquals("VideoBeam",event.getNombreRecurso().value());
        Assertions.assertEquals("swder231",event.getRecursoId().value());
        Assertions.assertEquals("cxsa323r",event.getCodigoBarras().value());
    }

}