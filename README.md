## KCIAO

## Nome completo e breve apresentação dos integrantes do Grupo (atividade da qual ficou responsável no projeto)

Gustavo Vieira Bargas - Pitch da proposta
Jhonatan Sampaio Ferreira - Desenvolvimento da aplicação
Vivian Sy Ting Wu - Desenvolvimento da documentação

## Instrução de como rodar a aplicação
### Criação
#### Para adicionar um novo registro a qualquer tabela, utilize o método POST com a url do domínio desejado e informe um arquivo JSON no corpo da requisição.
Ex.:
![POST](https://github.com/user-attachments/assets/642fbbae-a547-456e-ad6f-88d58a425bb7)


### Recuperação
#### Um Registro
#### Para recuperar um registro de qualquer tabela, utilize o método GET com a url do domínio desejado e informe um id válido como parâmetro da requisição.
Ex.:


#### Todos Registros
#### Para recuperar todos os registros de qualquer tabela, utilize o método GET com a url do domínio desejado.
Ex.:
![GETALL](https://github.com/user-attachments/assets/7b507c38-a6c1-412d-b900-9669dafe5219)


### Atualização
#### Para atualizar um registro a qualquer tabela, utilize o método PATCH com a url do domínio desejado, informe um id válido como parâmetro e um arquivo JSON no corpo da requisição.
Ex.:


### Remoção
#### Para remover um registro de qualquer tabela, utilize o método DELETE com a url do domínio desejado e informe um id válido como parâmetro da requisição.
Ex.:


## imagem dos diagramas
### Diagrama de Classe dos domínios
![Diagrama de Classe](https://github.com/user-attachments/assets/bd0abe16-ffc2-488a-b192-95b25f34e77d)

### Diagrama Entidade Relacionamento

## Pitch apresentação
### youtube

## Lista de Endpoints
### Doença
#### GET (one)
##### http://localhost:8080/doenca/:idDoenca

#### GET (all)
##### http://localhost:8080/doenca

#### POST
##### http://localhost:8080/doenca

#### PATCH
##### http://localhost:8080/doenca/:idDoenca

#### DELETE
##### http://localhost:8080/doenca/:idDoenca
