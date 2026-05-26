package com.example.rachai_pay.Controller;

import com.example.rachai_pay.Dtos.GrupoRequestDto;
import com.example.rachai_pay.Dtos.GrupoResponseDto;
import com.example.rachai_pay.Dtos.MembroGrupDto;
import com.example.rachai_pay.Service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/grupo")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoService grupoService;



    @PostMapping("/{id}")
    public ResponseEntity<GrupoResponseDto> salvarGrupo(@RequestBody GrupoRequestDto data,@PathVariable UUID id){
        var request = grupoService.criarGrupo(data,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PostMapping("/{grupoId}/membros/{usuarioId}")
    public ResponseEntity<MembroGrupDto> adicionarMembros(@PathVariable UUID usuarioId,@PathVariable Long grupoId){
        grupoService.adicionarMembros(grupoId,usuarioId);
        return ResponseEntity.ok().build();
    }
}
