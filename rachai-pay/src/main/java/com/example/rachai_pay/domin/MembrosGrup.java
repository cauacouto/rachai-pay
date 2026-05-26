package com.example.rachai_pay.domin;

import com.example.rachai_pay.Enum.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "DB_GRUPOMENBER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembrosGrup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
    private LocalDateTime dataEntrada;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @PrePersist
    public void dataEntrada(){
        this.dataEntrada = LocalDateTime.now();
    }

}
