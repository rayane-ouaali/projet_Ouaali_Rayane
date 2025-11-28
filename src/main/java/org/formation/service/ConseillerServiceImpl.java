package org.formation.service;

import lombok.RequiredArgsConstructor;
import org.formation.entity.Conseiller;
import org.formation.entity.Client;
import org.formation.repository.ConseillerRepository;
import org.formation.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerService {

    private final ConseillerRepository conseillerRepository;
    private final ClientRepository clientRepository;

    @Override
    public Optional<Conseiller> findById(Long id) {
        return conseillerRepository.findById(id);
    }

    @Override
    public Conseiller save(Conseiller conseiller) {
        return conseillerRepository.save(conseiller);
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
