package org.formation.dto.compte;

public record CompteDto(
        Long id,
        Long idClient,
        Double solde,
        boolean actif,
        Long idTypeCompte
) {}
