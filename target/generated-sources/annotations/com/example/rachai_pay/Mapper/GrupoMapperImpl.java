package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.GrupoResponseDto;
import com.example.rachai_pay.Enum.Cargo;
import com.example.rachai_pay.domin.Grupo;
import com.example.rachai_pay.domin.Usuarios;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-27T22:25:28-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Ubuntu)"
)
@Component
public class GrupoMapperImpl implements GrupoMapper {

    @Override
    public GrupoResponseDto toDto(Grupo entity) {
        if ( entity == null ) {
            return null;
        }

        UUID criadorId = null;
        String nomeGrupo = null;
        String nome = null;
        Cargo cargo = null;
        Integer id = null;
        LocalDateTime criadoEm = null;

        criadorId = entityCriadorId( entity );
        nomeGrupo = entity.getNomeGrupo();
        nome = entityCriadorNome( entity );
        cargo = entity.getCargo();
        id = entity.getId();
        criadoEm = entity.getCriadoEm();

        GrupoResponseDto grupoResponseDto = new GrupoResponseDto( id, nomeGrupo, criadoEm, criadorId, nome, cargo );

        return grupoResponseDto;
    }

    private UUID entityCriadorId(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }
        Usuarios criador = grupo.getCriador();
        if ( criador == null ) {
            return null;
        }
        UUID id = criador.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityCriadorNome(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }
        Usuarios criador = grupo.getCriador();
        if ( criador == null ) {
            return null;
        }
        String nome = criador.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }
}
