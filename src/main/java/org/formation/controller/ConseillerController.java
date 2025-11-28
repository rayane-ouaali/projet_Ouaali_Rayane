package org.formation.controller;

import lombok.RequiredArgsConstructor;
import org.formation.service.ConseillerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("conseillers")
@RequiredArgsConstructor
public class ConseillerController {

    private final ConseillerService conseillerService;

    @PostMapping("{conseillerID}/clients/{clientId}")
    ResponseEntity<Void> ajouterClientAConseiller(@PathVariable Long conseillerID, @PathVariable Long clientId) {
        conseillerService.ajouterClientAConseiller(conseillerID, clientId);
        return ResponseEntity.ok().build();
    }
}
