package co.com.sofka.dddsofka.usecase.reserva;

import co.com.sofka.dddsofka.domain.solicitante.values.SolicitanteId;
import co.com.sofka.dddsofka.usecase.model.Solicitante;

public interface SolicitanteService {
    Solicitante findById(SolicitanteId id);
}
