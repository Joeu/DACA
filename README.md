App: http://projetodirlididi-dacaufcg2016.rhcloud.com/
Jenkins: https://projetodirlididijenkins-dacaufcg2016.rhcloud.com/

** Testes executados com o comando: mvn test a partir do diretório onde o arquivo pom.xml se encontra. **

API - Dirlididi

---- GET /init povoa os dados ----

===== PROBLEM CONTROLLER =====

GET

    /problem - Retorna os problemas do sistema
    /problem/id - Retorna um problema específico
    /problem/id/solution - Retorna as soluções de um problema
    /problem/id/solution/id - Retorna uma solução específica
    /problem/id/test - Retorna os testes de um problema
    /problem/id/test/id - Retorna um teste específico

POST

    /problem - Cria novo problema
    /problem/id/solution - Usuário posta solução para o problema
    /problem/id/test - Cria novo teste para um problema

DELETE

    /problem/id - Deleta um problema específico
    /problem/id/solution/id - Deleta uma solução específica
    /problem/id/test/id - Deleta um teste específico


PUT - PATCH

    /problem/id - Edita um problema específico
    /problem/id/solution/id - Edita uma solução específica
    /problem/id/test/id - Edita um teste específico

===== USER CONTROLLER =====

GET

    /user - Retorna os usuários de um sistema
    /user/id - Retorna um usuário específico
    /user/id/solution - Retorna as soluções de um usuário
    /user/id/solution/id - Retorna solução específica

DELETE

    /user/id - Deleta um usuário específico

POST

    /user/ - Cria um usuário

PUT - PATCH

    /user/id - Edita um usuário específico

