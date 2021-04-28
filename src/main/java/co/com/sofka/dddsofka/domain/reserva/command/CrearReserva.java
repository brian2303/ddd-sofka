package co.com.sofka.dddsofka.domain.reserva.command;

import co.com.sofka.dddsofka.domain.reserva.values.FechaDevolucion;
import co.com.sofka.dddsofka.domain.reserva.values.FechaReserva;
import co.com.sofka.dddsofka.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.Command;

public class CrearReserva implements Command {

    private final ReservaId reservaId;
    private final FechaReserva fechaReserva;
    private final FechaDevolucion fechaDevolucion;

    public CrearReserva(ReservaId reservaId, FechaReserva fechaReserva, FechaDevolucion fechaDevolucion) {
        this.reservaId = reservaId;
        this.fechaReserva = fechaReserva;
        this.fechaDevolucion = fechaDevolucion;
    }

    public ReservaId getReservaId() {
        return reservaId;
    }

    public FechaReserva getFechaReserva() {
        return fechaReserva;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }
}
