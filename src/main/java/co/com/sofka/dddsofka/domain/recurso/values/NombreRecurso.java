package co.com.sofka.dddsofka.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreRecurso implements ValueObject<String> {

    private final String nombreRecurso;

    public NombreRecurso(String nombreRecurso) {
        this.nombreRecurso = Objects.requireNonNull(nombreRecurso);
        if (nombreRecurso.isBlank()){
            throw new IllegalArgumentException("El nombre del recurso no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return nombreRecurso;
    }
}
