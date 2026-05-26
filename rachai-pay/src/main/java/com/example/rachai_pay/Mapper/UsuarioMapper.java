package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.UsuarioRequestDto;
import com.example.rachai_pay.Dtos.UsuarioResponseDto;
import com.example.rachai_pay.domin.Grupo;
import com.example.rachai_pay.domin.Usuarios;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

   UsuarioResponseDto toDto(Usuarios entity);

    Usuarios toEntity(UsuarioRequestDto request);
}
