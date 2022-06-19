package org.petApi.utility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class RestServices {

//    String requestBody = "{\n" +
//            "  \"id\": 15,\n" +
//            "  \"category\": {\n" +
//            "    \"id\": 0,\n" +
//            "    \"name\": \"NiravGoyani\"\n" +
//            "  },\n" +
//            "  \"name\": \"doggie\",\n" +
//            "  \"photoUrls\": [\n" +
//            "    \"string\"\n" +
//            "  ],\n" +
//            "  \"tags\": [\n" +
//            "    {\n" +
//            "      \"id\": 0,\n" +
//            "      \"name\": \"string\"\n" +
//            "    }\n" +
//            "  ],\n" +
//            "  \"status\": \"available\"\n" +
//            "}";

    public String readJsonFile() throws IOException {
        byte[] b = Files.readAllBytes(Paths.get("src/test/resources/payload.json"));

        String bdy = new String(b);
        return bdy;
    }

    public Response postService() throws IOException {
        return given().contentType(ContentType.JSON)
                .header("Content-type", "application/json")
                .and()
                .body(readJsonFile())
                .when()
                .post("/pet");
    }

    public Response getService(){
        return given().contentType(ContentType.JSON)
                .when()
                .get("/pet/133");
    }

    public Response deleteService(){
       return given().contentType(ContentType.JSON)
               .when()
               .delete("/pet/15");
    }

}
