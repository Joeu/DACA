App: http://projetodirlididi-dacaufcg2016.rhcloud.com/
Jenkins: https://projetodirlididijenkins-dacaufcg2016.rhcloud.com/

** Testes executados com o comando: mvn test a partir do diret�rio onde o arquivo pom.xml se encontra. **

API - Dirlididi

---- GET /init povoa os dados ----

===== PROBLEM CONTROLLER =====

GET

    /problem - Retorna os problemas do sistema
    /problem/id - Retorna um problema espec�fico
    /problem/id/solution - Retorna as solu��es de um problema
    /problem/id/solution/id - Retorna uma solu��o espec�fica
    /problem/id/test - Retorna os testes de um problema
    /problem/id/test/id - Retorna um teste espec�fico

POST

    /problem - Cria novo problema
    /problem/id/solution - Usu�rio posta solu��o para o problema
    /problem/id/test - Cria novo teste para um problema

DELETE

    /problem/id - Deleta um problema espec�fico
    /problem/id/solution/id - Deleta uma solu��o espec�fica
    /problem/id/test/id - Deleta um teste espec�fico


PUT - PATCH

    /problem/id - Edita um problema espec�fico
    /problem/id/solution/id - Edita uma solu��o espec�fica
    /problem/id/test/id - Edita um teste espec�fico

===== USER CONTROLLER =====

GET

    /user - Retorna os usu�rios de um sistema
    /user/id - Retorna um usu�rio espec�fico
    /user/id/solution - Retorna as solu��es de um usu�rio
    /user/id/solution/id - Retorna solu��o espec�fica

DELETE

    /user/id - Deleta um usu�rio espec�fico

POST

    /user/ - Cria um usu�rio

PUT - PATCH

    /user/id - Edita um usu�rio espec�fico

