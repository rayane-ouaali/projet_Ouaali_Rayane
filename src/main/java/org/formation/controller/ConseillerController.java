package org.formation.controller;

import lombok.RequiredArgsConstructor;
import org.formation.dto.conseiller.ConseillerDto;
import org.formation.service.ConseillerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conseillers")
@RequiredArgsConstructor
public class ConseillerController {

    private final ConseillerService conseillerService;

    @GetMapping
    List<ConseillerDto> getAllConseillers() {
        return conseillerService.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ConseillerDto> getConseiller(@PathVariable Long id) {
        return conseillerService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("{conseillerID}/clients/{clientId}")
    ResponseEntity<Void> ajouterClientAConseiller(@PathVariable Long conseillerID, @PathVariable Long clientId) {
        conseillerService.ajouterClientAConseiller(conseillerID, clientId);
        return ResponseEntity.ok().build();
    }
}
