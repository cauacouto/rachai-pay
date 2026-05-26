package com.example.rachai_pay.Dtos;

import com.example.rachai_pay.Enum.Cargo;

import java.time.LocalDateTime;
import java.util.UUID;

public record GrupoResponseDto(
        Integer id,
        String nomeGrupo,
        LocalDateTime criadoEm,
         UUID criadorId,
        String nome,
        Cargo cargo
) {}


