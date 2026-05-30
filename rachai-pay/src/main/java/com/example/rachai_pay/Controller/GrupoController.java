package com.example.rachai_pay.Controller;

import com.example.rachai_pay.Dtos.*;
import com.example.rachai_pay.Service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        public ResponseEntity<MembroGrupDto> adicionarMembros(@PathVariable Long grupoId,@PathVariable UUID usuarioId){
           var result = grupoService.adicionarMembros(grupoId,usuarioId);
            return ResponseEntity.ok().body(result);
        }

        @PostMapping("/{id}/despesa")
        public ResponseEntity<DespesaResponseDto> criarDespesa(@RequestBody DespesaDto dto,@PathVariable Long id){
        var DespesaCriada = grupoService.criarDepesa(dto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(DespesaCriada);
        }

    @GetMapping("/{grupoId}/membros")
    public ResponseEntity<List<MembroGrupDto>> listarMembros(@PathVariable Long grupoId) {
        List<MembroGrupDto> membros = grupoService.listar(grupoId);
        return ResponseEntity.ok(membros);
    }
    }
