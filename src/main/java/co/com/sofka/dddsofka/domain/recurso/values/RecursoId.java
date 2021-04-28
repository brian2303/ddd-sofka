package co.com.sofka.dddsofka.domain.recurso.values;

import co.com.sofka.domain.generic.Identity;

public class RecursoId extends Identity {

    private RecursoId(String uid){
        super(uid);
    }

    public RecursoId() {
    }

    public static RecursoId of(String id){
        return new RecursoId(id);
    }
}
