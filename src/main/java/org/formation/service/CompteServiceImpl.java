package org.formation.service;

import lombok.RequiredArgsConstructor;
import org.formation.entity.Compte;
import org.formation.repository.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;

    @Override
    public Optional<Compte> findById(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

    @Transactional
    @Override
    public void effectuerTransaction(Long compteId, Double montant) {
        Optional<Compte> compte = compteRepository.findById(compteId);
        if (compte.isPresent()) {
            Compte c = compte.get();
            Double nouveauSolde = c.getSolde() + montant;
            if (nouveauSolde >= -1000) {
                c.setSolde(nouveauSolde);
                compteRepository.save(c);
            } else {
                throw new IllegalArgumentException("Le solde ne peut pas être en deça de -1000 euros.");
            }
        } else {
            throw new IllegalArgumentException("Compte non trouvé.");
        }
    }
}
