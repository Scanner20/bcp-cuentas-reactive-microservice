# Cuentas Reactive Microservice

Microservicio reactivo de consulta de saldos bancarios, construido con Spring Boot 3 + WebFlux + R2DBC.

## Por qué reactivo
Este servicio usa programación reactiva (Project Reactor) para manejar múltiples
consultas concurrentes de saldo sin bloquear hilos, ideal para un banco con alto
volumen de consultas simultáneas.

## Stack
Java 17 · Spring Boot 3 · Spring WebFlux · Spring Data R2DBC · H2 · JUnit 5 · StepVerifier · Docker

## Endpoints
- GET /api/cuentas
- GET /api/cuentas/{id}
- POST /api/cuentas

## Cómo correrlo
\`\`\`powershell
.\mvnw.cmd spring-boot:run
\`\`\`

## Tests
\`\`\`powershell
.\mvnw.cmd test
\`\`\`