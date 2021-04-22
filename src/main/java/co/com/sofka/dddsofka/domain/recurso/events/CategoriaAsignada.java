package co.com.sofka.dddsofka.domain.recurso.events;

import co.com.sofka.dddsofka.domain.recurso.values.CategoriaId;
import co.com.sofka.dddsofka.domain.recurso.values.NombreCategoria;
import co.com.sofka.dddsofka.domain.recurso.values.NombreRecurso;
import co.com.sofka.domain.generic.DomainEvent;

public class CategoriaAsignada extends DomainEvent {

    private final CategoriaId categoriaId;
    private final NombreCategoria nombreCategoria;
    private final Boolean extraible;


    public CategoriaAsignada(CategoriaId categoriaId, NombreCategoria nombreCategoria, Boolean extraible) {
        super("prestamos.recurso.categoriaasignada");
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombreCategoria;
        this.extraible = extraible;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public NombreCategoria getNombreCategoria() {
        return nombreCategoria;
    }

    public Boolean getExtraible() {
        return extraible;
    }
}
