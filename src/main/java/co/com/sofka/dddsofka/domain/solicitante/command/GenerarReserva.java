package co.com.sofka.dddsofka.domain.solicitante.command;

import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.dddsofka.domain.reserva.values.FechaDevolucion;
import co.com.sofka.dddsofka.domain.reserva.values.FechaReserva;
import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.domain.generic.Command;

public class GenerarReserva implements Command {
    private final SolicitanteId solicitanteId;
    private final RecursoId recursoId;
    private final FechaReserva fechaReserva;
    private final FechaDevolucion fechaDevolucion;

    public GenerarReserva(SolicitanteId solicitanteId, RecursoId recursoId, FechaReserva fechaReserva, FechaDevolucion fechaDevolucion) {
        this.solicitanteId = solicitanteId;
        this.recursoId = recursoId;
        this.fechaReserva = fechaReserva;
        this.fechaDevolucion = fechaDevolucion;
    }

    public SolicitanteId getSolicitanteId() {
        return solicitanteId;
    }

    public RecursoId getRecursoId() {
        return recursoId;
    }

    public FechaReserva getFechaReserva() {
        return fechaReserva;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }
}
