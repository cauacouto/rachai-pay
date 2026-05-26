package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.MembroGrupDto;
import com.example.rachai_pay.domin.MembrosGrup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MembroMapper {




    MembroGrupDto toDto(MembrosGrup entity);

    MembrosGrup toEntity(MembroGrupDto response);
}
