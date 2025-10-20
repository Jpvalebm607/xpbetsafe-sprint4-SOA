CREATE TABLE IF NOT EXISTS alertas (
  id UUID PRIMARY KEY,
  usuario_id UUID NOT NULL,
  tipo VARCHAR(40) NOT NULL,
  severidade VARCHAR(20) NOT NULL,
  mensagem TEXT NOT NULL,
  status VARCHAR(20) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);
CREATE INDEX IF NOT EXISTS idx_alertas_usuario ON alertas(usuario_id);
