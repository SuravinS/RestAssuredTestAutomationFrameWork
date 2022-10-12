package com.dbank.libraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import com.dbank.runtime.TestBase;
import com.dbank.util.FileUtil;
import com.dbank.util.JsonUtil;

public class LIB_NaceDetails extends TestBase {
	public String response = "";
	FileUtil fileUtil = new FileUtil();
	JsonUtil jsonUtil = new JsonUtil();

	public void getNACEDetails(String NACECode) {
		response = callWebService("get", "http://localhost:3001/getNaceDetails/" + NACECode,
				"contentType=application/json", "");
	}

	public void searchIsExecutedSuccessfully(String NACECode) {
		validateStatusCode("get", "http://localhost:3001/getNaceDetails/" + NACECode, "contentType=application/json",
				"", "200");
	}

	public void validateJsonBody(String fileName, String NACECode) throws IOException {
		String fileContent = fileUtil
				.readFileContent(System.getProperty("user.dir") + "/src/test/resources/templates/" + fileName);
		response = callWebService("get", "http://localhost:3001/getNaceDetails/" + NACECode,
				"contentType=application/json", "");
		Assert.assertEquals(jsonUtil.parseStringToJson(fileContent), jsonUtil.parseStringToJson(response));
	}

}
