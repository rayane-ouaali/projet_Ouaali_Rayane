package org.formation.service;

import org.formation.dto.conseiller.ConseillerDto;

import java.util.List;
import java.util.Optional;

public interface ConseillerService {
    List<ConseillerDto> findAll();
    Optional<ConseillerDto> findById(Long id);
    void ajouterClientAConseiller(Long conseillerID, Long clientId);
}
