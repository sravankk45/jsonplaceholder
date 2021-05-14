package com.typicode.jsonplaceholder.jsonplaceholderoperations;

import static io.restassured.RestAssured.given;


/**
 *  This class provides implementations of operations that can be performed on users 
 *  like getting user data by user name
 */
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
