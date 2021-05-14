package com.typicode.jsonplaceholder.jsonplaceholderoperations;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

/**
 *  This class provides implementations of operations that can be performed on Posts 
 *  like getting Posts by user id
 */
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
