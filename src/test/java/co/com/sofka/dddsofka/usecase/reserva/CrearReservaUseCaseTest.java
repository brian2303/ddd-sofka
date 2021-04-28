package co.com.sofka.dddsofka.usecase.reserva;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.dddsofka.domain.reserva.events.ReservaCreada;
import co.com.sofka.dddsofka.domain.reserva.values.FechaDevolucion;
import co.com.sofka.dddsofka.domain.reserva.values.FechaReserva;
import co.com.sofka.dddsofka.domain.solicitante.events.ReservaGenerada;
import co.com.sofka.dddsofka.usecase.model.Solicitante;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CrearReservaUseCaseTest {

    @Mock
    SolicitanteService solicitanteService;

    @Test
    void crearReserva(){
        //Arrange
        Solicitante solicitante = new Solicitante();
        solicitante.setActivo(true);
        solicitante.setNombre("brian");

        ServiceBuilder serviceBuilder = new ServiceBuilder();
        serviceBuilder.addService(solicitanteService);

        Mockito.when(solicitanteService.findById(Mockito.any())).thenReturn(solicitante);

        var fechaReserva = new FechaReserva(30,4,2021);
        var fechaDevolucion = new FechaDevolucion(30,04,2021);
        var event = new ReservaGenerada(new RecursoId(),fechaReserva,fechaDevolucion);
        event.setAggregateRootId("xxx");
        var useCase = new CrearReservaUseCase();

        //Act
        useCase.addServiceBuilder(serviceBuilder);

        List<DomainEvent> events = UseCaseHandler.getInstance()
            .syncExecutor(useCase,new TriggeredEvent<>(event)).orElseThrow().getDomainEvents();

        var reservaCreada = (ReservaCreada) events.get(0);


        Mockito.verify(solicitanteService).findById(Mockito.any());
        Assertions.assertEquals("30-04-2021",reservaCreada.getFechaReserva().value());
        Assertions.assertEquals("30-04-2021",reservaCreada.getFechaDevolucion().value());

    }
}