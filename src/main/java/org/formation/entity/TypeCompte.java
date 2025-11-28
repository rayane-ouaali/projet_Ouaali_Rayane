package org.formation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeCompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du type de compte est obligatoire.")
    private String nom;

    @OneToMany(mappedBy = "typeCompte", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Compte> comptes = new HashSet<>();

    public TypeCompte(String nom) {
        this.nom = nom;
    }
}
