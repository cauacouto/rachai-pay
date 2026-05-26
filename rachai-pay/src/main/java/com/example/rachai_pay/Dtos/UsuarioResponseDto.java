package com.example.rachai_pay.Dtos;

import java.util.UUID;

public record UsuarioResponseDto(
        UUID id,
        String nome,
        String email

) {
}
