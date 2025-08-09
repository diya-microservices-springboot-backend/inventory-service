package com.diya.microservices.inventory;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;


@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.1.0");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://" + mySQLContainer.getHost();
        RestAssured.port = 8082;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void ShouldAddInventory() {

        log.info("AddInventory response: {}", mySQLContainer.getContainerIpAddress());
        log.info("AddInventory response: {}", mySQLContainer.getFirstMappedPort());
        log.info("AddInventory response: {}", mySQLContainer.getHost());

        var submitData = "{\n" +
                "    \"skuCode\": \"SKU-11\",\n" +
                "    \"quantity\": 299\n" +
                "}";

        var responseBodyString = RestAssured.given()
                .contentType("application/json")
                .body(submitData)
                .when()
                .post("/api/inventory/add")
                .then()
                .log()
                .all()
                .statusCode(201)
                .extract()
                .body()
                .asString();

        log.info("AddInventory response: {}", responseBodyString);

        assertThat(responseBodyString, Matchers.containsString("{\"id\":20,\"skuCode\":\"SKU-11\",\"quantity\":299}"));
    }

}
