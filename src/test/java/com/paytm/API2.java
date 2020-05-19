package com.paytm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API2 extends Base{

	@Test
	public void WritetoFile() throws JSONException, IOException {
	File file = new File("test.txt");
	FileWriter fr = new FileWriter(file, true);
	BufferedWriter br = new BufferedWriter(fr);
	Date date = new Date();

	for (int i = 0; i < jarray.length(); i++) {
		int isContentAvailable = 	jarray.getJSONObject(i).getInt("isContentAvailable");
		String movieName = jarray.getJSONObject(i).getString("movie_name");
		if  ((isContentAvailable) ==0) {
	
	try {
		br.write(date.toString());
		br.write(" --- ");
		br.write(movieName);
		br.write("\n");
		
	} catch (Exception e) {
		System.out.println(e);
	}
		}
	}
	br.close();
	fr.close();
	}
}

