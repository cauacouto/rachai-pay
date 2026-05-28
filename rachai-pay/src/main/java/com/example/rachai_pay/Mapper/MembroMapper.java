package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.MembroGrupDto;
import com.example.rachai_pay.domin.MembrosGrup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembroMapper {



    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "grupoId", source = "grupo.id")
    MembroGrupDto toDto(MembrosGrup entity);

    MembrosGrup toEntity(MembroGrupDto response);
}
