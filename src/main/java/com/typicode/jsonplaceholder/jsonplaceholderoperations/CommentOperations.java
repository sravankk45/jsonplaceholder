package com.typicode.jsonplaceholder.jsonplaceholderoperations;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

/**
 *  This class provides implementations of operations that can be performed on Comments 
 *  like getting comments by post id
 *  and getting comments by comment id
 */
public class CommentOperations {
	
	public Response getCommentsByPostId(int postId) {
		
		return given()
				  .header("content-type","application/json")
				  .queryParam("postId",postId)
				  .when()
				  .get("comments").then()
				  .extract().response();
	}
	
	public Response getCommentById(int commentId) {
		
		return given()
				  .header("content-type","application/json")
				  .queryParam("id",commentId)
				  .when()
				  .get("comments").then()
				  .extract().response();
	}


}
