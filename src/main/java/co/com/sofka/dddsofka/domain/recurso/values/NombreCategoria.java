package co.com.sofka.dddsofka.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCategoria implements ValueObject<String> {

    private final String nombre;

    public NombreCategoria(String nombre){
        this.nombre = Objects.requireNonNull(nombre);
        if(nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede esta vacio");
        }
    }

    @Override
    public String value() {
        return nombre;
    }
}
