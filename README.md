# Restful APIs Employees B2W
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE) 

# Diagrama da base de dados
![Base 1](https://github.com/davijuvino/digital/blob/main/assets/diagrama_base.png)

## Tecnologias utilizadas
## APIs
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Mysql
- Containerizing Java Applications with Jib
- Docker
- OpenAPI Specification
- mockito junit 5

# Como executar o projeto

## Docker-compose
Pré-requisitos: Java 11 /Docker /Docker-compose

```bash
# clonar repositório
git clone https://github.com/davijuvino/digital.git

# entrar na pasta do projeto api
cd employees.b2w.digital

# executar o projeto
docker-compose up -d
```

## Documentacao OPENAPI
![Doc 1](https://github.com/davijuvino/digital/blob/main/assets/OpenApi.png)

## Containerizing images no DockerHub
![Docker 1](https://github.com/davijuvino/digital/blob/main/assets/dockerhub.png)
## Imagem no repository dockerhub
- Comando para realizar o pull da imagem
```bash
# clonar repositório
docker pull davijuvino/springboot-b2w
```
## Containerizing Java Applications with Jib
![Jib 1](https://github.com/davijuvino/digital/blob/main/assets/jib_container.png)
```bash
# Containerizing em segundos
```

## Postman executando dos endponits
![Postman](https://github.com/davijuvino/digital/blob/main/assets/postman_api.jpg)
```bash
# Exemplo Table Trilha
```
```bash
# Table Trilha Post - http://localhost:8080/api/v1/trilhas
{
    "trilha_nome":"Projetos",
    "diretoria":"TI",
    "missao_formal":"Implantacao digital",
    "missao_alternativa":"Analisar implantar e definir soluções",
    "cargos": [
                {  
                    "cargo_nome": "Analista de Implantacao I",
                    "cargo_missao": "Analisar e implantar novas soluções",
                    "data_atualizacao": "2021-05-01 20:35:02"
                }
        ],
    "data_atualizacao": "2020-05-11 20:03:53"   
}
```
```bash
# Exemplo Table Cargo
```
```bash
# Table Cargo Post - http://localhost:8080/api/v1/cargos/36
{
    "cargo_nome": "Analista Cloud Senior 5",
    "cargo_missao": "Atuar naimplantação e manutenção de sistemas gerando logicamente as\naplicações informatizadas, apoiando a concepção, estabelecendo o fluxo e os procedimentos.",
    "data_atualizacao": "2020-05-11 17:03:53"
}
```
## Tests com JUnit5
![Junit](https://github.com/davijuvino/digital/blob/main/assets/junit_mockito.jpg)
## Source
 ![Test](https://github.com/davijuvino/digital/blob/main/assets/Tests.png)


