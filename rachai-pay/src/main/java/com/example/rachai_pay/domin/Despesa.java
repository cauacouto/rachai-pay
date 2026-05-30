package com.example.rachai_pay.domin;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DB_Despesa")
@Getter
@Setter
@ToString(exclude = "grupos")
@EqualsAndHashCode(exclude = "grupos")
@AllArgsConstructor
@NoArgsConstructor
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String nomeDespesa;
    private BigDecimal valor;
    private int quantidadeMmebros;
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

}
