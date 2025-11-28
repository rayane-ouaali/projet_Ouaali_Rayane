package org.formation.dto.client;

import jakarta.validation.constraints.NotBlank;

public record ClientUpdateDto(
        Long id,
        @NotBlank(message = "Le nom du client est obligatoire.")
        String nom,
        @NotBlank(message = "Le prénom du client est obligatoire.")
        String prenom,
        @NotBlank(message = "L'adresse du client est obligatoire.")
        String adresse,
        @NotBlank(message = "Le code postal est obligatoire.")
        String codePostal,
        @NotBlank(message = "La ville est obligatoire.")
        String ville,
        @NotBlank(message = "Le téléphone est obligatoire.")
        String telephone,
        Long idConseiller
) {}
