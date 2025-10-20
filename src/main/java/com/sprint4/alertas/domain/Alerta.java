package com.sprint4.alertas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "alertas")
@Getter @Setter @NoArgsConstructor
public class Alerta {
    @Id
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Enumerated(EnumType.STRING)
    private TipoAlerta tipo;

    @Enumerated(EnumType.STRING)
    private Severidade severidade;

    @Column(nullable = false)
    private String mensagem;

    @Enumerated(EnumType.STRING)
    private StatusAlerta status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PrePersist
    void prePersist() {
        this.id = UUID.randomUUID();
        this.createdAt = this.updatedAt = Instant.now();
        if (this.status == null) this.status = StatusAlerta.ABERTO;
    }

    @PreUpdate
    void preUpdate() { this.updatedAt = Instant.now(); }
}
