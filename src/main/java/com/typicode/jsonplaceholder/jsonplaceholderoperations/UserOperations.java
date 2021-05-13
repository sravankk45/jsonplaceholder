package com.typicode.jsonplaceholder.jsonplaceholderoperations;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class UserOperations {
	
	public Response getUserByUserName(String userName) {
		
		return given()
				  .header("content-type","application/json")
				  .queryParam("username",userName)
				  .when()
				  .get("users").then()
				  .extract().response();
	}

}
