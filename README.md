# KCIAO

Gustavo Vieira Bargas - Pitch da proposta
</br>
Jhonatan Sampaio Ferreira - Desenvolvimento da aplicação
</br>
Vivian Sy Ting Wu - Desenvolvimento da documentação
</br>
![Cronograma de Atividades](https://github.com/user-attachments/assets/53763f62-1dc4-4351-bad9-55e38b28ef7d)



## Instrução de como rodar a aplicação
### Criação
Para adicionar um novo registro a qualquer tabela, utilize o método POST com a url do domínio desejado e informe um arquivo JSON no corpo da requisição.
</br>
![POST](https://github.com/user-attachments/assets/642fbbae-a547-456e-ad6f-88d58a425bb7)


### Recuperação
#### Um Registro
Para recuperar um registro de qualquer tabela, utilize o método GET com a url do domínio desejado e informe um id válido como parâmetro da requisição.
</br>
![GETONE](https://github.com/user-attachments/assets/3ebcdb2e-043f-4caa-940b-e406fcc92578)


#### Todos Registros
Para recuperar todos os registros de qualquer tabela, utilize o método GET com a url do domínio desejado.
</br>
![GETALL](https://github.com/user-attachments/assets/7b507c38-a6c1-412d-b900-9669dafe5219)


### Atualização
Para atualizar um registro a qualquer tabela, utilize o método PATCH com a url do domínio desejado, informe um id válido como parâmetro e um arquivo JSON no corpo da requisição.
</br>
![PATCH](https://github.com/user-attachments/assets/cf401092-8dc3-419b-99fa-69e0470f6b7b)



### Remoção
Para remover um registro de qualquer tabela, utilize o método DELETE com a url do domínio desejado e informe um id válido como parâmetro da requisição.
</br>
![DELETE](https://github.com/user-attachments/assets/5f2fac12-eb73-4555-bfa7-7ba8cae70b5e)



## Diagramas
### Diagrama de Classe dos domínios
</br>

![Diagrama de Classe](https://github.com/user-attachments/assets/bd0abe16-ffc2-488a-b192-95b25f34e77d)

### Diagrama Entidade Relacionamento
</br>

![Diagrama Entidade Relacionamento](https://github.com/user-attachments/assets/ae628ad2-3d00-4106-8eb6-7ea5ed0e9595)


## Pitch apresentação
### [Video Pitch](https://www.youtube.com/watch?v=jUbJweG8XMY)

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
