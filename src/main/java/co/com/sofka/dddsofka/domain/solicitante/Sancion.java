package co.com.sofka.dddsofka.domain.solicitante;

import co.com.sofka.dddsofka.domain.reserva.values.ReservaId;
import co.com.sofka.dddsofka.domain.solicitante.values.FechaFinSancion;
import co.com.sofka.dddsofka.domain.solicitante.values.SancionId;
import co.com.sofka.domain.generic.Entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sancion extends Entity<SancionId> {

    protected FechaFinSancion finSancion;
    protected ReservaId origen;

    public Sancion(SancionId sancionId,FechaFinSancion fechaFinSancion){
        super(sancionId);
        this.finSancion = fechaFinSancion;
    }

    public Boolean estaActiva(){
        LocalDate fechaFinSancion = LocalDate.parse(finSancion.value(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return fechaFinSancion.isAfter(LocalDate.now());
    }

}
