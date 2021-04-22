package co.com.sofka.dddsofka.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaFinSancion implements ValueObject<LocalDate> {

    LocalDate fechaFinSancion;

    public FechaFinSancion(LocalDate fechaFinSancion){
        // TODO: 22/04/21 Validar formato de fecha
        this.fechaFinSancion = Objects.requireNonNull(fechaFinSancion);
    }

    @Override
    public LocalDate value() {
        return fechaFinSancion;
    }
}
