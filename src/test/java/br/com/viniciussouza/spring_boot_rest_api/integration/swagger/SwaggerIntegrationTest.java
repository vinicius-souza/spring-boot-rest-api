package br.com.viniciussouza.spring_boot_rest_api.integration.swagger;

import br.com.viniciussouza.spring_boot_rest_api.config.TestConfigs;
import br.com.viniciussouza.spring_boot_rest_api.integration.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTest extends AbstractIntegrationTest {

	@Test
	void shouldDisplaySwaggerUIPage() {
		assertTrue(given()
			.basePath("/swagger-ui/index.html")
			.port(TestConfigs.SERVER_PORT)
			.when()
			.get()
			.then()
			.statusCode(200)
			.extract()
			.body()
			.asString()
			.contains("Swagger UI"));
	}

}
