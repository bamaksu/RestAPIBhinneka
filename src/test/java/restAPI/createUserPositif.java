package restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class createUserPositif {
    @Test
    public void create_user (){
        String url = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName", "Nico");
        request.put("lastName", "Robin");
        request.put("email", "robin@gmail.com");

        RestAssured.baseURI = url;
        Response hasilResponse = (Response) ((ValidatableResponse)
                ((Response)
                        RestAssured
                                .given()
                                .urlEncodingEnabled(true)
                                .header("Content-Type", "application/json")
                                .body(request.toString())
                                .when()
                                .post("/users"))
                        .then())
                .extract()
                .response();

        int statusCode = hasilResponse.getStatusCode();
        System.out.println("Status code = " + hasilResponse.getStatusCode());
        Assert.assertEquals(statusCode, 201);
        System.out.println("Response Body = " + hasilResponse.asString());

    }
}
