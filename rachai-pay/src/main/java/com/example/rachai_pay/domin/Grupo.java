package com.example.rachai_pay.domin;

import com.example.rachai_pay.Enum.Cargo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DB_GRUPO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grupo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;

    private String nomeGrupo;

    @ManyToOne
    @JoinColumn(name = "criador_Id")
    private Usuarios criador;

    @OneToMany(mappedBy = "grupo")

    private List<MembrosGrup> membros;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime criadoEm;

    @Enumerated(EnumType.STRING)
    private Cargo cargo = Cargo.ADMIN;


    @PrePersist
    public void dataCriacao(){
        this.criadoEm = LocalDateTime.now();
    }
}
