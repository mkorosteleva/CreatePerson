package GPC2;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class createPerson {

    private static String personId;
    private static String programId;


    @BeforeClass
    public void beforeClass() {
/*        RestAssured.requestSpecification requestSpecification = with().
                baseUri("https://demo.api.iaecsp.org/server").
                headers("x-api-key", "uQqITGf7B98dg2pUqqS8v4mN2OfgLqa674qELBMh",
                        "x-program-id", "4f851395-6ae3-4209-8609-93ff7e11d94a",
                        "content-type", "application/json").log().all();
*/

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://demo.api.iaecsp.org/server");
        requestSpecBuilder.addHeader("x-api-key", "");
        requestSpecBuilder.addHeader("x-program-id", "");
        requestSpecBuilder.addHeader("content-type", "application/json");
//        requestSpecBuilder.log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

/*        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();*/



    }

    @Test
    public void createPerson() {
        String payload = "{\n" +
                "    \"program_id\": \"\",\n" +
                "    \"reference\": \"12170502502202023\",\n" +
                "    \"mother_name\": \"Mary\",\n" +
                "    \"title\": \"Ms\",\n" +
                "    \"currency_code\": \"EUR\",\n" +
                "    \"first_name\": \"Laura\",\n" +
                "    \"last_name\": \"Spada\",\n" +
                "    \"birth_date\": \"1977-11-26\",\n" +
                "    \"gender\": \"F\",\n" +
                "    \"mobile_phone\": {\n" +
                "        \"number\": \"76651234111\",\n" +
                "        \"area_code\": \"33\"\n" +
                "    },\n" +
                "    \"personal_identification_number\": \"8456500250506542502\",\n" +
                "    \"email\": \"la522ura@test.comx\",\n" +
                "    \"nationality\": \"ITA\",\n" +
                "    \"primary_address\": {\n" +
                "        \"country_code\": \"IT\",\n" +
                "        \"country_subdivision_code\": \"BG\",\n" +
                "        \"city\": \"Bergamo\",\n" +
                "        \"postal_code\": \"19801-5182\",\n" +
                "        \"line1\": \"71 Sant'Alessandro\",\n" +
                "        \"street_name\": \"Sant'Alessandro\",\n" +
                "        \"street_type\": \"\",\n" +
                "        \"building_number\": \"71\",\n" +
                "        \"unit_number\": \"\"\n" +
                "    },\n" +
                "    \"acceptance\": [\n" +
                "        {\n" +
                "            \"type\": \"TOC\",\n" +
                "            \"accepted_at\": \"2020-12-17T14:15:22Z\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"occupation\": [\n" +
                "        \"ART_ENTERTAINMENT\"\n" +
                "    ],\n" +
                "    \"source_of_funds\": [\n" +
                "        \"HERITAGE\"\n" +
                "    ]\n" +
                "}";


        Response response = with().body(payload).post("/persons/create").then().log().all().extract().response();
        assertThat(response.statusCode(), is(equalTo(200)));
        personId = response.then().extract().jsonPath().getString("person.person_id");
        System.out.println("person id is "+ personId);

    }

/*    @Test
    public void PersonDetails() {
        programId  = "4f851395-6ae3-4209-8609-93ff7e11d94a";

        HashMap<String, String> mainObject = new HashMap<String, String>();
        mainObject.put("program_id", programId);
        mainObject.put("person_id", personId);


        Response response = with().body(mainObject).
                post("/persons/retrieve").then().log().all().extract().response();
        assertThat(response.statusCode(), is(equalTo(200)));

    }*/

}
