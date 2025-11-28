package org.formation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Le client est obligatoire.")
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @Min(value = -1000, message = "Le solde ne peut pas être en deça de -1000 euros.")
    @Column(name = "solde", nullable = false)
    private Double solde;

    @Column(name = "actif")
    @Setter
    private boolean actif = true;

    @NotNull(message = "Le type de compte est obligatoire.")
    @ManyToOne
    @JoinColumn(name = "idTypeCompte")
    @Getter
    @Setter
    private TypeCompte typeCompte;
}
