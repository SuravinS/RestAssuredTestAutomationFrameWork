package com.dbank.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtil {

	public String readFileContent(String filePath) {
		String fileContent = "";
		try {
			fileContent = FileUtils.readFileToString(new File(filePath), "UTF-8");
			return fileContent;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
