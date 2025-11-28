package org.formation.mapper;

import org.formation.dto.compte.CompteDto;
import org.formation.entity.Compte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompteMapper {
    
    @Mapping(target = "idClient", source = "client.id")
    @Mapping(target = "idTypeCompte", source = "typeCompte.id")
    CompteDto toDto(Compte compte);
    
    Compte toEntity(CompteDto dto);
}
