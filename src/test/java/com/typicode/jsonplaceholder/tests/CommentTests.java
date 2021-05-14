package com.typicode.jsonplaceholder.tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typicode.jsonplaceholder.base.TestBase;
import com.typicode.jsonplaceholder.jsonplaceholderoperations.CommentOperations;
import com.typicode.jsonplaceholder.jsonplaceholderoperations.PostOperations;
import com.typicode.jsonplaceholder.jsonplaceholderoperations.UserOperations;
import com.typicode.jsonplaceholder.pojo.comment.CommentPojo;
import com.typicode.jsonplaceholder.pojo.post.PostPojo;
import com.typicode.jsonplaceholder.pojo.user.UserPojo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommentTests extends TestBase implements ITest {
	
	private Response response;
	private JsonPath jsonResponse;
	private ObjectMapper mapper;
	private List<UserPojo> user;
	private List<PostPojo> posts;
	private List<CommentPojo> postComments;
	private List<CommentPojo> comments;
	private UserOperations userOperations;
	private PostOperations postOperations;
	private CommentOperations commentOperations;
	private ThreadLocal<String> testName = new ThreadLocal<String>();
	
	/**
	 *  Gets the Base URI before test suite runs
	 */
	@BeforeSuite
	public void setBaseUri() {

		RestAssured.baseURI = getBaseUri();

	}
	
	/**
	 *  generates comments data of all posts by user
	 */
	@BeforeTest
	public void createTestInputData() {
		
		int userId;
		int postId;

		userOperations = new UserOperations();
		postOperations = new PostOperations();
		commentOperations = new CommentOperations();
		comments = new ArrayList<CommentPojo>();
		
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		response = userOperations.getUserByUserName("Kamren");
		try {
			user = Arrays.asList(mapper.readValue(response.asPrettyString(), UserPojo[].class));
		}
		catch(JsonMappingException e) {
			e.printStackTrace();
		}
		catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		for(UserPojo user : user) {
			
			userId=user.getId();
			response = postOperations.getUserPosts(userId);
			
		}
		
		try {
			posts = Arrays.asList(mapper.readValue(response.asPrettyString(), PostPojo[].class));
		}
		catch(JsonMappingException e) {
			e.printStackTrace();
		}
		catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		for(PostPojo post : posts) {
			
			postId=post.getId();
			response = commentOperations.getCommentsByPostId(postId);
			try {
				postComments = Arrays.asList(mapper.readValue(response.asPrettyString(), CommentPojo[].class));
			}
			catch(JsonMappingException e) {
				e.printStackTrace();
			}
			catch(JsonProcessingException e) {
				e.printStackTrace();
			}
			
			comments.addAll(postComments);
		}
	
	}
	
	/**
	 *  Modifies the test name for each comment test data with comment id
	 */
	@BeforeMethod
	public void BeforeMethod(Method method, Object[] testData){
	   testName.set(method.getName() + "_CommentId");
	   
	}
	
	/**
	 *  returns the modified test name
	 */
	public String getTestName() {
	   return testName.get();
	}
	
	@DataProvider(name = "comments")
	   public Object[] commentIdsData() {
	
			int commentId;
			Object []commentIds=new Object[comments.size()];
			int i=0;
			for(CommentPojo comment:comments) {

				commentId = comment.getId();
				commentIds[i] = commentId;
				i++;
				
			}
			return commentIds;
	     
	     }
	
	/**
	 *  Test verifies  the comment email of each post by user
	 */
	@Test(dataProvider = "comments")
	public void verifyEmailTest(int commentId) {

		commentOperations = new CommentOperations();
		comments = new ArrayList<CommentPojo>();
		
		response = commentOperations.getCommentById(commentId);
		jsonResponse = new JsonPath(response.asString());
		
		List<String> commentEmailList = jsonResponse.get("email");
		
		String ePattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		
		for(String commentEmail: commentEmailList) {
			
	           Pattern p = java.util.regex.Pattern.compile(ePattern, Pattern.CASE_INSENSITIVE);
	           Matcher m = p.matcher(commentEmail);
	           Assert.assertTrue(m.matches());
		}
		
	
	}

}
