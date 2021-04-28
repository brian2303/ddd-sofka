package co.com.sofka.dddsofka.domain.solicitante;

import co.com.sofka.dddsofka.domain.solicitante.events.SancionGenerada;
import co.com.sofka.dddsofka.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.dddsofka.domain.solicitante.events.SolicitanteReactivado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

public class SolicitanteEventChange extends EventChange {

    public SolicitanteEventChange(Solicitante solicitante){
        apply((SolicitanteCreado event)->{
            solicitante.nombreCompleto = event.getNombreSolicitante();
            solicitante.activo = Boolean.TRUE;
            solicitante.sanciones = new HashMap<>();
        });

        apply((SancionGenerada event) -> {
            solicitante.activo = Boolean.FALSE;
            solicitante.sanciones.put(
                    event.getSancionId(),
                    new Sancion(
                        event.getSancionId(),
                        event.getFechaFinSancion()
                    )
            );
        });

        apply((SolicitanteReactivado event) ->{
            if (solicitante.activo){
                throw new IllegalArgumentException("El solicitante esta activado");
            }
            solicitante.activo = Boolean.TRUE;
        });
    }
}
