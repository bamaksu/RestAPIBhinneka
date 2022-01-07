package restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class updateUser {
    @Test
    public void update_user (){
        String url = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName", "Nami");
        request.put("lastName", "Chan");
        request.put("email", "nami_chan@gmail.com");


        RestAssured.baseURI = url;
        Response hasilResponse = (Response) ((ValidatableResponse)
                ((Response)
                        RestAssured
                                .given()
                                .urlEncodingEnabled(true)
                                .body(request.toString())
                                .header("Content-Type", "application/json")
                                .when()
                                .put("/users/4"))
                        .then())
                .extract()
                .response();

        int statusCode = hasilResponse.getStatusCode();
        System.out.println("Status code = " + hasilResponse.getStatusCode());
        Assert.assertEquals(statusCode, 200);
        System.out.println("Response Body = " + hasilResponse.asString());

    }
}
