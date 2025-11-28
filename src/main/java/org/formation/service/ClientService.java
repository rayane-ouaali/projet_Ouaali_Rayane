package org.formation.service;

import org.formation.dto.client.ClientCreateDto;
import org.formation.dto.client.ClientDto;
import org.formation.dto.client.ClientUpdateDto;

import java.util.Optional;

public interface ClientService {

    ClientDto save(ClientCreateDto client);
    Optional<ClientDto> findById(Long id);
    Optional<ClientDto> update(Long id, ClientUpdateDto client);
    void delete(Long id);
}
