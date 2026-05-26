package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.GrupoRequestDto;
import com.example.rachai_pay.Dtos.GrupoResponseDto;
import com.example.rachai_pay.domin.Grupo;
import com.example.rachai_pay.domin.Usuarios;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-26T10:35:29-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Oracle Corporation)"
)
@Component
public class GrupoMapperImpl implements GrupoMapper {

    @Override
    public GrupoResponseDto toDto(Grupo entity) {
        if ( entity == null ) {
            return null;
        }

        UUID criadorId = null;
        String nome = null;
        Integer id = null;
        String nomeGrupo = null;
        LocalDateTime criadoEm = null;

        criadorId = entityCriadorId( entity );
        nome = entityCriadorNome( entity );
        id = entity.getId();
        nomeGrupo = entity.getNomeGrupo();
        criadoEm = entity.getCriadoEm();

        GrupoResponseDto grupoResponseDto = new GrupoResponseDto( id, nomeGrupo, criadoEm, criadorId, nome );

        return grupoResponseDto;
    }

    @Override
    public Grupo toEntity(GrupoRequestDto response) {
        if ( response == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        grupo.setNomeGrupo( response.nomeGrupo() );

        return grupo;
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
