package org.formation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "code_postal", length = 10)
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "telephone", length = 15)
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "idConseiller")
    private Conseiller conseiller;

    @Setter
    @Getter
    private HashSet<Compte> comptes = new HashSet<>();
}
