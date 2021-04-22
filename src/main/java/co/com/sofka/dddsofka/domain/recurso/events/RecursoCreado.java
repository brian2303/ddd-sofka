package co.com.sofka.dddsofka.domain.recurso.events;

import co.com.sofka.dddsofka.domain.recurso.values.CodigoBarras;
import co.com.sofka.dddsofka.domain.recurso.values.NombreRecurso;
import co.com.sofka.dddsofka.domain.recurso.values.RecursoId;
import co.com.sofka.domain.generic.DomainEvent;

public class RecursoCreado extends DomainEvent {

    private final CodigoBarras codigoBarras;
    private final RecursoId recursoId;
    private final NombreRecurso nombreRecurso;

    public RecursoCreado(RecursoId recursoId, CodigoBarras codigoBarras, NombreRecurso nombreRecurso) {
        super("prestamos.recurso.recursocreado");
        this.nombreRecurso = nombreRecurso;
        this.codigoBarras = codigoBarras;
        this.recursoId = recursoId;
    }

    public NombreRecurso getNombreRecurso() {
        return nombreRecurso;
    }

    public CodigoBarras getCodigoBarras() {
        return codigoBarras;
    }

    public RecursoId getRecursoId() {
        return recursoId;
    }

}
