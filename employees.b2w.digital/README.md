# Restful APIs Employees B2W 
<p align="left">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/tgmarinho/README-ecoleta?color=%2304D361">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/tgmarinho/README-ecoleta">

  <a href="https://www.twitter.com/tgmarinho/">
    <img alt="Siga no Twitter" src="https://img.shields.io/twitter/url?url=https%3A%2F%2Fgithub.com%2Ftgmarinho%2FREADME-ecoleta">
  </a>
  
  <a href="https://github.com/tgmarinho/README-ecoleta/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/tgmarinho/README-ecoleta">
  </a>
    
   <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
   <a href="https://github.com/tgmarinho/README-ecoleta/stargazers">
    <img alt="Stargazers" src="https://img.shields.io/github/stars/tgmarinho/README-ecoleta?style=social">
  </a>
</p>

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
![Base 1](https://github.com/davijuvino/digital/blob/main/assets/docker-java.png)
## Docker-compose
Pré-requisitos: Java 11 /Docker /Docker-compose

```bash
# clonar repositório
git clone https://github.com/davijuvino/digital.git

# entrar na pasta do projeto api
cd employees.b2w.digital

# executar o projeto
docker-compose up -d

# parar e remover projeto
docker-compose down -v

# deletar e remover projeto
docker system prune -a
```

## Documentacao OPENAPI
![Doc 1](https://github.com/davijuvino/digital/blob/main/assets/OpenApi.png)
```bash
Documentação oficial: https://swagger.io/solutions/getting-started-with-oas/
Projeto: http://localhost:8080/swagger-ui.html
```
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
## Tests com JUnit5 e Mockito
## Source
 ![Test](https://github.com/davijuvino/digital/blob/main/assets/Tests.png)


## 📝 Licença
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE)
Este projeto esta sobe a licença [MIT](./LICENSE).
