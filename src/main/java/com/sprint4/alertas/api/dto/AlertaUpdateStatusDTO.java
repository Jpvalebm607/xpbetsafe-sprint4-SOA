package com.sprint4.alertas.api.dto;

import com.sprint4.alertas.domain.StatusAlerta;
import jakarta.validation.constraints.NotNull;

public record AlertaUpdateStatusDTO(@NotNull StatusAlerta status) {}
