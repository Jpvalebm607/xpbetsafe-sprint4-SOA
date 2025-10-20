package com.sprint4.alertas.api.dto;

import com.sprint4.alertas.domain.Severidade;
import com.sprint4.alertas.domain.TipoAlerta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AlertaCreateDTO(
        @NotNull UUID usuarioId,
        @NotNull TipoAlerta tipo,
        @NotNull Severidade severidade,
        @NotBlank @Size(max = 500) String mensagem
) {}
