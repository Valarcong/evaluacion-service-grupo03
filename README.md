# evaluacion-service-grupo03


- Spring Boot 4.1.1 · Spring Cloud 2025.1.3 · Java 25
- Puerto: **8084** · Nombre en Eureka: `EVALUACION-SERVICE-GRUPO03`

## Endpoints (vía API Gateway: `http://localhost:8070`)

| Método | Ruta | Respuesta |
|---|---|---|
| GET | `/api/v1/evaluaciones/scoring/{clienteId}` | `ScoringRiesgoDTO` |
| GET | `/api/v1/evaluaciones/cliente/{clienteId}` | Evaluación consolidada del cliente |


## Contrato JSON (`ScoringRiesgoDTO`)

```json
{
  "clienteId": 1,
  "puntajeCrediticio": 780,
  "nivelRiesgo": "BAJO",
  "capacidadMaxEndeudamiento": 45000.0,
  "dictamenRiesgo": "..."
}
```


## Ejecución


```bash
./mvnw spring-boot:run
```
