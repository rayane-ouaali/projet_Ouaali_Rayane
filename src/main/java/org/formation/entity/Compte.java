package org.formation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le client est obligatoire.")
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @Min(value = -1000, message = "Le solde ne peut pas être en deça de -1000 euros.")
    private Double solde;

    @NotNull(message = "Le type de compte est obligatoire.")
    @ManyToOne
    @JoinColumn(name = "idTypeCompte")
    private TypeCompte typeCompte;

    public Compte(Client client, Double solde, TypeCompte typeCompte) {
        this.client = client;
        this.solde = solde;
        this.typeCompte = typeCompte;
    }
}
