package co.com.sofka.dddsofka.domain.recurso;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.dddsofka.domain.recurso.events.CategoriaAsignada;
import co.com.sofka.dddsofka.domain.recurso.events.RecursoCreado;
import co.com.sofka.dddsofka.domain.recurso.events.RecursoReservado;
import co.com.sofka.dddsofka.domain.recurso.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Recurso extends AggregateEvent<RecursoId> {

    protected CodigoBarras codigoBarras;
    protected NombreRecurso nombreRecurso;
    protected Categoria categoria;
    protected EstadoRecurso estadoRecurso;

    public Recurso(RecursoId entityId,CodigoBarras codigoBarras,NombreRecurso nombreRecurso){
        super(entityId);
        appendChange(new RecursoCreado(entityId,codigoBarras,nombreRecurso)).apply();
    }

    public void asignarAReserva(){
        if (this.estadoRecurso.equals(EstadoRecurso.RESERVADO)){
            throw new BusinessException(this.entityId.value(),"El recurso seleccionado se encuentra reservado");
        }
        appendChange(new RecursoReservado(this.entityId)).apply();
    }

    public void asignarCategoria(CategoriaId categoriaId,NombreCategoria nombreCategoria,Boolean extraible){
        appendChange(new CategoriaAsignada(categoriaId,nombreCategoria,extraible)).apply();
    }


    public Recurso(RecursoId entityId) {
        super(entityId);
        subscribe(new RecursoEventChange(this));
    }

    public static Recurso from(RecursoId recursoId, List<DomainEvent> events){
        var recurso = new Recurso(recursoId);
        events.forEach(recurso::applyEvent);
        return recurso;
    }


}
