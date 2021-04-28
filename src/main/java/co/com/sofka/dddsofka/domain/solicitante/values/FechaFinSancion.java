package co.com.sofka.dddsofka.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaFinSancion implements ValueObject<String> {

    private final LocalDate fechaFinSancion;
    private final String format;

    public FechaFinSancion(int dia,int mes, int anio){
        try {
            fechaFinSancion = LocalDate.of(anio,mes,dia);
            if (fechaFinSancion.isBefore(LocalDate.now())){
                throw new IllegalArgumentException("La fecha de sancion no debe ser anterior a la fecha actual");
            }
        }catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        format = fechaFinSancion.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {
        return format;
    }
}
