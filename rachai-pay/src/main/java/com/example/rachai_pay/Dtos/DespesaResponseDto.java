package com.example.rachai_pay.Dtos;

import java.math.BigDecimal;

public record DespesaResponseDto(
        String nomeDespesa,
        BigDecimal valor,
        int quantidadeMembros,
         BigDecimal valorPorPessoa

) {
}
