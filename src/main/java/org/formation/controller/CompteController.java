package org.formation.controller;

import lombok.RequiredArgsConstructor;
import org.formation.dto.compte.CompteDto;
import org.formation.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @GetMapping
    List<CompteDto> getAllComptes() {
        return compteService.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<CompteDto> getCompte(@PathVariable Long id) {
        return compteService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("{compteId}/transaction")
    ResponseEntity<CompteDto> effectuerTransaction(@PathVariable Long compteId, @RequestParam Double montant) {
        return compteService.effectuerTransaction(compteId, montant).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
