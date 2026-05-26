package com.example.rachai_pay.Repository;

import com.example.rachai_pay.domin.MembrosGrup;
import com.example.rachai_pay.domin.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MembrosGroupRepository extends JpaRepository<MembrosGrup,Long> {
    List<MembrosGrup> findByUsuarioId(UUID usuarioId);
}
