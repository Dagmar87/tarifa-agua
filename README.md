# Tarifa de Água API

API para gerenciamento de tabelas tarifárias e cálculo de consumo de água.

## 📋 Pré-requisitos

Para rodar este projeto, você precisará ter instalado:

- **Java 17** ou superior
- **Maven 3.8+**
- **PostgreSQL** (Banco de dados)

## ⚙️ Configuração do Banco de Dados

1. Certifique-se de que o PostgreSQL está em execução.
2. Crie um banco de dados chamado `tarifa_agua`.
3. As configurações padrão de conexão no arquivo `application.properties` são:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/tarifa_agua
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   ```
   *Caso suas credenciais sejam diferentes, altere este arquivo antes de executar.*

## 🚀 Instalação e Execução

1. Clone o repositório ou baixe os arquivos.
2. Navegue até a pasta raiz do projeto.
3. Compile o projeto:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. A aplicação estará disponível em `http://localhost:8080`.

## 📖 Documentação da API (Swagger)

A documentação interativa da API pode ser acessada através do Swagger UI:
- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🛣️ Endpoints e Exemplos

### 1. Cadastrar Tabela Tarifária
`POST /api/tabelas-tarifarias`

**Request Body:**
```json
{
  "nome": "Tabela 2024",
  "categorias": [
    {
      "categoria": "PARTICULAR",
      "faixas": [
        {
          "inicio": 0,
          "fim": 10,
          "valorUnitario": 5.50
        },
        {
          "inicio": 11,
          "fim": 20,
          "valorUnitario": 7.80
        }
      ]
    }
  ]
}
```

### 2. Listar Tabelas
`GET /api/tabelas-tarifarias`

### 3. Calcular Conta
`POST /api/calculos`

**Request Body:**
```json
{
  "categoria": "PARTICULAR",
  "consumo": 15
}
```

**Response Example:**
```json
{
  "categoria": "PARTICULAR",
  "consumoTotal": 15,
  "valorTotal": 94.00,
  "detalhamento": [
    {
      "faixa": "0 a 10",
      "consumoNaFaixa": 10,
      "valorUnitario": 5.50,
      "subtotal": 55.00
    },
    {
      "faixa": "11 a 20",
      "consumoNaFaixa": 5,
      "valorUnitario": 7.80,
      "subtotal": 39.00
    }
  ]
}
```

---

## 🧪 Como Testar a Aplicação

Para executar os testes unitários e de integração, utilize o comando:

```bash
mvn test
```

Os resultados dos testes serão exibidos no console.
