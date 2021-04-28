package co.com.sofka.dddsofka.domain.recurso.command;

import co.com.sofka.dddsofka.domain.recurso.values.CodigoBarras;
import co.com.sofka.dddsofka.domain.recurso.values.NombreRecurso;
import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.domain.generic.Command;

public class CrearRecurso implements Command {

    private final RecursoId recursoId;
    private final CodigoBarras codigoBarras;
    private final NombreRecurso nombreRecurso;

    public CrearRecurso(RecursoId entityId, CodigoBarras codigoBarras, NombreRecurso nombreRecurso){
        this.recursoId = entityId;
        this.codigoBarras = codigoBarras;
        this.nombreRecurso = nombreRecurso;
    }

    public RecursoId getRecursoId() {
        return recursoId;
    }

    public CodigoBarras getCodigoBarras() {
        return codigoBarras;
    }

    public NombreRecurso getNombreRecurso() {
        return nombreRecurso;
    }
}
