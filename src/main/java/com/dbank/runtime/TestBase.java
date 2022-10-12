package com.dbank.runtime;

import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public String callWebService(String type, String url, String headers, String Body) {
		String response = "";

		try {
			if (type.equalsIgnoreCase("get")) {
				RestAssured.baseURI = url;
				RequestSpecification httpRequest = RestAssured.given();
				httpRequest.header(headers.split("=")[0], headers.split("=")[1]);
				Response responseObj = httpRequest.request(Method.GET, "");
				if (responseObj.getStatusCode() == 200) {
					response = responseObj.getStatusLine();
					Reporter.log("Response is : " + response);
				} else {
					throw new RuntimeException("Error Occured. Response Code : " + responseObj.getStatusCode());
				}
				return response;
			} else if (type.equalsIgnoreCase("post")) {
				return response;
			} else if (type.equalsIgnoreCase("put")) {
				return response;
			} else {
				throw new RuntimeException("No such type : " + type);
			}

		} catch (Exception e) {
			throw e;
		}

	}

	public void validateStatusCode(String type, String url, String headers, String Body, String expectedStatusCode) {
		try {
			if (type.equalsIgnoreCase("get")) {
				RestAssured.baseURI = url;
				RequestSpecification httpRequest = RestAssured.given();
				httpRequest.header(headers.split("=")[0], headers.split("=")[1]);
				Response responseObj = httpRequest.request(Method.GET, "");
				if (responseObj.getStatusCode() == Integer.parseInt(expectedStatusCode)) {
					Reporter.log("Response is : " + responseObj.getStatusLine());
				} else {
					throw new RuntimeException("Error Occured. Response Code : " + responseObj.getStatusCode());
				}
			} else if (type.equalsIgnoreCase("post")) {
			} else if (type.equalsIgnoreCase("put")) {
			} else {
				throw new RuntimeException("No such type : " + type);
			}
		} catch (Exception e) {
		}
	}

}
