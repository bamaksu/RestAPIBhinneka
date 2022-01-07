package restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class comment {
    @Test
    public void list_user () {
        String url = "http://localhost:3000";


        RestAssured.baseURI = url;
        Response hasilResponse = (Response) ((ValidatableResponse)
                ((Response)
                        RestAssured
                                .given()
                                .urlEncodingEnabled(true)
                                .header("Content-Type", "application/json")
                                .get("/comments"))
                        .then())
                .extract()
                .response();

        int statusCode = hasilResponse.getStatusCode();
        System.out.println("Status code = " + hasilResponse.getStatusCode());
        Assert.assertEquals(statusCode, 200);
        System.out.println("Response Body = " + hasilResponse.asString());
    }
}
