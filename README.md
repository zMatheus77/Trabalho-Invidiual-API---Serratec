# 🐾 ONG Animais - Sistema de Adoção

## 👤 Nome do aluno
Matheus da Silva Schmid Lahr

---

## 📌 Descrição do projeto

O projeto **ONG Animais** é uma API REST desenvolvida para gerenciar uma ONG fictícia de adoção de animais.

O sistema permite:
- Cadastro de pessoas interessadas em adoção
- Cadastro de animais disponíveis
- Registro de interesse de adoção
- Gerenciamento de campanhas de adoção
- Relacionamentos entre pessoas, animais e campanhas

O objetivo principal é simular um sistema real de adoção utilizando boas práticas de desenvolvimento com Spring Boot, DTOs, validações e tratamento de exceções.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 / PostgreSQL (dependendo do ambiente)
- Bean Validation (Jakarta Validation)
- Swagger / OpenAPI
- Maven

---

## ⚙️ Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- Java 17 ou superior
- Maven
- Banco de dados configurado (PostgreSQL)
- IDE (IntelliJ, Eclipse ou VS Code)

---

### Pré-requisitos

- JDK 17 ou superior
- PostgreSQL instalado
- Maven
- Postman instalado

---

## 🗄️ Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL chamado:

```sql
ong_animais


## 2. Configurar as credenciais

No arquivo:

```bash
src/main/resources/application.properties
```

Adicione ou atualize as configurações:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ong_animais
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

---

# ▶️ Executando a Aplicação

Execute o projeto:

```bash
./mvnw spring-boot:run
```

pelo terminal da sua IDE.

---

# 🛠️ Build do Projeto

Para compilar o projeto utilizando Maven:

```bash
mvn clean install
```

---

# 🌐 Testando a API

Após iniciar a aplicação, utilize o Postman para testar os endpoints da API.

Exemplo de URL base:

```bash
http://localhost:8080
```
