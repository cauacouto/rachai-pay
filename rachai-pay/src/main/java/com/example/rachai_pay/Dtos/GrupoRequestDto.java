package com.example.rachai_pay.Dtos;

import java.util.UUID;

public record GrupoRequestDto(
        String nomeGrupo,
        UUID criadorId

) {
}
