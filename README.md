# 🚨 Alertas Service

Microserviço desenvolvido na **Sprint 4 de SOA & Web Services (FIAP)**, responsável pelo registro e gerenciamento de **alertas de comportamento anormal** dentro da plataforma XP BetSafe

---

## 🧑‍💻 Integrantes do Grupo
- João Pedro Do Vale Cruz Novo – RM 98650  
- Victor Eid Carbutti Nicolas – RM 98668  
- Tiago Rafael Paulino Ferreira – RM 551169  

---

## ⚙️ Tecnologias
- Java 21  
- Spring Boot 3.3.4  
- PostgreSQL 16.10  
- Flyway  
- Gradle  
- Lombok  

---

## ▶️ Como executar

```bash
# Iniciar o banco PostgreSQL
pg_ctl -D "C:\Postgres\16\data" start

# Rodar o serviço
./gradlew bootRun
