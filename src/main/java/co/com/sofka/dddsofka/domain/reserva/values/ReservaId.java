package co.com.sofka.dddsofka.domain.reserva.values;

import co.com.sofka.domain.generic.Identity;

public class ReservaId extends Identity {

    private ReservaId(String uuid) {
        super(uuid);
    }

    public ReservaId() {}

    public static ReservaId of(Integer id){
        return new ReservaId(id.toString());
    }
}
