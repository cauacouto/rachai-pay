package com.example.rachai_pay.domin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DB_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private String nome;
    private String email;
    private String senha;
    @OneToMany(mappedBy = "usuario")
    private List<MembrosGrup> grupos;

}
