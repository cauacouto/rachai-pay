package com.example.rachai_pay.Service;

import com.example.rachai_pay.Dtos.UsuarioRequestDto;
import com.example.rachai_pay.Dtos.UsuarioResponseDto;
import com.example.rachai_pay.Mapper.UsuarioMapper;
import com.example.rachai_pay.Repository.UsuarioRepository;
import com.example.rachai_pay.domin.Usuarios;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioSevice {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioResponseDto criarUsuario(UsuarioRequestDto request){
        Usuarios usuarios = usuarioMapper.toEntity(request);
        var salvar = usuarioRepository.save(usuarios);
        return usuarioMapper.toDto(salvar);
    }
}
