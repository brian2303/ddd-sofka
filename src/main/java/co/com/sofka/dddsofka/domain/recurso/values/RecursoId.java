package co.com.sofka.dddsofka.domain.recurso.values;

import co.com.sofka.domain.generic.Identity;

public class RecursoId extends Identity {

    private RecursoId(Integer id){
        super(id.toString());
    }

    public static RecursoId of(Integer id){
        return new RecursoId(id);
    }
}
