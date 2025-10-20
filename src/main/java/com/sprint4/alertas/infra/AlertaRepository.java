package com.sprint4.alertas.infra;

import com.sprint4.alertas.domain.Alerta;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, UUID> {
    Page<Alerta> findByUsuarioId(UUID usuarioId, Pageable pageable);
}
