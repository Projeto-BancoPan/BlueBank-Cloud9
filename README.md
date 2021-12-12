# Aplicação do BlueBank - Squad Cloud9 

Aplicação construída como trabalho final do curso proporcionado pelo banco Pan e pela Gama Accademy. Foram dois meses intensivos de aulas diárias, com foco em desenvolvimento full stack utilizando Java, Spring Boot, MySql e AWS. O projeto consiste em desenvolver uma solução que simulasse um banco com suas transações. O time foi desafiado a partir de critérios mínimos a serem atendidos a pensar uma solução com as regras negócios a serem seguidas.

## 👨‍💻 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste. A aplicação foi pensada com o objetivo de demonstrar nossos conhecimentos e atender as demandas de um banco digital. Para organização da equipe foi utilizado o quadro KanBan para organização e divisão de tarefas. As etapas do desenolvimento incluiu: levantamento de requisitos, modelagem de dados, desenvolvimento e deploy na AWS.

## &#128752; Levantamento de Requisitos 

### Requisitos Funcionais
 | ID | Descrição de Requisitos | Prioridade |
 |---|---|---|
   | RF-01 | Permitir sacar dinheiro da conta bancária 	 |  Média |
   | RF-02 | Possibilitar transferir dinheiro da conta de um cliente para outro |  Alta |
   | RF-03 | Fazer depósitos na conta bancária |  Alta |
   | RF-04 | Possibilitar exibir os extratos de movimentações bancárias	|  Alta |
   | RF-05 | Possibilitar consultar o saldo da conta da pessoa física |  Alta |
   | RF-06 | Creditar o valor na conta correta de destino. |  Alta |
   | RF-07 | Descontar valor em caso de saque ou transferência.|  Alta |
   | RF-08 | Permitir cadastrar o cliente.|  Alta |
   | RF-09 | Abrir uma conta para o cliente. |  Alta |
   | RF-10 | Possibilitar alterações no cadastro do cliente. |  Alta |
   | RF-11 | Possibilitar excluir cliente do banco de dados. |  Alta |
   | RF-12 | Permitir excluir conta bancária. |  Alta |
   | RF-13 | Guardar log de transações do banco e entre contas. |  Alta |
   | RF-14 | Exibir transações de uma conta.  |  Alta |
   | RF-15 | Possibilitar fazer aplicações em investimentos	|  Baixa |
   | RF-16 | Possibilitar fazer transferência com outros bancos |  Baixa |
   | RF-17 | Possibilitar realizar pagamento de boletos e outros títulos bancários |  Alta |
   | RF-18 | Realizar autenticação de usuário de funcionário do banco |  Baixa |
   | RF-19 | Testes automatizados, podem ser testes unitários ou testes de integração |  Média |

