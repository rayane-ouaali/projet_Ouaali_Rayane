package org.formation.service;

import org.formation.dto.compte.CompteDto;

import java.util.List;
import java.util.Optional;

public interface CompteService {
    List<CompteDto> findAll();
    Optional<CompteDto> findById(Long id);
    Optional<CompteDto> effectuerTransaction(Long compteId, Double montant);
}
