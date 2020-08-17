# people-register
API de cadastro de Pessoas, com operações de cadastro, alteração, remoção e consulta. 

API pode ser acessada através de um projeto front-end desenvolvido em ReactJS. Para acessar <a href="https://github.com/kevinzamperetti/people-register-ui" target="_blank">clique aqui</a>.

Para rodar ambos os projetos, na pasta raiz deste projeto possui um docker-compose.yml, basta baixá-lo e executar o comando: *docker-compose up -d* e acessar através de *http://localhost:3000/*

*Documentação da API através do Swagger. Acessar através da URL abaixo:*
- http://localhost:8080/swagger-ui.html#/

*API criada utilizando o Bando de Dados H2. Se necessário, acessar através da URL abaixo*:
- http://localhost:8080/h2/
- *Driver Class:* org.h2.Driver
- *JDBC URL:* jdbc:h2:file:./database/people.db
- *User Name:* sa

Após aplicaçao estar rodando:
- Você será direcionado a uma tela inicial. Onde poderá acessar o source do projeto e realizar a autenticação. 
- O usuário e senha de autenticação utilizando o protocolo Basic é a mesma para os dois: admin
- Após será direcionado a tela que poderá executar as operações de listar, cadastrar, alterar e excluir.
- Clicando no botão sair, retorna a tela inicial.

Obs.:
Disponibilizada as imagens tanto do projeto de back-end e front-end no Docker Hub. 
Abaixo os comandos para rodá-los em seprados, *sem utilizar* o docker-compose:

*Back-end:*
docker run -p 8080:8080 -it zamperetti/people-register

*Front-end:*
docker run -it -p 3000:3000 -d -e REACT_APP_API_URL=http://localhost:8080 zamperetti/people-register-ui
