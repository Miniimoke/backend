package HomeWork_3;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class ExampleTest extends AbstractTest {

    @Test
    void getTestSearch_1() {

        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .queryParam("diet", "vegetarian")
                .queryParam("includeIngredients", "cheese")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("totalResults"), equalTo(13));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .queryParam("diet", "vegetarian")
                .queryParam("includeIngredients", "cheese")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2500L));

    }

    @Test
    void getTestSearch_2() {

        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .queryParam("intolerances", "Gluten, Shellfish")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(10));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .queryParam("intolerances", "Gluten, Shellfish")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2500L));

    }

    @Test
    void getTestSearch_3() {

        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .queryParam("equipment", "blender, frying pan, bowl")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(10));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .queryParam("equipment", "blender, frying pan, bowl")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2500L));

    }

    @Test
    void getTestSearch_4() {

        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .queryParam("excludeIngredients", "flour, eggs")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(10));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .queryParam("excludeIngredients", "flour, eggs")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2500L));

    }

    @Test
    void getTestSearch_5() {

        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("offset"), equalTo(0));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "American")
                .when()
                .get(getBaseUrl()+"recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2500L));

    }

    @Test
    void getTestCuisine_1() {

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Ratatouille Pasta")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(2000L));

    }

    @Test
    void getTestCuisine_2() {

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Baked Ratatouille")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(2000L));

    }

    @Test
    void getTestCuisine_3() {

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Roasted Ratatouille Gratin")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(2000L));

    }

    @Test
    void getTestCuisine_4() {

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Crock Pot Shredded French Dip")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(2000L));

    }

    @Test
    void getTestCuisine_5() {

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Ratatouille")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(2000L));

    }

}