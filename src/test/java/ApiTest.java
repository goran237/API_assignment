import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTest {

    @Test
    public void verifyApiCall(){
        RestAssured
                .given()
                .when()
                .header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .body(new Gson()
                        .toJson(new RegisterUser()
                                .withEmail("eve.holt@reqres.in")
                                .withPassword("pistol")))
                .log()
                .all()
                .post("https://reqres.in/api/register")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("id",is(equalTo(4)))
                .body("token",is(equalTo("QpwL5tke4Pnpja7X4")));
    }

}
