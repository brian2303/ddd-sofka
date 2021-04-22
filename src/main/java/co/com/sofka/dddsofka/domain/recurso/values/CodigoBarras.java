package co.com.sofka.dddsofka.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CodigoBarras implements ValueObject<String> {

    private final String lineaCaracteres;

    public CodigoBarras(String lineaCaracteres){
       this.lineaCaracteres = Objects.requireNonNull(lineaCaracteres);
       if (lineaCaracteres.isBlank()){
           throw new IllegalArgumentException("Linea de caracteres no puede ser vacia");
       }
    }

    @Override
    public String value() {
        return lineaCaracteres;
    }
}
