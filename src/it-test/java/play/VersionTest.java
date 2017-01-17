package play;

import com.jayway.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class VersionTest {

    private static final String SERVICE_URL = "http://localhost:8080/api";

    @Test
    public void addGetDeleteNote() {

        // Get
        given().
                contentType(ContentType.JSON).
                when().
                get(SERVICE_URL + "/manage/info").
                then().
                statusCode(200).
                body("version", Matchers.is("IT-TEST"));
    }

}
