package co.com.sofka.dddsofka.usecase.solicitante;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.dddsofka.domain.reserva.values.FechaDevolucion;
import co.com.sofka.dddsofka.domain.reserva.values.FechaReserva;
import co.com.sofka.dddsofka.domain.solicitante.command.GenerarReserva;
import co.com.sofka.dddsofka.domain.solicitante.events.ReservaGenerada;
import co.com.sofka.dddsofka.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.dddsofka.domain.solicitante.values.NombreSolicitante;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class generarReservaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void generarReserva(){
        SolicitanteId solicitanteId = SolicitanteId.of("CEDULA_CIUDADANIA-102302");
        RecursoId recursoId = new RecursoId();
        FechaReserva fechaReserva = new FechaReserva(29,04,2021);
        FechaDevolucion fechaDevolucion = new FechaDevolucion(29,04,2021);
        var command = new GenerarReserva(solicitanteId,recursoId,fechaReserva,fechaDevolucion);
        var useCase = new generarReservaUseCase();
        useCase.addRepository(repository);
        Mockito.when(repository.getEventsBy(solicitanteId.value())).thenReturn(eventStored());
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("CEDULA_CIUDADANIA-102302")
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(repository).getEventsBy(solicitanteId.value());

        ReservaGenerada event = (ReservaGenerada) events.get(0);

        Assertions.assertEquals(fechaReserva.value(),event.getFechaReserva().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
            new SolicitanteCreado(
                SolicitanteId.of("CEDULA_CIUDADANIA-102302"),new NombreSolicitante("pepe","mojica")
            )
        );
    }
}