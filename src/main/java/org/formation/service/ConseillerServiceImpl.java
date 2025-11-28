package org.formation.service;

import lombok.RequiredArgsConstructor;
import org.formation.dto.conseiller.ConseillerDto;
import org.formation.entity.Client;
import org.formation.entity.Conseiller;
import org.formation.mapper.ConseillerMapper;
import org.formation.repository.ClientRepository;
import org.formation.repository.ConseillerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerService {

    private final ConseillerRepository conseillerRepository;
    private final ClientRepository clientRepository;
    private final ConseillerMapper conseillerMapper;

    @Override
    public List<ConseillerDto> findAll() {
        return conseillerRepository.findAll().stream()
                .map(conseillerMapper::toDto)
                .toList();
    }

    @Override
    public Optional<ConseillerDto> findById(Long id) {
        return conseillerRepository.findById(id).map(conseillerMapper::toDto);
    }

    @Transactional
    @Override
    public void ajouterClientAConseiller(Long conseillerID, Long clientId) {
        Optional<Conseiller> conseiller = conseillerRepository.findById(conseillerID);
        Optional<Client> client = clientRepository.findById(clientId);

        if (conseiller.isPresent() && client.isPresent()) {
            Client c = client.get();
            Conseiller cons = conseiller.get();
            c.setConseiller(cons);
            cons.getClients().add(c);
            clientRepository.save(c);
            conseillerRepository.save(cons);
        } else {
            throw new IllegalArgumentException("Conseiller ou Client non trouvé.");
        }
    }
}
