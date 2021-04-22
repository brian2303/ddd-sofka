package co.com.sofka.dddsofka.domain.solicitante.values;

import co.com.sofka.domain.generic.Identity;

public class SolicitanteId extends Identity {
    private String identificacion;
    private TipoIdentificacion tipoIdentificacion;

    public SolicitanteId(TipoIdentificacion tipoIdentificacion,String identificacion){
        super(tipoIdentificacion + "-" +  identificacion);
    }
}
