package com.sprint4.alertas.api;

import com.sprint4.alertas.api.dto.*;
import com.sprint4.alertas.app.AlertaService;
import com.sprint4.alertas.domain.Alerta;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alertas")
public class AlertaController {
  private final AlertaService service;
  public AlertaController(AlertaService service) { this.service = service; }

  @PostMapping
  public ResponseEntity<AlertaResponseDTO> create(@Valid @RequestBody AlertaCreateDTO dto) {
    Alerta a = new Alerta();
    a.setUsuarioId(dto.usuarioId());
    a.setTipo(dto.tipo());
    a.setSeveridade(dto.severidade());
    a.setMensagem(dto.mensagem());
    var saved = service.create(a);
    return ResponseEntity.status(HttpStatus.CREATED).body(
      new AlertaResponseDTO(
        saved.getId(), saved.getUsuarioId(), saved.getTipo(), saved.getSeveridade(),
        saved.getMensagem(), saved.getStatus(), saved.getCreatedAt(), saved.getUpdatedAt()
      )
    );
  }

  @GetMapping
  public Page<AlertaResponseDTO> list(
      @RequestParam(required = false) UUID usuarioId,
      @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
    return service.list(usuarioId, pageable).map(a ->
      new AlertaResponseDTO(
        a.getId(), a.getUsuarioId(), a.getTipo(), a.getSeveridade(),
        a.getMensagem(), a.getStatus(), a.getCreatedAt(), a.getUpdatedAt()
      )
    );
  }

  @GetMapping("/{id}")
  public AlertaResponseDTO get(@PathVariable UUID id) {
    var a = service.get(id);
    return new AlertaResponseDTO(
      a.getId(), a.getUsuarioId(), a.getTipo(), a.getSeveridade(),
      a.getMensagem(), a.getStatus(), a.getCreatedAt(), a.getUpdatedAt()
    );
  }

  @PatchMapping("/{id}/status")
  public AlertaResponseDTO updateStatus(@PathVariable UUID id, @Valid @RequestBody AlertaUpdateStatusDTO body) {
    var a = service.updateStatus(id, body.status());
    return new AlertaResponseDTO(
      a.getId(), a.getUsuarioId(), a.getTipo(), a.getSeveridade(),
      a.getMensagem(), a.getStatus(), a.getCreatedAt(), a.getUpdatedAt()
    );
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) { service.delete(id); }
}