### Requisitos não funcionais
A tabela a seguir apresenta os requisitos não funcionais que o projeto deverá atender.
   | ID | Descrição de Requisitos | Prioridade |
   |---|---|---|
   | RNF-01 | A aplicação deve ter um pipeline em Jenkins ou no Aws Build.	 |  Média |
   | RNF-02 | A aplicação precisa ser configurada no API Gateway da AWS. |  Alta |
   | RNF-03 | A aplicação precisa ter no mínimo um endpoint de SNS para cadastro de emails e verificação automática. |  Alta |
   | RNF-04 |A aplicação precisa ter no mínimo um Lambda.	|  Alta |
   | RNF-05 |A aplicação conterá documentação de endpoints no swagger	|  Alta |
 
 ### Modelagem de Dados
 ![WhatsApp Image 2021-12-12 at 17 01 55](https://user-images.githubusercontent.com/64924032/145727985-f7137342-7a24-4a5f-8e2a-7a26a257e94e.jpeg)
### Estrutura de Dados

O sistema foi construído com as seguintes estruturas de dados:

##### Cliente:
```
{
  "contaCorrenteModel": {
    "agencia": "AGENCIA1",
    "conta": 0,
    "dataDeAbertura": "2021-12-12T18:36:48.273Z",
    "dataDeEncerramento": "2021-12-12T18:36:48.273Z",
    "saldoDaConta": 0
  },
  "email": "string",
  "enderecoModel": {
    "bairro": "string",
    "cep": "string",
    "cidade": "string",
    "complemento": "string",
    "estado": "AM",
    "idEndereco": 0,
    "logradouro": "string",
    "numero": 0
  },
  "idCliente": 0,
  "nome": "string",
  "renda": 0,
  "telefone": "string",
  "tipoCliente": "PESSOAFISICA"
}
```

##### Conta Corrente:
```
{
  "agencia": "AGENCIA1",
  "conta": 0,
  "dataDeAbertura": "2021-12-12T18:36:48.391Z",
  "dataDeEncerramento": "2021-12-12T18:36:48.391Z",
  "saldoDaConta": 0
}
```

##### Transações:
```
[
  {
    "agencia": "AGENCIA1",
    "conta": 0,
    "transacoesFeitas": [
      {
        "dataDaTransacao": "2021-12-12T18:36:48.418Z",
        "numeroDaTransacao": 0,
        "tipoDeTransacao": "PAGAMENTO",
        "valorDaTransacao": 0
      }
    ],
    "transacoesRecebidas": [
      {
        "dataDaTransacao": "2021-12-12T18:36:48.418Z",
        "numeroDaTransacao": 0,
        "tipoDeTransacao": "PAGAMENTO",
        "valorDaTransacao": 0
      }
    ]
  }
]
```

##### Endereços:
```
{     "idEndereco": 0,
      "bairro": "string",
      "cep": "string",
      "cidade": "string",
      "complemento": "string",
      "estado": "AM",
      "logradouro": "string",
      "numero": 0
    },

```




## 📋 Pré-requisitos

Para executar o código foi utilzada a IDE ItelliJ e/ou Eclipse as linguagens Java, Spring e MySQL. É necessário possuir uma IDE que execute a aplicação springboot para teste de em repositório local. Na execução do projeto também foram utilizados Workbench MySQL, xampp, Dbeaver, Swagger e algum navegador de sua preferência.



## 🔧 Instalação

O código foi desenvolvido em Java utilizando o Framework SpringBoot com algumas dependências específicas baseada em maven.

Para iniciar, instale o itelliJ versão community:

```
https://www.jetbrains.com/pt-br/idea/download/#section=windows
```

Você deverá selecionar a importação do projeto utilizando a opção Maven Build.
Antes de executar a instalação, você deverá executar algum servidor local utilizando algum pacote ou IDE desenvolvedora de banco de dados. 
Ao fazer a instação das dependências, você deverá executar a aplicação com spring, para que ela possa ser executada. 
Algumas funções como lambda, pipeline em Aws Build e o deploy elastic beanstalk não podem ser reproduzidas ou vistas em servidor local, porém a serviço ANS sim, desde que se modifique as variáveis de ambiente ACCESS_KEy, SEcurity Key e ARN por credenciais AWS válidas.

Para acessar o banco de dados de forma local pode-se utilizar duas opções:
A documentação Swagger UI acessando o link:

```
http://localhost:5000/swagger-ui.html
```

Ou mesmo poderá utilizar alguma API CLient como a utilizada em desenvolvimento: Postman.
Para o instalar acesse:
```
https://www.postman.com/
```

Então, para acessar o banco de dados, é necessário acessar os endpoints que esta configurados no caminho abaixo e listados mais abaixo:
```
http://localhost:5000
```
## 📦 Desenvolvimento

Esse código é uma alternativa para  aplicação bancária back-end com foco em construção de banco de dados de base de cliente e transações. Essa não é a unica forma de se realizar essa tarefa, além de sempre ser possívle a revisão por pares para que ele apresente novas funcionalidades e se torne mais limpos e performáticos.

## 🔌	Endpoints
Para acessar o banco de dados, é necessário acessar os endpoints que esta configurados no caminho abaixo + url do caminho nas tabelas:
```
http://localhost:5000
```
#### Cliente
| Tipo | Descrição | Caminho |
   |---|---|---|
|PUT|Atualiza os dados de um cliente|/api/cliente/atualizar/{idCliente}|
|GET|Retorna o cliente pelo id somente com os contatos|/api/cliente/contato/{idCliente}|
|DELETE|Atualiza os dados de um cliente|/api/cliente/deletar/{idCliente}|
|GET|Atualiza os dados de um cliente|Retorna o cliente pelo id somente com o endereço|
|GET|Retorna uma lista de todos os clientes|/api/cliente/listar|
|POST|Salva um novo cliente|/api/cliente/salvar|
|GET|Retorna uma lista de clientes pelo tipo|/api/cliente/tipo/{tipoCliente}|
|GET|Retorna uma lista de clientes pelo tipo com endereços e contato|/api/cliente/tipo_filtro/{tipoCliente}|
|GET|Retorna um cliente pelo id|/api/cliente/{idCliente}|


#### Contas
| Tipo | Descrição | Caminho |
   |---|---|---|
|PUT|Atualiza os dados de um cliente|/api/conta_corrente/atualizar|
|GET|Listar todas as contas|/api/conta_corrente/listar|
|GET|Localiza o cliente pelo número da conta|/api/conta_corrente/{conta}|

#### Transações
| Tipo | Descrição | Caminho |
   |---|---|---|
|POST|Efetuar um depósito|/api/transacao/depositar/{conta_de_destino}/{valor_transacao}|
|GET|Retorna uma lista com todas as transacoes|/api/transacao/listar|
|POST|Efetuar um pagamento|/api/transacao/pagar/{conta_de_origem}/{valor_transacao}|
|POST|Efetua uma transferência para outra conta|/api/transacao/pagar/{conta_de_origem}/{valor_transacao}|
|POST|Efetuar um pagamento|/api/transacao/transferir/{conta_de_origem}/{valor_transacao}/{conta_de_destino}|
|GET|Retorna uma lista com todas as transacoes do cliente|/api/transacao/{conta_de_origem}|


## ☁️ Demais Instalações:

* Lambda: O arquivo lambda se encontra no arquivo bluebank-lambda.zip, para configurá-lo não é necessário extraí-lo. Basta entrar np serviço AWS lambda com uma conta válida e configurar como na documentação que segue: https://docs.aws.amazon.com/pt_br/lambda/latest/dg/configuration-function-zip.html
* Script SQL: 





## 🛠️ Construído com


* [IntelliJ](https://www.jetbrains.com/pt-br/idea/download/#section=windows) - IDE para desenvolvimento em Java 
* [Java v. 11](https://www.java.com/pt-BR/) - GLinguagem para desenvolvimento multiplataforma
* [SpringBoot](https://spring.io/projects/spring-boot) - Framework Java com o objetivo de se construir aplicações REST
* [Swagger](https://swagger.io/tools/swagger-ui/) - Ferramenta de documentação visual de endpoints de aplicações
* [AWS Lambda](https://aws.amazon.com/pt/lambda/?nc2=type_a) - Serviço da AWS com arquitetura Serveless
* [AWS Elastic beanstalks](https://aws.amazon.com/pt/elasticbeanstalk/) - Serviço de implantação e escalabilidade de aplicações 
* [AWS Build](https://aws.amazon.com/pt/codebuild/) - Serviço de integração Contínua
* [AWS SNS](https://aws.amazon.com/pt/sns/?whats-new-cards.sort-by=item.additionalFields.postDateTime&whats-new-cards.sort-order=desc) - Serviço de mensageria
* [AWS API Gateway](https://aws.amazon.com/pt/api-gateway/) - Serviço de publicação e gerenciamento de API
* [PostMan](https://www.postman.com/) - Plataforma de desenvolvimento de API.
* [DBeaver](https://dbeaver.io/download/) - Plataforma de banco de dados OpenSource e universal.
* [MySQL](https://www.mysql.com/downloads/) - Sistema de Gerenciamento de Banco de Dados.
* [WorkBench](https://dev.mysql.com/downloads/workbench/) - Plataforma para SGDB MySQL.






## ✒️ Autores


* **João Pedro Marques Mourão** - *Desenvolvimento e Scrum Master* - [Github](https://github.com/joaopedro-marques)
* **Leandro de Barros** - *Desenvolvimento* - [Github](https://github.com/leandrobarr)
* **Luiz Nascimento da Silva** - *Desenvolvimento* - [Github](https://github.com/luizns)
* **Marcel Eduardo Vicaria Pinotti** - *Desenvolvimento e Tech Lead* - [Github](https://github.com/marcelpinotti)




## 🎁 Expressões de gratidão


* Agradecemos nossos professores Jenifer, Ana e Jonathan que nos auxiliaram e ensinaram como executar este projeto complexo.
* Agradecemos a Gama por possibilitar uma ementa e estrutura tão boas para execução do trabalho e aprendizado.
* Agradecemos a parceria do Banco Pan em mentorias, além de possibilitarem a execução do curso.


---
Read me adaptado de:
[Armstrong Lohãns](https://gist.github.com/lohhans) 😊
