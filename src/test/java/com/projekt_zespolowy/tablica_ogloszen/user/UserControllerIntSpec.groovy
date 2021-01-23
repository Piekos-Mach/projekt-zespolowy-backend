package com.projekt_zespolowy.tablica_ogloszen.user

import com.projekt_zespolowy.tablica_ogloszen.controllers.error.RequestBodyValidationHandler
import com.projekt_zespolowy.tablica_ogloszen.utils.SecurityTrait
import io.restassured.RestAssured
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.http.Header
import io.restassured.module.mockmvc.RestAssuredMockMvc
import io.restassured.response.Response
import org.hamcrest.Matcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.TestPropertySource
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import spock.lang.Unroll

import static io.restassured.RestAssured.given
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.not

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SqlGroup([
//        @Sql(scripts = ["classpath:sql/data.sql"], executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//])
@TestPropertySource(locations = "classpath:application.properties")
//@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
class UserControllerIntSpec extends Specification implements SecurityTrait {

    @LocalServerPort
    private int localServerPort

    @Autowired
    private WebApplicationContext webApplicationContext

    @Autowired
    private RequestBodyValidationHandler methodArgumentNotValidExceptionHandler

    private String jwtToken

    void setup() {

        RestAssured.port = localServerPort
        RestAssuredMockMvc.standaloneSetup(webApplicationContext, methodArgumentNotValidExceptionHandler)
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
        jwtToken = this.getSecurityToken()
    }

    @Unroll
    void "create user passes"() {
        given:
        Map createUserCmd = [
                name    : name,
                password: password,
                mail    : mail
        ]

        when:
        Response result = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", jwtToken))
                .body(createUserCmd)
                .when()
                .post("/api/users")

        then:
        result.then().statusCode(statusCode)
        result.then().body("id", not(null))

        where:
        testName || name       || password       || mail            || statusCode || jsonResponse
        "dobry1" || "testName" || "testPassword" || "test@test.com" || 200        || ""
    }

    @Unroll
    void "create user not passes"() {
        given:
        Map createUserCmd = [
                name    : name,
                password: password,
                mail    : mail
        ]


        when:
        Response result = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", jwtToken))
                .body(createUserCmd)
                .when()
                .post("/api/users")

        then:
        result.then().statusCode(statusCode)
        if (statusCode == 409) {
            result.body().print().contains("EntityNotFoundException")
        } else {
            result.then().body(jsonResponse[0] as String, jsonResponse[1] as Matcher<?>)
        }


        where:
        testName         || name       || password       || mail            || statusCode || jsonResponse
        "blank name"     || ""         || "testPassword" || "test@test.com" || 400        || ["name", equalTo(["Nazwa nie może być pusta"])]
        "null name"      || null       || "testPassword" || "test@test.com" || 400        || ["name", equalTo(["Nazwa nie może być pusta"])]
        "blank password" || "testName" || ""             || "test@test.com" || 400        || ["password", equalTo(["Hasło nie może być puste"])]
        "null password"  || "testName" || null           || "test@test.com" || 400        || ["password", equalTo(["Hasło nie może być puste"])]
        "blank mail"     || "testName" || "testPassword" || ""              || 400        || ["mail", equalTo(["Adres mail nie może być pusty"])]
        "null mail"      || "testName" || "testPassword" || null            || 400        || ["mail", equalTo(["Adres mail nie może być pusty"])]
    }

    @Unroll
    void "update user passes"() {
        given:
        Map cmd = [
                id      : id,
                name    : name,
                password: password,
                mail    : mail
        ]

        when:
        Response result = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", jwtToken))
                .body(cmd)
                .when()
                .post("/api/users")

        then:
        result.then().statusCode(statusCode)
        result.then().body("id", not(null))

        where:
        testName || id || name       || password       || mail            || statusCode || jsonResponse
        "dobry1" || 1L || "testName" || "testPassword" || "test@test.com" || 200        || ""
    }

    @Unroll
    void "update user not passes"() {
        given:
        Map cmd = [
                id         : id,
                name       : name,
                newPassword: newPassword,
                oldPassword: oldPassword,
                mail       : mail
        ]


        when:
        Response result = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", jwtToken))
                .body(cmd)
                .when()
                .put("/api/users")

        then:
        result.then().statusCode(statusCode)
        if (statusCode == 409) {
            result.body().print().contains("EntityNotFoundException")
        } else {
            result.then().body(jsonResponse[0] as String, jsonResponse[1] as Matcher<?>)
        }


        where:
        testName         || id      || name       || newPassword    || oldPassword   || mail            || statusCode || jsonResponse
        "id null"        || null    || ""         || "testPassword" || "oldPassword" || "test@test.com" || 400        || ["id", equalTo(["Wymagana encja nie istnieje"])]
        "id 0"           || 0L      || null       || "testPassword" || "oldPassword" || "test@test.com" || 400        || ["id", equalTo(["Wymagana encja nie istnieje"])]
        "id -1"          || -1L     || null       || "testPassword" || "oldPassword" || "test@test.com" || 400        || ["id", equalTo(["Wymagana encja nie istnieje"])]
        "id 999999"      || 999999L || null       || "testPassword" || "oldPassword" || "test@test.com" || 400        || ["id", equalTo(["Wymagana encja nie istnieje"])]
        "blank name"     || 1L      || ""         || "testPassword" || "oldPassword" || "test@test.com" || 400        || ["name", equalTo(["Nazwa nie może być pusta"])]
        "null name"      || 1L      || null       || "testPassword" || "oldPassword" || "test@test.com" || 400        || ["name", equalTo(["Nazwa nie może być pusta"])]
        "blank password" || 1L      || "testName" || ""             || "oldPassword" || "test@test.com" || 400        || ["newPassword", equalTo(["Hasło nie może być puste"])]
        "null password"  || 1L      || "testName" || null           || "oldPassword" || "test@test.com" || 400        || ["newPassword", equalTo(["Hasło nie może być puste"])]
        "blank password" || 1L      || "testName" || "newPassword"  || ""            || "test@test.com" || 400        || ["oldPassword", equalTo(["Hasło nie może być puste"])]
        "null password"  || 1L      || "testName" || "newPassword"  || null          || "test@test.com" || 400        || ["oldPassword", equalTo(["Hasło nie może być puste"])]
        "blank mail"     || 1L      || "testName" || "testPassword" || "oldPassword" || ""              || 400        || ["mail", equalTo(["Adres mail nie może być pusty"])]
        "null mail"      || 1L      || "testName" || "testPassword" || "oldPassword" || null            || 400        || ["mail", equalTo(["Adres mail nie może być pusty"])]
    }

    @Unroll
    void "delete user passes"() {
        given:
        Map cmd = [
                id: id
        ]

        when:
        Response result = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", jwtToken))
                .body(cmd)
                .when()
                .post("/api/users/d")

        then:
        result.then().statusCode(statusCode)

        where:
        testName || id || statusCode || jsonResponse
        "dobry1" || 1L || 200        || ""
    }

    @Unroll
    void "delete user not passes"() {
        given:
        Map cmd = [
                id         : id
        ]


        when:
        Response result = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", jwtToken))
                .body(cmd)
                .when()
                .post("/api/users/d")

        then:
        result.then().statusCode(statusCode)
        if (statusCode == 409) {
            result.body().print().contains("EntityNotFoundException")
        } else {
            result.then().body(jsonResponse[0] as String, jsonResponse[1] as Matcher<?>)
        }


        where:
        testName         || id       || statusCode || jsonResponse
        "id null"        || null     || 400        || ["id", equalTo(["Wymagana encja nie istnieje"])]
        "id 0"           || 0L       || 400        || ["id", equalTo(["Wymagana encja nie istnieje"])]
        "id -1"          || -1L      || 400        || ["id", equalTo(["Wymagana encja nie istnieje"])]
        "id 999999"      || 999999L  || 400        || ["id", equalTo(["Wymagana encja nie istnieje"])]
    }

}
