package com.projekt_zespolowy.tablica_ogloszen.utils

import io.restassured.http.ContentType
import static io.restassured.RestAssured.given

trait SecurityTrait {

    def getSecurityToken() {

        Map loginCmd = [
                username: "test",
                password: "test",
        ]
        def response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(loginCmd)
                .when()
                .post("/api/login")
        def token = response.getHeader("Authorization")

        return token
    }

}