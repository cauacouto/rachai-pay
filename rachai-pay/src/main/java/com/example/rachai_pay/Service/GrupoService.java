package com.example.rachai_pay.Service;

import com.example.rachai_pay.Dtos.GrupoRequestDto;
import com.example.rachai_pay.Dtos.GrupoResponseDto;
import com.example.rachai_pay.Dtos.MembroGrupDto;
import com.example.rachai_pay.Enum.Cargo;
import com.example.rachai_pay.Mapper.GrupoMapper;
import com.example.rachai_pay.Mapper.MembroMapper;
import com.example.rachai_pay.Repository.GrupoRepository;
import com.example.rachai_pay.Repository.MembrosGroupRepository;
import com.example.rachai_pay.Repository.UsuarioRepository;
import com.example.rachai_pay.domin.Grupo;
import com.example.rachai_pay.domin.MembrosGrup;
import com.example.rachai_pay.domin.Usuarios;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoMapper grupoMapper;
    private final GrupoRepository grupoRepository;
    private  final UsuarioRepository usuarioRepository;
    private final MembrosGroupRepository membrosGroupRepository;
    private MembroMapper membroMapper;


    @Transactional
    public GrupoResponseDto criarGrupo(GrupoRequestDto dto,UUID id){
        Usuarios usuarios = usuarioRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id não pode ser null"));
        Grupo grupo =  grupoMapper.toEntity(dto);
        var salvar = grupoRepository.save(grupo);

        MembrosGrup membro = new MembrosGrup();
        membro.setGrupo(grupo);
        membro.setUsuario(usuarios);
        membro.setCargo(Cargo.ADMIN);
        return grupoMapper.toDto(salvar);
    }


    public MembroGrupDto adicionarMembros(Long grupoId, UUID usuarioId){
        Usuarios usuarios = usuarioRepository.findById(usuarioId).orElseThrow(()
                -> new IllegalArgumentException("usuario não encontrado"));

        Grupo  grupo = grupoRepository.findById(grupoId).orElseThrow(()
                -> new IllegalArgumentException("grupo não encontrado"));


        MembrosGrup membrosGrup = new MembrosGrup();

        membrosGrup.setGrupo(grupo);
        membrosGrup.setUsuario(usuarios);
        membrosGrup.setCargo(Cargo.MEMBRO);
        var salva = membrosGroupRepository.save(membrosGrup);
        return membroMapper.toDto(salva);



    }

    public
}
