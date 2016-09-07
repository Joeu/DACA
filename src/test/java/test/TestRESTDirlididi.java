package test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.Application;


@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest("server.port=0")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRESTDirlididi {
    
    @Value("${local.server.port}")
    private int port;

    
    //Testes do Controller Problem
    
    /**
     * Metodo que verifica o retorno dos problemas
     * @throws Exception
     */
    @Test
    public void getProblems() throws Exception {
   	 given()
   			 .param("nome", "matheus")
   			 .param("teste", "oi")
   	 .when()
   			 .port(this.port)
   			 .get("/hello")
   	 .then()
   	 		 .assertThat().statusCode(is(200)).body("Mensagem", is("Problemas retornados com sucesso"));
    }
    
    /**
     * Metodo que verifica o retorno de um problema especifico
     * @throws Exception
     */
    @Test
    public void getProblemById() throws Exception {
   	 given()
   			 .param("id", "1")
   	 .when()
   			 .port(this.port)
   			 .get("/problem/id")
   	 .then()
   			 .assertThat().statusCode(is(200)).body("name", is("Prob1"));
    }
    
    /**
     * Metodo que verifica o retorno das soluções de um problema
     * @throws Exception
     */
    @Test
    public void getSolutionsProblem() throws Exception {
    	
      given()
      	.param("id", '1')
	 .when()
			 .port(this.port)
			 .get("/problem/id/solution")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Soluções retornadas com sucesso"));
    }
    
    /**
     * Metodo que verifica o retorno de uma solução especifica de um problema
     * @throws Exception
     */
    @Test
    public void getSolutionProblemById() throws Exception {
    	
      given()
      	.param("idProblem", '1')
      	.param("idSolution", '1')
	 .when()
			 .port(this.port)
			 .get("/problem/idProblem/solution/idSolution")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Solução retornada com sucesso"));
    }
    
    /**
     * Metodo que verifica o retorno dos testes
     * @throws Exception
     */
    @Test
    public void getTests() throws Exception {
   	 given()
   			 .param("id", "1")
   	 .when()
   			 .port(this.port)
   			 .get("/problem/id/test")
   	 .then()
   			 .assertThat().statusCode(is(200)).body("Mensagem", is("Testes da solução retornados com sucesso"));
    }
    
    /**
     * Metodo que verifica o retorno de um teste especifico
     * @throws Exception
     */
    @Test
    public void getTestById() throws Exception {
   	 given()
   			 .param("id_user", "1")
   			 .param("id_teste", "1")
   	 .when()
   			 .port(this.port)
   			 .get("/problem/id_user/test/id_test")
   	 .then()
   			 .assertThat().statusCode(is(200))
   			 .body("Input", is("2"))
   			 .body("Output", is("4"))
   			 .body("Mensagem", is("Teste da solução retornado com sucesso"));
    }
    
    /**
     * Metodo que verifica o envio de um problema
     * @throws Exception
     */
    @Test
    public void addProblem() throws Exception {
    	final File file = new File(getClass().getClassLoader()
    		      .getResource("questao1.txt").getFile());
    		  assertNotNull(file);
    		  assertTrue(file.canRead());
    		  given().
    		    multiPart(file).	
    		  when().
    		  post("/problem").then()
    			 .assertThat().statusCode(is(200))
    			 .body("Mensagem", is("Problema criado com sucesso"));
    }
    
    /**
     * Metodo que verifica o envio de uma solução para o problema
     * @throws Exception
     */
    @Test
    public void addProblemSolution() throws Exception {
    		  given()
    		    .param("idProblem", "1")
    		  .when().
    		  post("/problem/idProblem/solution").then()
    			 .assertThat().statusCode(is(200))
    			 .body("Mensagem", is("Solução postada com sucesso"));
    }
    
    /**
     * Metodo que verifica o envio de uma teste para o problema
     * @throws Exception
     */
    @Test
    public void addProblemTest() throws Exception {
    		  given()
    		    .param("idProblem", "1")
    		  .when().
    		  post("/problem/idProblem/test").then()
    			 .assertThat().statusCode(is(200))
    			 .body("Mensagem", is("Teste criado com sucesso"));
    }
    
    /**
     * Metodo que verifica a remoção de um problema
     * @throws Exception
     */
    @Test
    public void deleteProblem() throws Exception {
    	
      given()
			 .param("id", "1")
	 .when()
			 .port(this.port)
			 .delete("/problem/id")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Problema deletado com sucesso"));
    }
    
    /**
     * Metodo que verifica a remoção de uma solução de um problema
     * @throws Exception
     */
    @Test
    public void deleteProblemSolution() throws Exception {
    	
      given()
			 .param("idProblem", "1")
			 .param("idSolution", "1")
	 .when()
			 .port(this.port)
			 .delete("/problem/idProblem/solution/idSolution")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Solução deletada com sucesso"));
    }
    
    /**
     * Metodo que verifica a remoção de um teste de um problema
     * @throws Exception
     */
    @Test
    public void deleteProblemTest() throws Exception {
    	
      given()
			 .param("idProblem", "1")
			 .param("idTest", "1")
	 .when()
			 .port(this.port)
			 .delete("/problem/idProblem/test/idTest")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Teste deletado com sucesso"));
    }
    
    /**
     * Metodo que verifica a edição de um problema
     * @throws Exception
     */
    @Test
    public void editProblem() throws Exception {
    	final File file = new File(getClass().getClassLoader()
    		      .getResource("questao1.txt").getFile());
    		  assertNotNull(file);
    		  assertTrue(file.canRead());
    		  given().
    		    multiPart(file).
    		    param("id", "1").
    		  when().
    		  put("/problem/id").then()
    			 .assertThat().statusCode(is(200))
    			 .body("Mensagem", is("Problema Editado com sucesso"));
    }
    
    /**
     * Metodo que verifica a edição de uma solução de um problema
     * @throws Exception
     */
    @Test
    public void editProblemSolution() throws Exception {
    	
    		  given()
    		    .param("idProblem", "1")
    		    .param("idSolution", "1").
    		  when().
    		  put("/problem/idProblem/solution/idSolution").then()
    			 .assertThat().statusCode(is(200))
    			 .body("Mensagem", is("Solução editada com sucesso"));
    }
    
    /**
     * Metodo que verifica a edição de um teste um problema
     * @throws Exception
     */
    @Test
    public void editProblemTest() throws Exception {
    	
    		  given()
    		    .param("idProblem", "1")
    		    .param("idTest", "1").
    		  when().
    		  put("/problem/idProblem/test/idTest").then()
    			 .assertThat().statusCode(is(200))
    			 .body("Mensagem", is("Solução editada com sucesso"));
    }
    
    //Testes dos metodos do User (GET, POST, DELETE e PUT)
    
    /**
     *Teste que verifica o retorno dos usuários 
     * @throws Exception
     */
    @Test
    public void getUsers() throws Exception {
   	 given()
   	 .when()
   			 .port(this.port)
   			 .get("/user")
   	 .then()
   			 .assertThat().statusCode(is(200)).body("Mensagem", is("Usuários retornados com sucesso"));
    }
    
    /**
     * Metodo que verifica o retorno de um usuário especifico.
     * @throws Exception
     */
    @Test
    public void getUserById() throws Exception {
   	 given()
   	 	.param("id", "1")
   	 .when()
   			 .port(this.port)
   			 .get("/user/id")
   	 .then()
   			 .assertThat().statusCode(is(200)).body("name", is("Pablo")).body("Mensagem", is("Usuário Retornado com sucesso"))
   			 .body("email",is("pherivelton@gmail.com"))
   			 .body("password", is("123456"));
    }
    
    /**
     * Metodo que verifica o retorno das soluções do usuario
     * @throws Exception
     */
    @Test
    public void getSolutionsUser() throws Exception {
    	
      given()
      	.param("id", '1')
	 .when()
			 .port(this.port)
			 .get("/user/id/solution")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Soluções do usuário retornadas com sucesso"));
    }
    
    /**
     * Metodo que verifica o retorno de uma solução especifica do usuário
     * @throws Exception
     */
    @Test
    public void getSolutionUser() throws Exception {
    	
      given()
      	.param("idUser", '1')
      	.param("idSolution", '1')
	 .when()
			 .port(this.port)
			 .get("/user/idUser/solution/idSolution")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Solução retornada com sucesso"));
    }
    
    /**
     * Metodo que verifica a remoção de um usuário
     * @throws Exception
     */
    @Test
    public void deleteUser() throws Exception {
    	
      given()
			 .param("id", "1")
	 .when()
			 .port(this.port)
			 .delete("/user/id")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Usuario deletado com sucesso"));
    }
    
    /**
     * Metodo que verifica a adição de um usuário
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception {
    	
      given()
	 .when()
			 .port(this.port)
			 .post("/user")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Usuario cadastrado com sucesso"));
    }
    
    /**
     * Metodo que verifica a edição de um usuário
     * @throws Exception
     */
    @Test
    public void editUser() throws Exception {
    		  given().
    		  param("id", "1").
    		  when().
    		  put("/user/id").then()
    			 .assertThat().statusCode(is(200))
    			 .body("Mensagem", is("Usuário Editado com sucesso"));
    }

}