package org.formation.mapper;

import org.formation.dto.conseiller.ConseillerDto;
import org.formation.entity.Conseiller;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConseillerMapper {
    ConseillerDto toDto(Conseiller conseiller);
    Conseiller toEntity(ConseillerDto dto);
}
