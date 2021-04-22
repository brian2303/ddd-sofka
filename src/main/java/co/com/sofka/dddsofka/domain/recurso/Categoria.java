package co.com.sofka.dddsofka.domain.recurso;

import co.com.sofka.dddsofka.domain.recurso.values.CategoriaId;
import co.com.sofka.dddsofka.domain.recurso.values.NombreCategoria;
import co.com.sofka.domain.generic.Entity;

public class Categoria extends Entity<CategoriaId> {

    protected NombreCategoria nombreCategoria;
    protected Boolean extraible;

    public Categoria(CategoriaId entityId, NombreCategoria nombreCategoria, Boolean extraible) {
        super(entityId);
        this.nombreCategoria = nombreCategoria;
        this.extraible = extraible;
    }
}
