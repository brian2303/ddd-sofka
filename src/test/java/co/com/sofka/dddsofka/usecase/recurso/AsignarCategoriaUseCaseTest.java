package co.com.sofka.dddsofka.usecase.recurso;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.dddsofka.domain.recurso.command.AsignarCategoria;
import co.com.sofka.dddsofka.domain.recurso.events.CategoriaAsignada;
import co.com.sofka.dddsofka.domain.recurso.values.CategoriaId;
import co.com.sofka.dddsofka.domain.recurso.values.NombreCategoria;
import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AsignarCategoriaUseCaseTest {

    @Test
    void asignarCategoria(){
        //Arrange
        var recursoId = RecursoId.of("swder231");
        var categoriaId = new CategoriaId();
        var nombreCategoria = new NombreCategoria("equipos");
        var extraible = Boolean.FALSE;

        //Act
        var command = new AsignarCategoria(recursoId,categoriaId,nombreCategoria,extraible);
        var useCase = new AsignarCategoriaUseCase();
        List<DomainEvent> events = UseCaseHandler.getInstance()
            .syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        CategoriaAsignada event = (CategoriaAsignada) events.get(0);
        //Assert
        Assertions.assertEquals("equipos",event.getNombreCategoria().value());
    }

}