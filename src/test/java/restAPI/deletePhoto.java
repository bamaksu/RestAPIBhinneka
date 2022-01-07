package restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deletePhoto {
    @Test
    public void delete_photo (){
        String url = "http://localhost:3000";


        RestAssured.baseURI = url;
        Response hasilResponse = (Response) ((ValidatableResponse)
                ((Response)
                        RestAssured
                                .given()
                                .urlEncodingEnabled(true)
                                .header("Content-Type", "application/json")
                                .when()
                                .delete("/photos/5"))
                        .then())
                .extract()
                .response();

        int statusCode = hasilResponse.getStatusCode();
        System.out.println("Status code = " + hasilResponse.getStatusCode());
        Assert.assertEquals(statusCode, 200);
        System.out.println("Response Body = " + hasilResponse.asString());



    }
}
