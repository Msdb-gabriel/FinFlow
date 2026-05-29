 💰 Sistema Financeiro em Java (Console)

Projeto de um sistema financeiro desenvolvido em Java puro, com foco em simular a estrutura de um backend real utilizando arquitetura em camadas. A aplicação permite o controle de receitas e despesas, cálculo de saldo, filtros por período e geração de relatórios financeiros no terminal.

---

 📌 Objetivo

Este projeto foi desenvolvido com o objetivo de praticar fundamentos sólidos de backend, incluindo orientação a objetos, separação de responsabilidades e regras de negócio aplicadas em um cenário próximo ao real (sistemas financeiros).

---

 ⚙️ Funcionalidades

- Cadastro de receitas e despesas
- Listagem de todas as transações
- Cálculo de saldo total
- Filtragem de transações por mês e ano
- Geração de relatório mensal com resumo financeiro

---

 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Herança e polimorfismo
- Encapsulamento
- Estrutura em camadas (Controller / Service / Repository / Model)
- Collections (List)
- Manipulação de datas (LocalDateTime)
- Regras de negócio centralizadas no service
- Separação de responsabilidades

---

 🏗️ Arquitetura do projeto

O sistema foi organizado em camadas para simular uma aplicação backend real:

src/
├── model/ # Entidades do domínio (Transacao, Receita, Despesa)
├── service/ # Regras de negócio (FinanceiroService)
├── repository/ # Armazenamento em memória (List)
├── controller/ # Interface via terminal (Menu)
└── Main.java # Ponto de entrada da aplicação


---

 🔄 Fluxo da aplicação

O fluxo segue uma arquitetura simples de backend:

Usuário (terminal)
↓
Controller (Menu)
↓
Service (regras de negócio)
↓
Repository (armazenamento em memória)
↓
Listagem e processamento de dados


---

 📊 Exemplo de uso

=== MENU ===
1 - Adicionar transação
2 - Listar transações
3 - Filtrar por mês
4 - Gerar relatório mensal
5 - Calcular saldo
0 - Finalizar


---

 📄 Exemplo de relatório gerado

 RELATÓRIO MENSAL

Receitas: 5000.00
Despesas: 2300.00
Saldo: 2700.00


---

 🧩 Estrutura de uma transação

Cada transação contém:

- Descrição
- Valor
- Data e hora (gerada automaticamente)
- ID único (UUID)

---

 🚀 O que este projeto demonstra

Este sistema simula a base de um backend financeiro real, aplicando conceitos fundamentais que são utilizados em sistemas corporativos, como separação de camadas, organização de regras de negócio e modelagem de domínio.

---

 🔮 Possíveis melhorias futuras

- Persistência em banco de dados (PostgreSQL)
- API REST com Spring Boot
- Autenticação de usuários
- Geração de relatórios mais avançados
- Interface web

---

 🛠️ Tecnologias utilizadas

- Java
- Collections Framework
- Java Time API
- UUID
- Programação Orientada a Objetos

---

 📌 Observação

Projeto desenvolvido com foco educacional e evolução prática em backend Java.
