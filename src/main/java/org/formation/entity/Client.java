package org.formation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du Client est obligatoire.")
    private String nom;
    @NotBlank(message = "Le prénom du Client est obligatoire.")
    private String prenom;
    @NotBlank(message = "L'adresse du Client est obligatoire.")
    private String adresse;
    @NotBlank(message = "Le téléphone du Client est obligatoire.")
    private String telephone;
    @NotBlank(message = "Le code postal du Client est obligatoire.")
    private String codePostal;

    @NotBlank(message = "La ville du Client est obligatoire.")
    private String ville;

    @NotNull(message = "Un conseiller doit être assigné au client.")
    @ManyToOne
    @JoinColumn(name = "idConseiller")
    private Conseiller conseiller;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Compte> comptes = new HashSet<>();

    public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone, Conseiller conseiller) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.codePostal = codePostal;
        this.ville = ville;
        this.conseiller = conseiller;
    }
}
