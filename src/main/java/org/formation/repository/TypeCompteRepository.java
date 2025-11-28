package org.formation.repository;

import org.formation.entity.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCompteRepository extends JpaRepository<TypeCompte, Long> {
}
