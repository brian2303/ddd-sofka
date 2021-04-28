package co.com.sofka.dddsofka.domain.recurso;

import co.com.sofka.dddsofka.domain.recurso.events.CategoriaAsignada;
import co.com.sofka.dddsofka.domain.recurso.events.RecursoCreado;
import co.com.sofka.dddsofka.domain.recurso.events.RecursoReservado;
import co.com.sofka.dddsofka.domain.recurso.values.EstadoRecurso;
import co.com.sofka.domain.generic.EventChange;

public class RecursoEventChange extends EventChange {

    public RecursoEventChange(Recurso recurso) {
        apply((RecursoCreado event) ->{
            recurso.estadoRecurso = EstadoRecurso.DISPONIBLE;
            recurso.nombreRecurso = event.getNombreRecurso();
            recurso.codigoBarras = event.getCodigoBarras();
        });

        apply((RecursoReservado event) ->{
            recurso.estadoRecurso = EstadoRecurso.RESERVADO;
        });

        apply((CategoriaAsignada event) ->{
            recurso.categoria = new Categoria(
                    event.getCategoriaId(),
                    event.getNombreCategoria(),
                    event.getExtraible()
            );
        });

    }
}
