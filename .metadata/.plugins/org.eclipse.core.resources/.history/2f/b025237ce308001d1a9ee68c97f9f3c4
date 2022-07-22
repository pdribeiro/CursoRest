import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.http.ContentType;


public class VerbosTest {

	@Test	
	
	public void deveSalvarUsuario() {
		
		given()
			.log().all()
			.contentType("application/json")
			.body("{\"name\":\"Jose\", \"age\": 50}")
		
		.when()
			.post("https://restapi.wcaquino.me/users")
		.then()
			.log().all()
			.statusCode(201)
			.body("id", is(notNullValue()))
			.body("name",is("Jose"))
			.body("age",is("50"))

		;
		
		
	}
	
	@Test
	
	public void naoDeveSalvarUsuarioSemnome() {
		
		given()
		.log().all()
		.contentType("application/json")
		.body("\"age\": 50}")
	
	.when()
		.post("https://restapi.wcaquino.me/users")
	.then()
		.log().all()
		.statusCode(400)
		.body("id", is(nullValue()))
		.body("error", is("Houve algum problema no tratamento do seu XML"))
		;
		
	}
	@Test
	
	public void deveSalvarUsuarioXML() {
		
		given()
			.log().all()
			.contentType(ContentType.XML)
			.body("	<user><name>Pedro</name><age>30</age></user>")
		
		.when()
			.post("https://restapi.wcaquino.me/usersXML")
		.then()
			.log().all()
			.statusCode(201)
			.body("user.id", is(notNullValue()))
			.body("user.name",is("Pedro"))
			.body("user.age",is("30"))


		;
		
		
	}
	@Test
	
	public void AlterarUsuario() {
		
		given()
		.log().all()
		.contentType(ContentType.JSON)
		.body("{\"name\":\"User alterado\", \"age\": 80}")
	
	.when()
		.put("https://restapi.wcaquino.me/users/1")
	.then()
		.log().all()
		.statusCode(200)
		.body("id", is(1))
		.body("name",is("User alterado"))
		.body("age",is(80))
		.body("salary",is(1234.5678f))


	;
		
		
	}
	@Test
	
	public void devoCustomizarUrl() {
		
		given()
		.log().all()
		.contentType(ContentType.JSON)
		.body("{\"name\":\"User alterado\", \"age\": 80}")
	
	.when()
		.put("https://restapi.wcaquino.me/{entidade}/{userid}", "users","1")
	.then()
		.log().all()
		.statusCode(200)
		.body("id", is(1))
		.body("name",is("User alterado"))
		.body("age",is(80))
		.body("salary",is(1234.5678f))


	;
		
		
	}
	
	@Test
	
	public void devoCustomizarUrl2() {
		
		given()
		.log().all()
		.contentType(ContentType.JSON)
		.body("{\"name\":\"User alterado\", \"age\": 80}")
		.pathParam("entidade", "users")
		.pathParam("userid", "1")

	
	.when()
		.put("https://restapi.wcaquino.me/{entidade}/{userid}")
	.then()
		.log().all()
		.statusCode(200)
		.body("id", is(1))
		.body("name",is("User alterado"))
		.body("age",is(80))
		.body("salary",is(1234.5678f))


	;
		
		
	}
	
	@Test
	
	public void deveRemoverUsuario() {
		
		given()
			.log().all()
		.when()
			.delete("https://restapi.wcaquino.me/users/1")
		.then()
			.log().all()
			.statusCode(204)

		
		;
	}
	
	@Test
	public void naoDeveRemoverUsuario() {
		
		given()
			.log().all()
		.when()
			.delete("https://restapi.wcaquino.me/users/1000")
		.then()
			.log().all()
			.statusCode(400)
			.body("error", is("Registro inexistente"))
		
		;
	}
	@Test
	
	public void deveSalvarUsuarioMap() {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("name","Usuario via map");
		params.put("age", 25);
		
		given()
			.log().all()
			.contentType("application/json")
			.body(params)
		
		.when()
			.post("https://restapi.wcaquino.me/users")
		.then()
			.log().all()
			.statusCode(201)
			.body("id", is(notNullValue()))
			.body("name",is("Usuario via map"))
			.body("age",is(25))

		;
		
		
	}
	
}

