package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.DespesaResponseDto;
import com.example.rachai_pay.domin.Despesa;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T22:27:19-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Ubuntu)"
)
@Component
public class DespesaMapperImpl implements DespesaMapper {

    @Override
    public DespesaResponseDto toDto(Despesa despesa) {
        if ( despesa == null ) {
            return null;
        }

        String nomeDespesa = null;
        BigDecimal valor = null;

        nomeDespesa = despesa.getNomeDespesa();
        valor = despesa.getValor();

        BigDecimal valorPorPessoa = calcularDespesa(despesa);
        int quantidadeMembros = 0;

        DespesaResponseDto despesaResponseDto = new DespesaResponseDto( nomeDespesa, valor, quantidadeMembros, valorPorPessoa );

        return despesaResponseDto;
    }
}
