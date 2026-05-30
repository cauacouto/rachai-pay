[README.md](https://github.com/user-attachments/files/28331192/README.md)
<div align="center">

```
██████╗  █████╗  ██████╗██╗  ██╗ █████╗ ██╗    ██████╗  █████╗ ██╗   ██╗
██╔══██╗██╔══██╗██╔════╝██║  ██║██╔══██╗██║    ██╔══██╗██╔══██╗╚██╗ ██╔╝
██████╔╝███████║██║     ███████║███████║██║    ██████╔╝███████║ ╚████╔╝ 
██╔══██╗██╔══██║██║     ██╔══██║██╔══██║██║    ██╔═══╝ ██╔══██║  ╚██╔╝  
██║  ██║██║  ██║╚██████╗██║  ██║██║  ██║██║    ██║     ██║  ██║   ██║   
╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝    ╚═╝     ╚═╝  ╚═╝   ╚═╝   
```

### ⚡ Divida despesas. Simplifique pagamentos. Conecte pessoas.

<br/>

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Hibernate](https://img.shields.io/badge/JPA-Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/status-Em%20Desenvolvimento-yellow?style=for-the-badge)

</div>

---

## 🌐 Visão Geral

**Rachai Pay** é uma API backend moderna para **divisão inteligente de despesas em grupo**. Inspirado no Splitwise, mas construído do zero com arquitetura limpa e decisões técnicas sólidas.

> _"Sem mais confusão em quem deve o quê — o Rachai Pay resolve."_

---

## 🏗️ Arquitetura & Stack

```
┌─────────────────────────────────────────────┐
│                  CLIENT / API               │
└──────────────────────┬──────────────────────┘
                       │ REST
┌──────────────────────▼──────────────────────┐
│             Spring Boot Application         │
│  ┌──────────┐  ┌──────────┐  ┌───────────┐ │
│  │ Controller│  │ Service  │  │Repository │ │
│  └──────────┘  └──────────┘  └─────┬─────┘ │
└────────────────────────────────────┼────────┘
                                     │ JPA/Hibernate
┌────────────────────────────────────▼────────┐
│                  PostgreSQL                 │
└─────────────────────────────────────────────┘

```

---

## 🧬 Modelagem de Domínio

### Diagrama de Entidades

```
┌──────────┐        ┌───────────────┐        ┌──────────┐
│   User   │───────▶│  GroupMember  │◀───────│  Group   │
│──────────│  1:N   │───────────────│  N:1   │──────────│
│ id       │        │ balance       │        │ id       │
│ name     │        │ role          │        │ name     │
│ email    │        │ status        │        │ createdAt│
└──────────┘        └───────────────┘        └────┬─────┘
                                                  │ 1:N
                                            ┌─────▼─────┐        ┌───────────┐
                                            │  Despesa  │───────▶│  Divisao  │
                                            │───────────│  1:N   │───────────│
                                            │ valor     │        │ valor     │
                                            │ descricao │        │           │
                                            └───────────┘        └───────────┘
```

### 📋 Entidades

<details>
<summary><strong>👤 User</strong> — Usuário da plataforma</summary>

Entidade central que representa qualquer pessoa cadastrada no sistema.

</details>

<details>
<summary><strong>👥 Group</strong> — Grupo de despesas</summary>

Agrupa usuários em torno de um contexto compartilhado (viagem, república, evento, etc).

</details>

<details>
<summary><strong>🔗 GroupMember</strong> — Participação em grupo</summary>

Entidade de junção com dados próprios — substitui um `@ManyToMany` simples.

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `user` | `@ManyToOne User` | Usuário participante |
| `group` | `@ManyToOne Group` | Grupo relacionado |
| `balance` | `BigDecimal` | Saldo atual do membro |
| `role` | `Enum` | `OWNER` \| `MEMBER` |
| `status` | `Enum` | `ACTIVE` \| `LEFT` |

</details>

<details>
<summary><strong>💳 Despesa</strong> — Despesa do grupo</summary>

Registro de um gasto criado dentro de um grupo.

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `group` | `@ManyToOne Group` | Grupo ao qual pertence |
| `valor` | `BigDecimal` | Valor total |
| `descricao` | `String` | Descrição do gasto |

</details>

<details>
<summary><strong>⚖️ Divisao</strong> — Parcela individual</summary>

Entidade de junção com dados próprios — substitui um `@ManyToMany` simples entre `User` e `Despesa`.

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `user` | `@ManyToOne User` | Responsável pela parcela |
| `despesa` | `@ManyToOne Despesa` | Despesa relacionada |
| `valor` | `BigDecimal` | Valor da parcela |

</details>

---

## 🧠 Decisões Técnicas

| Decisão | Motivo |
|--------|--------|
| ❌ Sem `@ManyToMany` direto | Relações com dados próprios viram entidades com `@ManyToOne` nos dois lados |
| ✅ `@JoinColumn` para FKs | Controle explícito das chaves estrangeiras no banco |
| ✅ `@Column` para campos simples | Mapeamento claro e sem ambiguidade |

---

## 🗂️ Estrutura do Projeto

```
src/main/java/com/rachaipay/
├── 👤 user/
│   ├── User.java
│   └── UserRepository.java
├── 👥 group/
│   ├── Group.java
│   ├── GroupMember.java
│   └── GroupRepository.java
├── 💳 despesa/
│   ├── Despesa.java
│   ├── Divisao.java
│   └── DespesaRepository.java
```

---

## 🚀 Como Rodar

### Pré-requisitos

- Java 17+
- Maven 3.8+
- PostgreSQL rodando localmente

### Setup

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/rachai-pay.git
cd rachai-pay

# 2. Configure o banco em src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/rachaipay
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

# 3. Suba a aplicação
./mvnw spring-boot:run
```

> A API estará disponível em `http://localhost:8080`

---

## 📍 Roadmap

- [ ] 🔐 Autenticação com Spring Security + JWT
- [ ] 📬 Endpoints REST para grupos e despesas
- [ ] ⚖️ Lógica de cálculo e balanceamento de saldos
- [ ] 🧪 Testes unitários e de integração
- [ ] 🐳 Dockerização da aplicação
- [ ] 📄 Documentação Swagger/OpenAPI

---

<div align="center">

Feito com ☕ e muito `@ManyToOne`

</div>
