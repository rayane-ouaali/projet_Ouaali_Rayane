package org.formation.controller;

import lombok.RequiredArgsConstructor;
import org.formation.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @PostMapping("{compteId}/transaction")
    ResponseEntity<Void> effectuerTransaction(@PathVariable Long compteId, @RequestParam Double montant) {
        compteService.effectuerTransaction(compteId, montant);
        return ResponseEntity.ok().build();
    }
}
