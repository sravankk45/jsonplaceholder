package com.typicode.jsonplaceholder.jsonplaceholderoperations;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class PostOperations {
	
public Response getUserPosts(int userId) {
		
		return given()
				  .header("content-type","application/json")
				  .queryParam("userId",userId)
				  .when()
				  .get("posts").then()
				  .extract().response();
	}

}
