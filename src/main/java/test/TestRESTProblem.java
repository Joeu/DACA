package test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import controller.Application;

@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest("server.port=0")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRESTProblem {
    
    @Value("${local.server.port}")
    private int port;

    @Test
    public void getProblems() throws Exception {
   	 given()
   			 .param("nome", "matheus")
   			 .param("teste", "oi")
   	 .when()
   			 .port(this.port)
   			 .get("/hello")
   	 .then()
   			 .assertThat().statusCode(is(200));
    }
    
    @Test
    public void getProblemById() throws Exception {
   	 given()
   			 .param("id", "1")
   	 .when()
   			 .port(this.port)
   			 .get("/problem/id")
   	 .then()
   			 .assertThat().statusCode(is(200)).body("name", is("Questao 1"));
    }
    
    @Test
    public void sendProblem() throws Exception {
    	final File file = new File(getClass().getClassLoader()
    		      .getResource("questao1.txt").getFile());
    		  assertNotNull(file);
    		  assertTrue(file.canRead());
    		  given().
    		    multiPart(file).	
    		  when().
    		  post("/problem").then()
    			 .assertThat().statusCode(is(200))
    			 .body("Mensagem", is("Problema Enviado com sucesso"));
    }
    
    @Test
    public void deleteProblem() throws Exception {
    	
      given()
			 .param("id", "1")
	 .when()
			 .port(this.port)
			 .delete("/problem/id")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Problema Deletado"));
    }
    
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
    
    @Test
    public void getTests() throws Exception {
   	 given()
   			 .param("id", "1")
   	 .when()
   			 .port(this.port)
   			 .get("/problem/id/test")
   	 .then()
   			 .assertThat().statusCode(is(200)).body("Titulo", is("Questao 1"));
    }
    
    @Test
    public void getTestById() throws Exception {
   	 given()
   			 .param("id_user", "1")
   			 .param("id_teste", "1")
   	 .when()
   			 .port(this.port)
   			 .get("/problem/id_user/test/id_test")
   	 .then()
   			 .assertThat().statusCode(is(200)).
   			 body("Input", is("0"))
   			 .body("Output", is("2"));
    }
    
    @Test
    public void getUsers() throws Exception {
   	 given()
   	 .when()
   			 .port(this.port)
   			 .get("/user")
   	 .then()
   			 .assertThat().statusCode(is(200));
    }
    
    @Test
    public void getUserById() throws Exception {
   	 given()
   	 	.param("id", "1")
   	 .when()
   			 .port(this.port)
   			 .get("/user/id")
   	 .then()
   			 .assertThat().statusCode(is(200)).body("name", is("Pablo"))
   			 .body("email",is("pherivelton@gmail.com"))
   			 .body("type", is("admin"));
    }
    
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
    
    @Test
    public void addUser() throws Exception {
    	
      given()
	 .when()
			 .port(this.port)
			 .delete("/user")
	 .then()
			 .assertThat().statusCode(is(200)).body("Mensagem", is("Usuario adicionado com sucesso"));
    }
    
    @Test
    public void getSolutionsUser() throws Exception {
    	
      given()
      	.param("id", '1')
	 .when()
			 .port(this.port)
			 .delete("/user/id/solutions")
	 .then()
			 .assertThat().statusCode(is(200));
    }

}
