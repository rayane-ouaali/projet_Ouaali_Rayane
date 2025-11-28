package org.formation.service;

import org.formation.entity.Compte;
import java.util.Optional;

public interface CompteService {
    Optional<Compte> findById(Long id);
    Compte save(Compte compte);
    void effectuerTransaction(Long compteId, Double montant);
}
