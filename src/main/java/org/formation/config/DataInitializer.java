package org.formation.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.formation.entity.Conseiller;
import org.formation.entity.TypeCompte;
import org.formation.repository.ConseillerRepository;
import org.formation.repository.TypeCompteRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final ConseillerRepository conseillerRepository;
    private final TypeCompteRepository typeCompteRepository;

    @PostConstruct
    private void initDb() {
        conseillerRepository.saveAll(List.of(
                new Conseiller("Jean Dupont")
        ));

        typeCompteRepository.saveAll(List.of(
                new TypeCompte("Compte Courant"),
                new TypeCompte("Compte Épargne")
        ));
    }
}
