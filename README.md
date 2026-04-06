# Todo API - Spring Boot

API REST para gerenciamento de tarefas (To-Do), desenvolvida com Java e Spring Boot.

O projeto permite criar, listar, atualizar e deletar tarefas, seguindo boas práticas de desenvolvimento backend, como uso de DTOs, tratamento global de exceções e paginação.

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- Maven

### 📌 Tarefas

- GET /v1/todos/ → Lista tarefas (com paginação)
- GET /v1/todos/{id} → Busca por ID
- POST /v1/todos/ → Criar tarefa
- PUT /v1/todos/{id} → Atualizar Todo
- PATCH /v1/todos/{id}/status?status= → Atualizar Status
- DELETE /v1/todos/{id} → Remover tarefa

## ✨ Diferenciais

- Arquitetura em camadas (Controller, Service, Repository)
- Uso de DTOs para transferência de dados
- Tratamento global de exceções com ProblemDetail
- Paginação com Pageable
- Integração com banco de dados via Docker
