package co.com.sofka.dddsofka.domain.solicitante.values;

import co.com.sofka.domain.generic.Identity;

public class SancionId extends Identity {
    private SancionId(String uid) {
        super(uid);
    }

    public static SancionId of(String uid) {
        return new SancionId(uid);
    }
}
