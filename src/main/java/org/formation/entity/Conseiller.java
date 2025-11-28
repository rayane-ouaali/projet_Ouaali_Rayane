package org.formation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "conseiller")
public class Conseiller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Le nom du conseiller est obligatoire.")
    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Client> clients = new HashSet<>();

    public Conseiller(String nom) {
        this.nom = nom;
    }
}
