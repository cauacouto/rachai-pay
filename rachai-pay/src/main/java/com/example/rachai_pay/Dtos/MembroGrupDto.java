package com.example.rachai_pay.Dtos;

import com.example.rachai_pay.Enum.Cargo;

import java.time.LocalDateTime;
import java.util.UUID;

public record MembroGrupDto(
        UUID usuarioId,
        Long grupoId,
        String nomeGrupo,
        Cargo cargo,
        LocalDateTime dataEntrada
){}

