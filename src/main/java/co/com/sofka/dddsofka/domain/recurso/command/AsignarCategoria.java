package co.com.sofka.dddsofka.domain.recurso.command;

import co.com.sofka.dddsofka.domain.recurso.values.CategoriaId;
import co.com.sofka.dddsofka.domain.recurso.values.NombreCategoria;
import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.domain.generic.Command;

public class AsignarCategoria implements Command {

    private final RecursoId recursoId;
    private final CategoriaId categoriaId;
    private final NombreCategoria nombreCategoria;
    private final Boolean extraible;

    public AsignarCategoria(RecursoId recursoId, CategoriaId categoriaId, NombreCategoria nombreCategoria, Boolean extraible) {
        this.recursoId = recursoId;
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombreCategoria;
        this.extraible = extraible;
    }

    public RecursoId getRecursoId() {
        return recursoId;
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
