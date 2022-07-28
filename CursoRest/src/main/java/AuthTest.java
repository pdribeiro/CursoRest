import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.http.ContentType;


public class AuthTest {
	
	@Test
	
	public void deveAcessarSWAPI() {
		
		given()
			.log().all()
		.when()
			.get("https://swapi.dev/api/people/1")
		.then()
			.log().all()
			.statusCode(200)
			.body("name", is("Luke Skywalker"))
		
		;
	}
	
	//
	
	@Test
	
	public void deveObterClima() {
		
		given()
			.log().all()
			.queryParam("q","Fortaleza")
			.queryParam("appid","7122086045f634fddc35e6b6f9c218e0")
			.queryParam("units","metric")
		.when()
			.get("https://api.openweathermap.org/data/2.5/weather")
		.then()
			.log().all()
			.statusCode(200)
			.body("name", is("Fortaleza"))
		;	
		
	}
	
	@Test
	
	public void naoDeveAutenticarSemSenha() {
		
		given()
			.log().all()

		.when()
			.get("https://restapi.wcaquino.me/basicauth")
		.then()
			.log().all()
			.statusCode(401)

		;	
		
	}
	@Test
	
	public void DeveAutenticarComSenha() {
		
		given()
			.log().all()

		.when()
			.get("https://admin:senha@restapi.wcaquino.me/basicauth")
		.then()
			.log().all()
			.statusCode(200)
			.body("status", is("logado"))

		;	
		
	}
	
	@Test
	
	public void DeveAutenticarComSenha2() {
		
		given()
			.log().all()
			.auth().basic("admin", "senha")

		.when()
			.get("https://restapi.wcaquino.me/basicauth")
		.then()
			.log().all()
			.statusCode(200)
			.body("status", is("logado"))

		;	
		
	}
	
	@Test
	
	public void DeveAutenticarComSenhaChallenge() {
		
		given()
			.log().all()
			.auth().preemptive().basic("admin", "senha")

		.when()
			.get("https://restapi.wcaquino.me/basicauth2")
		.then()
			.log().all()
			.statusCode(200)
			.body("status", is("logado"))

		;	
		
	}
	@Test
	
	public void DeveAutenticarComToken() {
		Map<String, String> login = new HashMap<String, String>();
		login.put("email", "pedro@franco");
		login.put("senha", "123456");
		
		//Login na api
		//Receber o token
		String token = given()
			.log().all()
			.body(login)
			.contentType(ContentType.JSON)
		.when()
			.post("https://barrigarest.wcaquino.me/signin")
		.then()
			.log().all()
			.statusCode(200)
			.extract().path("token")

		;	
		
		//Obter conta
	given()
		.log().all()
		.header("Autorization", "JWT " + token)
	.when()
		.get("https://barrigarest.wcaquino.me/contas")
	.then()
		.log().all()
		.statusCode(200)
		;
		
	}
	
	
	
	@Test
	public void deveAcessarAplicacaoWeb() {
		
		//login
		given()
			.log().all()
			.formParam("email", "pedro@franco")
			.formParam("senha", "123456")
			.contentType(ContentType.URLENC.withCharset("UTF-8"))
		.when()
			.post("https://seubarriga.wcaquino.me/logar")
		.then()
			.log().all()
			.statusCode(200)
			.extract().header("set-cookie")
		;
				
	
		//obter conta
		
		
		
	}
	
	


}
