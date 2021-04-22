package co.com.sofka.dddsofka.domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaReserva implements ValueObject<String> {
    private final LocalDate fechaReserva;

    public FechaReserva(int dia, int mes, int anio){

        try {
            fechaReserva = LocalDate.of(dia, mes, anio);
            if (fechaReserva.isBefore(LocalDate.now())){
                throw new IllegalArgumentException("La fecha de reserva no puede ser anterior a la fecha actual");
            }
        }catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String value() {
        return fechaReserva.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
