package com.example.rachai_pay.Mapper;

import com.example.rachai_pay.Dtos.DespesaResponseDto;
import com.example.rachai_pay.domin.Despesa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Mapper(componentModel = "spring")
public interface DespesaMapper {


   @Mapping(target = "valorPorPessoa", expression = "java(calcularDespesa(despesa))")
   DespesaResponseDto toDto(Despesa despesa);


  default BigDecimal calcularDespesa (Despesa despesa){

     return despesa.getValor()
             .divide(
                     new BigDecimal(despesa.getQuantidadeMmebros()),
                     2,RoundingMode.HALF_UP
             );



  }

}
