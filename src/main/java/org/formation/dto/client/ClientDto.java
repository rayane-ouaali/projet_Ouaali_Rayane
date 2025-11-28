package org.formation.dto.client;

public record ClientDto(
        Long id,
        String prenom,
        String nom,
        String adresse,
        String codePostal,
        String ville,
        String telephone,
        Long employeId
) {}
