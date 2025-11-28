package org.formation.service;

import org.formation.entity.Conseiller;
import org.formation.entity.Client;
import java.util.Optional;

public interface ConseillerService {
    Optional<Conseiller> findById(Long id);
    Conseiller save(Conseiller conseiller);
    void ajouterClientAConseiller(Long conseillerID, Long clientId);
}
