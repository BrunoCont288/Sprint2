# Sprint 2: API de Produtos com Spring Boot e H2

API RESTful para gerenciamento de produtos, desenvolvida como parte da Sprint 2. A aplicação permite realizar operações CRUD (Criar, Ler, Deletar) para a entidade Produto e persiste os dados em um banco H2 em modo arquivo.
## Grupo
- Bruno Cont
- Beatriz Porto
- Gabriel Dantas
- Henrique Souza
- Vinicius Hermes

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Como Executar a Aplicação

1.  **Pré-requisitos:** É necessário ter o Java 17 (ou superior) e o Maven instalados.

2.  **Clone o repositório:**
    ```bash
    git clone <URL_DO_SEU_REPOSITORIO_NO_GITHUB>
    cd sprint2api
    ```

3.  **Execute a aplicação:**
    Use o Maven Wrapper para compilar e iniciar o servidor Spring Boot.
    ```bash
    # No Windows
    ./mvnw.cmd spring-boot:run

    # No Linux ou macOS
    ./mvnw spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

## Endpoints da API

A base da URL para todos os endpoints é `/api/produtos`.

| Método   | Endpoint | Descrição                               |
| :------- | :------- | :---------------------------------------- |
| `POST`   | `/`      | Cria um novo produto.                     |
| `GET`    | `/`      | Lista todos os produtos cadastrados.      |
| `GET`    | `/{id}`  | Busca um produto específico pelo seu ID.  |
| `DELETE` | `/{id}`  | Deleta um produto pelo seu ID.            |

### Acesso ao Console do H2

Para visualizar o banco de dados diretamente, acesse no seu navegador:
- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:file:./dados_da_sprint`
- **User Name:** `sa`
- **Password:** (deixe em branco)