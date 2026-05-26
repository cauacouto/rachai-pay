package com.example.rachai_pay.Dtos;

import com.example.rachai_pay.Enum.Cargo;

import java.time.LocalDateTime;

public record MembroGrupDto(
        String usuarioId,
        String grupoId,
        Cargo cargo,
        LocalDateTime dataEntrada
){}

