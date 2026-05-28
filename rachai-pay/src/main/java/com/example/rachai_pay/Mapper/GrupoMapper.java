package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.GrupoResponseDto;
import com.example.rachai_pay.domin.Grupo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GrupoMapper {


    @Mapping(target = "criadorId", source = "criador.id")
    @Mapping(target = "nomeGrupo", source = "nomeGrupo")   // ← campo do próprio Grupo
    @Mapping(target = "nome", source = "criador.nome")      // ← nome do criador
    @Mapping(target = "cargo", source = "cargo")
    GrupoResponseDto toDto(Grupo entity);




}
