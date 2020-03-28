package br.com.cotacoes.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CotacoesRestTest {
	
	@Test
    public void testAdd() {
        given()
                .body("{\"dataRequisicao\": \"23-03-2020\", "
                		+ "\"dataCotacao\": \"21-03-2020\", "
                		+ "\"cotacaoCompra\" : \"3.55\", "
                		+ "\"cotacaoVenda\" : \"3.66\", "
                		+ "\"dataHoraCotacao\" : \"21-03-2020 13:13:00\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/cotacoes/salvar")
                .then()
                .statusCode(201)
                .body("$.size()", is(2),
                		"cotacaoCompra", containsInAnyOrder("3.46", "3.55"),
                        "cotacaoVenda", containsInAnyOrder("3.47", "3.66"));

        given()
                .body("{\"dataRequisicao\": \"23-03-2020\", "
		        		+ "\"dataCotacao\": \"22-03-2020\", "
		        		+ "\"cotacaoCompra\" : \"3.54\", "
		        		+ "\"cotacaoVenda\" : \"3.56\", "
		        		+ "\"dataHoraCotacao\" : \"22-03-2020 13:13:00\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/fruits")
                .then()
                .statusCode(201)
                .body("$.size()", is(3),
                		"cotacaoCompra", containsInAnyOrder("3.46", "3.55", "3.54"),
                        "cotacaoVenda", containsInAnyOrder("3.47", "3.66", "3.56"));
    }
	
	@Test
    public void testFindAll() {
        given()
                .when()
                .get("/cotacoes/listar")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                		"cotacaoCompra", containsInAnyOrder("3.46", "3.55", "3.54"),
                        "cotacaoVenda", containsInAnyOrder("3.47", "3.66", "3.56"));
	}

	@Test
    public void testFindByDataRequisicao() {
		given() 
		        .body("{\"dataRequisicao\": \"19-02-2020\"}")
		        .when()
		        .get("/cotacoes/listar/pordatarequisicao")
		        .then()
		        .statusCode(200)
		        .body("$.size()", is(1),
		        		"cotacaoCompra", containsInAnyOrder("3.46"),
		                "cotacaoVenda", containsInAnyOrder("3.47"));
        given() 
                .body("{\"dataRequisicao\": \"23-03-2020\"}")
                .when()
                .get("/cotacoes/listar/pordatarequisicao")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                		"cotacaoCompra", containsInAnyOrder("3.55", "3.54"),
                        "cotacaoVenda", containsInAnyOrder("3.66", "3.56"));        
    }
	
	@Test
    public void testFindByDataCotacao() {
		given() 
		        .body("{\"dataCotacao\": \"19-02-2020\"}")
		        .when()
		        .get("/cotacoes/listar/pordatacotacao")
		        .then()
		        .statusCode(200)
		        .body("$.size()", is(1),
		        		"cotacaoCompra", containsInAnyOrder("3.46"),
		                "cotacaoVenda", containsInAnyOrder("3.47"));
		
		given()
                .body("{\"dataCotacao\": \"21-03-2020\"}")
                .when().get("/cotacoes/listar/pordatacotacao")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                		"cotacaoCompra", containsInAnyOrder("3.4567"),
                        "cotacaoVenda", containsInAnyOrder("3.4678"));
        given()
                .body("{\"dataCotacao\": \"22-03-2020\"}")
		        .when().get("/cotacoes/listar/pordatacotacao/{dataCotacao}")
		        .then()
		        .statusCode(200)
		        .body("$.size()", is(1),
		        		"cotacaoCompra", containsInAnyOrder("3.5567"),
                        "cotacaoVenda", containsInAnyOrder("3.6678"));
    }
}
