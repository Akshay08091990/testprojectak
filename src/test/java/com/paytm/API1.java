package com.paytm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class API1 extends Base {

	@Test
	public void statusCode() throws JSONException {

		Assert.assertEquals(responseCode, 200, "status code is correct");

	}

	@Test
	public void MovieReleaseDate() throws JSONException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 0);

		String todayDate = simpleDateFormat.format(cal.getTime());
		Date d1 = null;
		try {
			d1 = simpleDateFormat.parse(todayDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < jarray.length(); i++) {
			String releaseDate = jarray.getJSONObject(i).getString("releaseDate");
			Date d2 = null;
			try {
				d2 = simpleDateFormat.parse(releaseDate);

				if (d1.compareTo(d2) <= 0) {
					Assert.assertEquals(d1.compareTo(d2) <= 0, true);
				} else {
					Assert.assertEquals(d1.compareTo(d2) <= 0, false);
				}

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

	}

	@Test
	public void moviePosterImage() throws JSONException {
		for (int i = 0; i < jarray.length(); i++) {
			String moviePoster = jarray.getJSONObject(i).getString("moviePosterUrl");
			if (moviePoster.contains(".jpg")) {
				Assert.assertEquals(moviePoster.contains(".jpg"), true);
			} else {
				Assert.assertEquals(moviePoster.contains(".jpg"), false);

			}

		}

	}

	@Test
	public void paytmMovieCode() throws JSONException {

		List a = new ArrayList();
		Set s = new HashSet();

		for (int i = 0; i < jarray.length(); i++) {
			String movieCode = jarray.getJSONObject(i).getString("paytmMovieCode");

			a.add(movieCode);
			s.add(movieCode);
		}
		if (a.size() == s.size()) {
			Assert.assertEquals(a.size() == s.size(), true);
		} else {
			Assert.assertEquals(a.size() == s.size(), false);
		}

	}

	@Test
	public void language() throws JSONException {

		for (int i = 0; i < jarray.length(); i++) {
			String language = jarray.getJSONObject(i).getString("language");
			String string = language;
			String[] parts = string.split(",");
			if (parts.length == 1) {
				Assert.assertEquals(parts.length == 1, true);

			} else {
				Assert.assertEquals(parts.length == 1, false);

			}

		}

	}
}
