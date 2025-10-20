package com.sprint4.alertas.api.dto;

import com.sprint4.alertas.domain.*;
import java.time.Instant;
import java.util.UUID;

public record AlertaResponseDTO(
  UUID id,
  UUID usuarioId,
  TipoAlerta tipo,
  Severidade severidade,
  String mensagem,
  StatusAlerta status,
  Instant createdAt,
  Instant updatedAt
) {}
