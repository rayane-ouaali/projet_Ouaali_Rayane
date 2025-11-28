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
public class Conseiller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du conseiller est obligatoire.")
    private String nom;

    @OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Client> clients = new HashSet<>();

    public Conseiller(String nom) {
        this.nom = nom;
    }
}
