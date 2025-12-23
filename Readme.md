# Gerenciamento de Produtos


API REST para gerenciamento de produtos

## Funcionalidades Principais

* **Cadastro de Produtos:** Cadastrar um produto com nome, descrição, preço e uma categoria.
* **Tabela Produtos** Um produto só pode ter uma categoria, mas uma categoria pode ter varios produtos.

##  Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 4.0** (Web, Data JPA, Security, Validation)
* **MapStruct:** Para mapeamento entre Entidades e DTOs.
* **SpringDoc OpenAPI (Swagger)**: Documentação interativa e testes da API.
* **PostgreSQL:** Banco de dados relacional.
* **Lombok:** Para redução de código.

##  Arquitetura

O projeto segue a arquitetura em camadas para facilitar a manutenção e escalabilidade:

1.  Controller: endpoints REST.
2.  Business: Camada de inteligência e regras de negócio.
3.  Repository: Interface de comunicação com o banco de dados via Spring Data JPA.
4.  Infrastructure: Configurações de segurança, tratamento de exceções e mappers.

### Passo 1 Configure o banco de dados: 

#### Edite o arquivo src/main/resources/application.properties com suas credenciais:


Properties

spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

### Passo 2: Acessar a Documentação (Swagger)
Com a aplicação rodando, acesse a interface do Swagger para visualizar e testar os endpoints:
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Passo 3: Cadastrar um Produto (POST)
Ao cadastrar um produto, a API utiliza uma **lógica inteligente** para gerenciar a categoria informada:
1. O sistema verifica se a categoria já existe no banco pelo nome.
2. Se existir, o produto é vinculado à categoria já cadastrada.
3. Se for uma categoria nova, ela é criada automaticamente no banco (Cascade).

* **Endpoint:** `POST /api/produtos`
* **Corpo da Requisição (JSON):**

```json
{
  "nome": "Celular",
  "descricao": "Celular com 16Gb de RAM",
  "preco": 1250.55,
  "categoria": {
    "nome": "Eletrônicos"
  }
  ```

### Passo 4 para consultar um (Get) pelo ID

* **Endpoint:** `GET /api/produtos/{id}`

```json
{
  "id": 1,
  "nome": "Celular",
  "descricao": "Celular com 16Gb de RAM",
  "preco": 1250.55,
  "categoria": {
    "id": 1,
    "nome": "Eletrônicos"
  }
}
```
### Passo 5 Atualizar um produto (PUT)

* **Endpoint:** `PUT /api/produtos/{id}`

Corpo da Requisição (JSON):

```json
{
"nome": "Celular Premium",
"descricao": "Celular com 256Gb de memória",
"preco": 2100.00,
"categoria": {
"nome": "Eletrônicos"
}
}
```

### Passo 6 Deletar Um Produto (DELETE)

* Endpoint: ** `DELETE /api/produtos/{id}`