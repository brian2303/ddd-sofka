package co.com.sofka.dddsofka.domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaDevolucion implements ValueObject<String>{
    private final LocalDate fechaDevolucion;

    public FechaDevolucion(int dia, int mes, int anio){

        try {
            fechaDevolucion = LocalDate.of(anio,mes,dia);
            if (fechaDevolucion.isBefore(LocalDate.now())){
                throw new IllegalArgumentException("La fecha de devolucion no puede ser anterior a la fecha actual");
            }
        }catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String value() {
        return fechaDevolucion.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
