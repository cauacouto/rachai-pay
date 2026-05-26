package com.example.rachai_pay.Repository;

import com.example.rachai_pay.domin.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuarios, UUID> {

}
