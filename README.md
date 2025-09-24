# Sprint 3: API de Produtos com Segurança JWT e Boas Práticas

API RESTful para gerenciamento de produtos, evoluída com um sistema de autenticação e autorização via JSON Web Tokens (JWT), validações de dados e DTOs.

## Grupo
- Bruno Cont
- Beatriz Porto
- Gabriel Dantas
- Henrique Souza
- Vinicius Hermes

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3
- Spring Web, Spring Data JPA, **Spring Security**
- H2 Database
- Maven
- **JSON Web Token (JWT)**

## Como Executar a Aplicação

1.  **Pré-requisitos:** Java 17 (ou superior) e Maven instalados.
2.  **Clone o repositório e acesse a pasta:** `git clone <URL_DO_REPOSITORIO> && cd sprint2api`
3.  **Execute a aplicação:**
    ```bash
    # No Windows: ./mvnw.cmd spring-boot:run
    # No Linux/macOS: ./mvnw spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

## Endpoints da API

### Autenticação (Público)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/auth/register` | Registra um novo usuário. |
| `POST` | `/auth/login` | Autentica um usuário e retorna um token JWT. |

### Produtos (Protegido - Requer Token)

A base da URL é `/api/produtos`.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/` | Cria um novo produto. |
| `GET` | `/` | Lista todos os produtos. |
| `GET` | `/{id}` | Busca um produto pelo ID. |
| `DELETE` | `/{id}` | Deleta um produto pelo ID. |

## Exemplos de Requisição (com cURL)

**1. Registrar um novo usuário**
```bash
curl -X POST http://localhost:8080/auth/register \
-H "Content-Type: application/json" \
-d '{
  "nome": "Beatriz Porto",
  "email": "bia@email.com",
  "senha": "senha123"
}'
```

**2. Fazer login para obter o token**
```bash
curl -X POST http://localhost:8080/auth/login \
-H "Content-Type: application/json" \
-d '{
  "email": "bia@email.com",
  "senha": "senha123"
}'
```
> **Resposta:** Você receberá um JSON com o token. Ex: `{"token":"eyJhbGciOiJIUzI1NiJ9..."}`. Copie este token.

**3. Acessar um endpoint protegido (criar um produto)**

Substitua `SEU_TOKEN_AQUI` pelo token que você copiou.

```bash
curl -X POST http://localhost:8080/api/produtos \
-H "Content-Type: application/json" \
-H "Authorization: Bearer SEU_TOKEN_AQUI" \
-d '{
  "nome": "Notebook Gamer",
  "preco": 5999.90
}'
```

### Acesso ao Console do H2
- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:file:./dados_da_sprint`
- **User Name:** `sa`
- **Password:** (vazio)