package co.com.sofka.dddsofka.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreSolicitante implements ValueObject<String> {
    private final String nombre;
    private final String apellido;

    public NombreSolicitante(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        if (nombre.isBlank() || apellido.isBlank()){
            throw new IllegalArgumentException("Nombres o apellidos no pueden estar en blanco");
        }
    }

    @Override
    public String value() {
        return nombre + " " + apellido;
    }
}
