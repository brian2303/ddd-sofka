package co.com.sofka.dddsofka.domain.solicitante.values;

import co.com.sofka.domain.generic.Identity;

public class SolicitanteId extends Identity {
    private String identificacion;
    private TipoIdentificacion tipoIdentificacion;

    public SolicitanteId(TipoIdentificacion tipoIdentificacion,String identificacion){
        super(tipoIdentificacion + "-" +  identificacion);
    }

    public SolicitanteId() {}

    private SolicitanteId(String id){
        super(id);
    }

    public static SolicitanteId of(String id){
        return new SolicitanteId(id);
    }

}
