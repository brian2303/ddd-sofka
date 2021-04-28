package co.com.sofka.dddsofka.usecase.solicitante;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.dddsofka.domain.solicitante.command.CrearSolicitante;
import co.com.sofka.dddsofka.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.dddsofka.domain.solicitante.values.NombreSolicitante;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.dddsofka.domain.solicitante.values.TipoIdentificacion;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearSolicitanteUseCaseTest {

    @Test
    void crearSolicitante(){
        //Arrange
        var solicitanteId = new SolicitanteId(TipoIdentificacion.CEDULA_CIUDADANIA,"1022345021");
        var nombreSolicitante = new NombreSolicitante("Pepe","Mojica");

        //Act
        var command = new CrearSolicitante(solicitanteId,nombreSolicitante);
        var useCase = new CrearSolicitanteUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        var event = (SolicitanteCreado) events.get(0);

        //Assert
        Assertions.assertEquals("CEDULA_CIUDADANIA-1022345021",event.getSolicitanteId().value());
        Assertions.assertEquals("Pepe Mojica",event.getNombreSolicitante().value());
    }

}