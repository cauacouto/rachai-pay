package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.UsuarioRequestDto;
import com.example.rachai_pay.Dtos.UsuarioResponseDto;
import com.example.rachai_pay.domin.Usuarios;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-26T09:37:09-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponseDto toDto(Usuarios entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String nome = null;
        String email = null;

        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto( id, nome, email );

        return usuarioResponseDto;
    }

    @Override
    public Usuarios toEntity(UsuarioRequestDto request) {
        if ( request == null ) {
            return null;
        }

        Usuarios usuarios = new Usuarios();

        usuarios.setNome( request.nome() );
        usuarios.setEmail( request.email() );
        usuarios.setSenha( request.senha() );

        return usuarios;
    }
}
