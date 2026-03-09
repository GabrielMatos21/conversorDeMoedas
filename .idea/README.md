<h1 align="center"> 🪙 Conversor de Moedas </h1>

<p align="center">
  <img src="https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
</p>

## 💻 Sobre o Projeto

Este projeto é um **Conversor de Moedas** desenvolvido em Java, criado como resolução do Challenge da formação Back-end da **Alura**.

O sistema oferece uma interação via console (terminal) onde o usuário pode escolher entre diversas opções de conversão cambial. As taxas de câmbio não são estáticas; o programa consome a **ExchangeRate-API** para buscar os valores de conversão em tempo real e utiliza a biblioteca **Gson** para realizar a desserialização do arquivo JSON retornado pela API.

## ⚙️ Funcionalidades

- Menu interativo via console.
- Suporte a 6 tipos de conversões envolvendo moedas da América do Sul e o Dólar:
    - Dólar (USD) ↔ Real (BRL)
    - Peso Argentino (ARS) ↔ Real (BRL)
    - Peso Colombiano (COP) ↔ Real (BRL)
- Requisições HTTP em tempo real.
- Tratamento de respostas em formato JSON.

## 🛠️ Tecnologias Utilizadas

- **Java 17** (ou superior)
- **HttpClient, HttpRequest e HttpResponse** (Nativas do Java para consumo de API)
- **[Gson](https://github.com/google/gson)** (Biblioteca do Google para manipulação de JSON)
- **[ExchangeRate-API](https://www.exchangerate-api.com/)** (API de taxas de câmbio)

## 🚀 Como Executar

**Pré-requisitos:**
- Ter o [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) instalado.
- Ter uma IDE como IntelliJ IDEA ou Eclipse.
- Gerar uma chave gratuita na [ExchangeRate-API](https://www.exchangerate-api.com/).

**Passo a passo:**

1. Clone este repositório:
   ```bash
   git clone [https://github.com/seu-usuario/conversorDeMoedas.git](https://github.com/seu-usuario/conversorDeMoedas.git)
   Abra o projeto na sua IDE.

Adicione a biblioteca Gson (via Maven ou baixando o .jar diretamente) às dependências do projeto.

No arquivo ConversorDeMoedas.java, localize a variável apiKey e substitua "SUA_CHAVE_AQUI" pela sua chave da API.
Execute a classe ConversorDeMoedas.

<p align="center">
Desenvolvido por <strong>Gabriel Matos</strong>.
</p>


### O Último Passo (Subir para o GitHub)

Depois de colar e salvar o README, precisamos mandar essa atualização (o arquivo novo) lá para o seu GitHub:

1.  Clique no ícone de **Commit** (o check verde na lateral esquerda).
2.  Na mensagem de commit, escreva algo como: `"docs: Adicionando README do projeto"`.
3.  Em vez de clicar só em "Commit", clique na setinha ao lado do botão e escolha **Commit and Push...**.
4.  Na janela que abrir, clique em **Push**.