package org.formation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.dto.client.ClientCreateDto;
import org.formation.dto.client.ClientDto;
import org.formation.dto.client.ClientUpdateDto;
import org.formation.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    ClientDto save(@RequestBody @Valid ClientCreateDto clientCreateDto) {
        return clientService.save(clientCreateDto);
    }

    @GetMapping("{id}")
    ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        return clientService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody @Valid ClientUpdateDto clientUpdateDto) {
        return clientService.update(id, clientUpdateDto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
