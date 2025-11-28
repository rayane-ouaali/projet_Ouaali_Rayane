package org.formation.dto.client;

public record ClientUpdateDto(
        String nom,
        String prenom,
        String adresse,
        String codePostal,
        String ville,
        String telephone,
        Long idConseiller
) {}
