package com.example.rachai_pay.Controller;

import com.example.rachai_pay.Dtos.UsuarioRequestDto;
import com.example.rachai_pay.Dtos.UsuarioResponseDto;
import com.example.rachai_pay.Service.UsuarioSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioSevice usuarioSevice;



    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvarGrupo(@RequestBody UsuarioRequestDto data){
        var request =  usuarioSevice.criarUsuario(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
