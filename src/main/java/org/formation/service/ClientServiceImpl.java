package org.formation.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.formation.dto.client.ClientCreateDto;
import org.formation.dto.client.ClientDto;
import org.formation.dto.client.ClientUpdateDto;
import org.formation.entity.Client;
import org.formation.entity.Compte;
import org.formation.mapper.ClientMapper;
import org.formation.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto save(ClientCreateDto dto) {
        Client entity = clientMapper.toEntity(dto);
        Client saved = clientRepository.save(entity);
        return clientMapper.toDto(saved);
    }

    @Override
    public Optional<ClientDto> findById(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDto);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();
    }

    @Transactional
    @Override
    public Optional<ClientDto> update(Long id, ClientUpdateDto dto) {
        return clientRepository.findById(id).map(existing -> {
            clientMapper.updateEntity(existing, dto);
            return clientMapper.toDto(existing);
        });
    }

    @Transactional
    @Override
    public void delete(Long id) {
        clientRepository.findById(id).ifPresent(client -> {
            // Désactiver et détacher les comptes associés
            if (client.getComptes() != null) {
                for (Compte c : client.getComptes()) {
                    c.setActif(false);
                    c.setClient(null);
                }
            }

            clientRepository.delete(client);
        });
    }
}
