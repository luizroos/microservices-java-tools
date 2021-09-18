package com.example.orderservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.example:productservice:+:stubs:8090")
public class OrderServiceControllerIntegrationTest {

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void given_shouldReturnProduct_rest() throws Exception {
		ResponseEntity<String> responseEntity = restTemplate
				.getForEntity("http://127.0.0.1:8090/v1/productservice/product/1", String.class);
		assertEquals(responseEntity.getBody(), "{\"id\":1,\"price\":10.0,\"description\":\"Product 1\"}");
	}

}
