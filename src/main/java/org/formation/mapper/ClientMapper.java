package org.formation.mapper;

import org.formation.dto.client.ClientCreateDto;
import org.formation.dto.client.ClientDto;
import org.formation.dto.client.ClientUpdateDto;
import org.formation.entity.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    ClientDto toDto(Client client);

    Client toEntity(ClientCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Client entity, ClientUpdateDto dto);
}
