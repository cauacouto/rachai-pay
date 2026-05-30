package com.example.rachai_pay.Dtos;

import java.math.BigDecimal;

public record DespesaDto(
        String nomeDespesa,
        BigDecimal valor,
        int quantidadeMembros,
        Long grupoID,
        BigDecimal valorPorPessoa

) {
}
