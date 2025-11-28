package org.formation.service;

import lombok.RequiredArgsConstructor;
import org.formation.dto.compte.CompteDto;
import org.formation.entity.Compte;
import org.formation.mapper.CompteMapper;
import org.formation.repository.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;

    @Override
    public List<CompteDto> findAll() {
        return compteRepository.findAll().stream()
                .map(compteMapper::toDto)
                .toList();
    }

    @Override
    public Optional<CompteDto> findById(Long id) {
        return compteRepository.findById(id).map(compteMapper::toDto);
    }

    @Transactional
    @Override
    public Optional<CompteDto> effectuerTransaction(Long compteId, Double montant) {
        return compteRepository.findById(compteId).map(compte -> {
            Double nouveauSolde = compte.getSolde() + montant;
            
            if (nouveauSolde < -1000) {
                throw new IllegalArgumentException("Le solde ne peut pas être en deça de -1000 euros.");
            }
            
            compte.setSolde(nouveauSolde);
            compteRepository.save(compte);
            return compteMapper.toDto(compte);
        });
    }
}
