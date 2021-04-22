package co.com.sofka.dddsofka.domain.solicitante;

import co.com.sofka.dddsofka.domain.reserva.values.ReservaId;
import co.com.sofka.dddsofka.domain.solicitante.values.FechaFinSancion;
import co.com.sofka.dddsofka.domain.solicitante.values.SancionId;
import co.com.sofka.domain.generic.Entity;

public class Sancion extends Entity<SancionId> {

    protected FechaFinSancion finSancion;
    protected ReservaId origen;

    public Sancion(SancionId sancionId,FechaFinSancion fechaFinSancion,ReservaId reservaId){
        super(sancionId);
        this.finSancion = fechaFinSancion;
        this.origen = reservaId;
    }

}
