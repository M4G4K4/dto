package com.korber.dto.trip;

import com.korber.dto.BaseIT;
import com.korber.dto.model.comom.TripType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TripIT extends BaseIT {

    @Test
    void getYellowList() {
        given()
                .get("/trip/list-yellow")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("items[0].id", equalTo(200),
                        "items[0].pickupAt", notNullValue(),
                        "items[0].dropOffAt", notNullValue(),
                        "items[0].pickUpZone", equalTo("East Village"),
                        "items[0].dropOffZone", equalTo("UN/Turtle Bay South"),
                        "items[0].type", equalTo(TripType.YELLOW.name()));
    }

    @Test
    void getYellowListQueryParameterDefaultValues() {
        given()
                .get("/trip/list-yellow")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("page", equalTo(1),
                        "perPage", equalTo(10),
                        "total", equalTo(100),
                        "totalPages", equalTo(10),
                        "items", hasSize(10));
    }

    @Test
    void getYellowListQueryParameterUserValues() {
        given()
                .get("/trip/list-yellow?page=5&perPage=20&order=id")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("page", equalTo(5),
                        "perPage", equalTo(20),
                        "total", equalTo(100),
                        "totalPages", equalTo(5),
                        "items", hasSize(20));
    }

}
