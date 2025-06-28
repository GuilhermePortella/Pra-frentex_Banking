# ✨ Arquitetura do Projeto PraFrentex - Análise e Melhorias

## 🎯 Objetivo

Este documento visa analisar a arquitetura atual do projeto `PraFrentex` e sugerir melhorias alinhadas a boas práticas de design, como DDD (Domain-Driven Design), princípios SOLID e Clean Architecture, levando em consideração que o projeto é implementado em **Java puro**, sem uso de frameworks como Spring.

---

## 📦 Estrutura Atual dos Pacotes

```
br.prafrentex_domain             # Entidades do domínio
br.prafrentex_service            # Serviços de aplicação
br.prafrentex_service.RegisterUser
br.prafrentex_service.audit      # Logging e auditoria
br.prafrentex_service.CPFValidation / CNPJValidation
```

---

## ✅ Pontos Positivos

* Modelagem inicial do domínio clara (`Usuario`, `ContaPF`, `ContaPJ`, `OperacaoConta`).
* Serviços especializados por contexto (`CadastroUsuarioService`, `AuthService`, `ContaOperacoesService`).
* Camada de auditoria e validação bem definidas.
* Uso de DAOs para abstrair a persistência (como `UsuarioDAO`).

---

## ⚠️ Pontos de Atenção

| Ponto de Atenção                      | Impacto Potencial                          | Recomendação                                                              |
| ------------------------------------- | ------------------------------------------ | ------------------------------------------------------------------------- |
| Acoplamento entre entidades           | Aumenta complexidade e reduz flexibilidade | Usar abstrações ou Value Objects                                          |
| Lógica duplicada entre serviços       | Código difícil de manter/testar            | Consolidar em um único serviço por responsabilidade                       |
| Falta de interfaces para persistência | Viola DIP, dificulta testes                | Criar repositórios com interfaces                                         |
| Regras de negócio nos serviços REST   | Reduz reusabilidade                        | Extrair serviços de domínio                                               |
| Sem camada de DTOs clara              | Risco de vazamento de entidades            | Introduzir camada de DTOs nos boundaries                                  |
| Serviços excessivamente genéricos     | Viola SRP, dificulta rastreabilidade       | Dividir serviços conforme contexto (ex: `ContaService`, `UsuarioService`) |

---

## 📂 Sugestão de Nova Arquitetura (em Java puro)

```
src/
├── domain/
│   ├── model/
│   │   ├── usuario/
│   │   │   ├── Usuario.java
│   │   │   ├── ContaPF.java
│   │   │   └── ContaPJ.java
│   │   ├── operacao/
│   │   │   ├── OperacaoConta.java
│   │   │   └── TipoOperacao.java
│   └── service/
│       └── regras/
│           ├── ContaService.java
│           └── UsuarioService.java
├── application/
│   ├── usecases/
│   │   ├── AbrirContaPFUseCase.java
│   │   ├── TransferirUseCase.java
│   │   └── AutenticarUsuarioUseCase.java
│   └── dto/
│       ├── UsuarioDTO.java
│       └── ContaDTO.java
├── infrastructure/
│   ├── repository/
│   │   ├── UsuarioRepository.java (interface)
│   │   ├── ContaRepository.java (interface)
│   │   ├── InMemoryUsuarioRepository.java
│   │   └── InMemoryContaRepository.java
│   ├── validation/
│   │   ├── CPFValidator.java
│   │   └── CNPJValidator.java
│   └── audit/
│       └── AuditLogger.java
├── interfaces/
│   └── console/
│       ├── Main.java
│       └── MenuUI.java
```

---

## 🔁 Camadas Propostas

| Camada           | Responsabilidade                                              |
| ---------------- | ------------------------------------------------------------- |
| `domain`         | Modelos ricos, lógica de negócio pura, serviços de domínio    |
| `application`    | Coordenação de casos de uso, conversão DTO ↔ entidade         |
| `infrastructure` | Persistência, logs, validações específicas, serviços externos |
| `interfaces`     | Interfaces com o usuário (menus, entradas via console, etc.)  |

---

## 🔧 Tecnologias e Práticas Recomendadas (Java puro)

* **Serialização com JSON-B ou GSON** (se desejar JSON).
* **Validação manual ou com javax.validation** via libs externas.
* **DAO pattern com interfaces** + implementação com arquivos, SQLite ou HashMaps.
* **Design orientado a interfaces**, separando lógica e persistência.
* **Testes com JUnit 5 + Mockito (opcional).**
* **Logging com Java Util Logging (ou SLF4J se preferir libs externas).**

---

## 🧪 Sugestão de Testes por Camada

| Camada         | Testes recomendados             |
| -------------- | ------------------------------- |
| Domain         | Testes unitários de regras      |
| Application    | Testes de caso de uso           |
| Infrastructure | Testes de integração            |
| Interfaces     | Testes de interface (simulados) |

---

## 🚀 Possíveis Evoluções Futuras

* **Separar leitura e escrita (CQRS).**
* **Adicionar eventos internos (Observer Pattern).**
* **Implementar uma camada de notificadores (e-mail, SMS, etc.).**
* **Persistência com arquivos locais ou bancos simples (SQLite).**

---