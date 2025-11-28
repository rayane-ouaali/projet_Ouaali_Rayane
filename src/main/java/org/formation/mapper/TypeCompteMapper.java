package org.formation.mapper;

import org.formation.dto.typecompte.TypeCompteDto;
import org.formation.entity.TypeCompte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeCompteMapper {
    TypeCompteDto toDto(TypeCompte typeCompte);
    TypeCompte toEntity(TypeCompteDto dto);
}
