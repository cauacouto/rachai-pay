package com.example.rachai_pay.Service;

import com.example.rachai_pay.Dtos.*;
import com.example.rachai_pay.Enum.Cargo;
import com.example.rachai_pay.Mapper.DespesaMapper;
import com.example.rachai_pay.Mapper.GrupoMapper;
import com.example.rachai_pay.Mapper.MembroMapper;
import com.example.rachai_pay.Repository.DespesaRepository;
import com.example.rachai_pay.Repository.GrupoRepository;
import com.example.rachai_pay.Repository.MembrosGroupRepository;
import com.example.rachai_pay.Repository.UsuarioRepository;
import com.example.rachai_pay.domin.Despesa;
import com.example.rachai_pay.domin.Grupo;
import com.example.rachai_pay.domin.MembrosGrup;
import com.example.rachai_pay.domin.Usuarios;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoMapper grupoMapper;
    private final GrupoRepository grupoRepository;
    private  final UsuarioRepository usuarioRepository;
    private final MembrosGroupRepository membrosGroupRepository;
    private  final MembroMapper membroMapper;
    private  final DespesaRepository despesaRepository;
    private  final DespesaMapper despesaMapper;


    @Transactional
    public GrupoResponseDto criarGrupo(GrupoRequestDto dto,UUID id){
        Usuarios usuarios = usuarioRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id não pode ser null"));
        Grupo grupo =  new Grupo();
        grupo.setNomeGrupo(dto.nomeGrupo());
        grupo.setCriador(usuarios);
        var salvar = grupoRepository.save(grupo);
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

        grupo.getMembros().add(membrosGrup);

        var salva = membrosGroupRepository.save(membrosGrup);
        return membroMapper.toDto(salva);



    }

    public DespesaResponseDto criarDepesa (DespesaDto dto, Long id){

        Grupo grupo = grupoRepository.findById(id).orElseThrow(()-> new RuntimeException("grupo não encontrado"));

        if (grupo.getMembros() == null || grupo.getMembros().isEmpty()){
            throw  new RuntimeException("Não é possivel criar despesa em um grupo sem membros");
        }

        Despesa despesa = new Despesa();
        despesa.setNomeDespesa(dto.nomeDespesa());
        despesa.setValor(dto.valor());
        despesa.setQuantidadeMmebros(dto.quantidadeMembros());
        despesa.setGrupo(grupo);
        Despesa despesaSalva = despesaRepository.save(despesa);
        return despesaMapper.toDto(despesaSalva);

    }

    public List<MembroGrupDto> listar(Long idGrupo){
       Grupo grupo =  grupoRepository.findById(idGrupo).orElseThrow(()-> new RuntimeException("grupo nao encontrado"));
        return grupo.getMembros().stream()
                .map(membroMapper::toDto)
                .collect(Collectors.toList());


    }

}
