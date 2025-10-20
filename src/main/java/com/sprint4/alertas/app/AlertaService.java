package com.sprint4.alertas.app;

import com.sprint4.alertas.domain.Alerta;
import com.sprint4.alertas.domain.StatusAlerta;
import com.sprint4.alertas.infra.AlertaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {
  private final AlertaRepository repo;
  public AlertaService(AlertaRepository repo) { this.repo = repo; }

  public Alerta create(Alerta a) {
    if (a.getStatus() == null) a.setStatus(StatusAlerta.ABERTO);
    return repo.save(a);
  }

  public Page<Alerta> list(UUID usuarioId, Pageable p) {
    return usuarioId == null ? repo.findAll(p) : repo.findByUsuarioId(usuarioId, p);
  }

  public Alerta get(UUID id) {
    return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Alerta não encontrado"));
  }

  public Alerta updateStatus(UUID id, StatusAlerta s) {
    Alerta a = get(id);
    a.setStatus(s);
    return repo.save(a);
  }

  public void delete(UUID id) { repo.delete(get(id)); }
}
