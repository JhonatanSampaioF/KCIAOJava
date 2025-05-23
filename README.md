# KCIAO

## Integrantes
Gustavo Vieira Bargas - Pitch da proposta
</br>
Jhonatan Sampaio Ferreira - Desenvolvimento da aplicação
</br>
Vivian Sy Ting Wu - Desenvolvimento da documentação
</br>
</br>
### Cronograma de Atividades Sprint 1
![Cronograma de Atividades Sprint 1](https://github.com/user-attachments/assets/53763f62-1dc4-4351-bad9-55e38b28ef7d)
</br>
### Cronograma de Atividades Sprint 2
![Cronograma de Atividades Sprint 2](https://github.com/user-attachments/assets/21664f1d-dc8e-4f9d-b843-fa29c3dc5cfa)

---

## Instrução de como rodar a aplicação

### Criação
Para adicionar um novo registro a qualquer tabela, utilize o método POST com a url do domínio desejado e informe um arquivo JSON no corpo da requisição.
</br>
</br>
![POST](https://github.com/user-attachments/assets/b9d1920c-0570-41a0-a965-9d3951d8cf39)
</br>
</br>
O registro que foi criado pode ser recuperado com a URL gerada que leva método de recuperação de um registro com o id deste registro.
</br>
</br>
![GETONEAFTERPOST](https://github.com/user-attachments/assets/b62ed481-f428-4858-9d2d-7fe08d2c8e56)


### Recuperação
#### Um Registro
Para recuperar um registro de qualquer tabela, utilize o método GET com a url do domínio desejado e informe um id válido como parâmetro da requisição.
</br>
</br>
![GETONE](https://github.com/user-attachments/assets/3ebcdb2e-043f-4caa-940b-e406fcc92578)


#### Todos Registros
Para recuperar todos os registros de qualquer tabela, utilize o método GET com a url do domínio desejado.
</br>
</br>
![GETALL](https://github.com/user-attachments/assets/7b507c38-a6c1-412d-b900-9669dafe5219)


### Atualização
Para atualizar um registro a qualquer tabela, utilize o método PATCH com a url do domínio desejado, informe um id válido como parâmetro e um arquivo JSON no corpo da requisição.
</br>
</br>
![PATCH](https://github.com/user-attachments/assets/cf401092-8dc3-419b-99fa-69e0470f6b7b)


### Remoção
Para remover um registro de qualquer tabela, utilize o método DELETE com a url do domínio desejado e informe um id válido como parâmetro da requisição.
</br>
</br>
![DELETE](https://github.com/user-attachments/assets/5f2fac12-eb73-4555-bfa7-7ba8cae70b5e)

---

## Diagramas
### Diagrama de Classe dos domínios
</br>

![Diagrama de Classe](https://github.com/user-attachments/assets/bd0abe16-ffc2-488a-b192-95b25f34e77d)

### Diagrama Entidade Relacionamento
</br>

![Diagrama Entidade Relacionamento](https://github.com/user-attachments/assets/ae628ad2-3d00-4106-8eb6-7ea5ed0e9595)

---

## Pitch apresentação
### [Video Pitch](https://www.youtube.com/watch?v=jUbJweG8XMY)

---

## Apresentação da Aplicação
### [Apresentacao aplicacao](https://youtu.be/gWtCW0d_5qQ)

## Vídeo Apresentação (Sprint 4)
### [Apresentação final Sprint 4](https://www.youtube.com/watch?v=zd22tz-3sYU)
---

## Lista de endpoints
Os endpoints documentados abaixo são funcionais para todos os domínios da aplicação, sendo necessária apenas a alteração da URL correspondente e do corpo da requisição.
</br>
| Domínio | URL |
| :---: | :---: |
| Cliente | /cliente |
| Consulta | /consulta |
| Doença | /doenca |
| Evento | /evento |

### Cliente

| Método | URL |
| :--- | :--- |
| GET (one) | http://localhost:8080/cliente/:idCliente |
| GET (all) | http://localhost:8080/cliente |
| GET (eventos by id) | http://localhost:8080/:idCliente/eventos |
| POST | http://localhost:8080/cliente |
| PATCH | http://localhost:8080/cliente/:idCliente |
| DELETE | http://localhost:8080/cliente/:idCliente |

### Consulta
| Método | URL |
| :--- | :--- |
| GET (one) | http://localhost:8080/consulta/:idConsulta |
| GET (all) | http://localhost:8080/consulta |
| POST | http://localhost:8080/consulta |
| PATCH | http://localhost:8080/consulta/:idConsulta |
| DELETE | http://localhost:8080/consulta/:idConsulta |

### Doença
| Método | URL |
| :--- | :--- |
| GET (one) | http://localhost:8080/doenca/:idDoenca |
| GET (all) | http://localhost:8080/doenca |
| POST | http://localhost:8080/doenca |
| PATCH | http://localhost:8080/doenca/:idDoenca |
| DELETE | http://localhost:8080/doenca/:idDoenca |

### Evento
| Método | URL |
| :--- | :--- |
| GET (one) | http://localhost:8080/evento/:idEvento |
| GET (all) | http://localhost:8080/evento |
| POST | http://localhost:8080/evento |
| PATCH | http://localhost:8080/evento/:idEvento |
| DELETE | http://localhost:8080/evento/:idEvento |

---

## Teste dos endpoints

#### Cliente

##### GET (one)
![image](https://github.com/user-attachments/assets/801423c6-fbf5-407b-8caf-7733c6ee4e97)

##### GET (all)
![image](https://github.com/user-attachments/assets/27f8c2d2-abd3-4a18-8f61-354517bcffde)

##### GET (eventos by id)
![image](https://github.com/user-attachments/assets/60185d5f-a962-4144-9031-aa4d673b7166)

##### POST
![image](https://github.com/user-attachments/assets/863ea3e9-9bfc-4d14-9c80-6dff9f735fd8)

##### PATCH
![image](https://github.com/user-attachments/assets/4be851a5-08d8-4eaa-8da2-50c50892fe2e)

##### DELETE
![image](https://github.com/user-attachments/assets/2896168b-0d96-4873-8136-138cbd198f8c)

#### Consulta

##### GET (one)
![image](https://github.com/user-attachments/assets/7d2583f7-9cac-42e5-849f-876d1a630eb0)

##### GET (all)
![image](https://github.com/user-attachments/assets/723eae97-9539-43ab-9e27-12a6274a6a20)

##### POST
![image](https://github.com/user-attachments/assets/789f356c-fbec-4a92-84f9-01a6847f9546)

##### PATCH
![image](https://github.com/user-attachments/assets/d6a9c0ed-67bf-476b-96fa-704563ef6185)

##### DELETE
![image](https://github.com/user-attachments/assets/6b7d3f25-f04b-49f5-9ba2-753c21c72f13)



#### Doença

##### GET (one)
![GETONE](https://github.com/user-attachments/assets/3ebcdb2e-043f-4caa-940b-e406fcc92578)

##### GET (all)
![GETALL](https://github.com/user-attachments/assets/7b507c38-a6c1-412d-b900-9669dafe5219)

##### POST
![POST](https://github.com/user-attachments/assets/b9d1920c-0570-41a0-a965-9d3951d8cf39)

##### PATCH
![PATCH](https://github.com/user-attachments/assets/cf401092-8dc3-419b-99fa-69e0470f6b7b)

##### DELETE
![DELETE](https://github.com/user-attachments/assets/5f2fac12-eb73-4555-bfa7-7ba8cae70b5e)


#### Evento

##### GET (one)
![image](https://github.com/user-attachments/assets/46382786-8ba3-46ff-8b3c-451aa85af76d)

##### GET (all)
![image](https://github.com/user-attachments/assets/c373cf97-bfec-4443-b697-8f0ae3319bb9)

##### POST
![image](https://github.com/user-attachments/assets/30da0e9c-c4ea-4007-984a-44e12a880002)

##### PATCH
![image](https://github.com/user-attachments/assets/53e2ed3e-2c49-4bb5-aff8-4c63e67e7a4c)

##### DELETE
![image](https://github.com/user-attachments/assets/dbf1b41a-213d-4a58-82d2-315b9eb42f44)


---

## Deploy em WebApp no Azure, utilizando o VS Code

### Pré-requisitos

Certifique-se de que o **Maven** esteja instalado em sua máquina, e que a extensão Azure Tools esteja instalada em seu VS Code.



### Passos para o Deploy

#### 1. Clonar o Repositório

Primeiro, clone este repositório para a sua máquina:

```bash
git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/JhonatanSampaioF/KCIAOJava.git)
cd KCIAOJava
```



#### 2. Crie um WebApp

Abra a extensão do Azure no VS Code, expanda uma subscrição, clique com o botão direito em 'App Services' e clique em 'Create New Web App... (Advanced)':

![image](https://github.com/user-attachments/assets/d5827842-d67f-41ef-ae1a-c1d4d63694c8)


Siga os passos indicados pelo aplicativo para criar um novo WebApp. Ao final, você deve ver algo assim:

![image](https://github.com/user-attachments/assets/5228418e-87de-4466-957d-48b3bad8cc70)



#### 3. Faça um Build do aplicativo

Rode este comando no terminal:

```bash
mvn clean package
```

Isso irá gerar o arquivo .WAR que iremos utilizar para dar o deploy.



#### 4. Faça o deploy do arquivo .WAR na WebApp

Clique com o botão direito sobre o arquivo .WAR gerado dentro da pasta 'target' em seu projeto, e clique em 'Deploy to Web App...'

![image](https://github.com/user-attachments/assets/ef870369-a582-4a5a-bc91-574c164d45b2)



#### 5. Selecione o WebApp que você acabou de criar no passo 2.

Ao final dos passos e após aguardar o deploy, você deve ver algo assim:
![image](https://github.com/user-attachments/assets/319b83aa-c074-4be9-a941-7ddc97c7be76)



#### 6. Testar

Quando terminar, você pode acessar o Web App através de um navegador e testar o aplicativo.

![image](https://github.com/user-attachments/assets/d72478ff-1286-4364-a558-bfda1afd11f8)


---

## Arquitetura

### Abordagem Monolítica
A API foi desenvolvida em **arquitetura monolítica**, justificada por:

| **Vantagem** | **Explicação** |
|--------------|----------------|
| **Baixa Complexidade** | Projeto de baixa complexidade, não gerando necessidade da divisão em microsserviços. |
| **Simplicidade** | Escopo definido e funcionalidades centralizadas. |
| **Custo Reduzido** | Sem necessidade de infraestrutura complexa. |
| **Integração Simplificada** | Comunicação única com o app mobile existente. |
| **Velocidade** | Entrega ágil de MVP para validação do conceito. |
| **Integração Simplificada** | Comunicação única com o frontend mobile, sem utilização de múltiplas apis. |

### Estrutura do Projeto
KCIAOJava/</br>
├── Domains/               # Entidades</br>
├── Gateways/</br>
│   ├── Repositories/      # Acesso a dados</br>
│   └── Controllers/       # Endpoints da API</br>
│   │   └── mvc/ # Mvcs da API</br>
└── Usecases/              # Lógica de negócio</br>

---

### Design Patterns
1. **Repository Pattern**: Utilizado para isolar a lógica de acesso ao banco de dados.
2. **Dependency Injection**: Utilizado para desacoplar componentes e facilitar testes.
