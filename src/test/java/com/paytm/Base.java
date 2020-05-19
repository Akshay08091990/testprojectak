package com.paytm;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	
	public String responseBody;
	public JSONObject jobject ;
	public JSONArray jarray;
	public int responseCode;
	
	@BeforeClass
	public void setup() throws JSONException {
		RestAssured.baseURI = "https://apiproxy.paytm.com/v2/movies/upcoming";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "");
		responseBody = response.getBody().asString();
		 responseCode = response.getStatusCode();
		 jobject = new JSONObject(responseBody);
		 jarray = jobject.getJSONArray("upcomingMovieData");
	}
}
