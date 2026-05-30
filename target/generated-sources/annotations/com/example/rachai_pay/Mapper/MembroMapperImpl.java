package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.MembroGrupDto;
import com.example.rachai_pay.Enum.Cargo;
import com.example.rachai_pay.domin.Grupo;
import com.example.rachai_pay.domin.MembrosGrup;
import com.example.rachai_pay.domin.Usuarios;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T22:27:19-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Ubuntu)"
)
@Component
public class MembroMapperImpl implements MembroMapper {

    @Override
    public MembroGrupDto toDto(MembrosGrup entity) {
        if ( entity == null ) {
            return null;
        }

        UUID usuarioId = null;
        Long grupoId = null;
        Cargo cargo = null;
        LocalDateTime dataEntrada = null;

        usuarioId = entityUsuarioId( entity );
        Integer id1 = entityGrupoId( entity );
        if ( id1 != null ) {
            grupoId = id1.longValue();
        }
        cargo = entity.getCargo();
        dataEntrada = entity.getDataEntrada();

        String nomeGrupo = null;

        MembroGrupDto membroGrupDto = new MembroGrupDto( usuarioId, grupoId, nomeGrupo, cargo, dataEntrada );

        return membroGrupDto;
    }

    @Override
    public MembrosGrup toEntity(MembroGrupDto response) {
        if ( response == null ) {
            return null;
        }

        MembrosGrup membrosGrup = new MembrosGrup();

        membrosGrup.setDataEntrada( response.dataEntrada() );
        membrosGrup.setCargo( response.cargo() );

        return membrosGrup;
    }

    private UUID entityUsuarioId(MembrosGrup membrosGrup) {
        if ( membrosGrup == null ) {
            return null;
        }
        Usuarios usuario = membrosGrup.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        UUID id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer entityGrupoId(MembrosGrup membrosGrup) {
        if ( membrosGrup == null ) {
            return null;
        }
        Grupo grupo = membrosGrup.getGrupo();
        if ( grupo == null ) {
            return null;
        }
        Integer id = grupo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
