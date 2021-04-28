package co.com.sofka.dddsofka.domain.solicitante.events;

import co.com.sofka.domain.generic.DomainEvent;

public class SolicitanteReactivado extends DomainEvent {

    public SolicitanteReactivado(){
        super("prestamos.solicitante.solicitantereactivado");
    }
}
