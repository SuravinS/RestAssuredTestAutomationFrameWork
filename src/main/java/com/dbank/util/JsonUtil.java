package com.dbank.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonUtil {
	public JsonElement parseStringToJson(String content) {
		try {
			JsonParser parser = new JsonParser();
			JsonElement out = parser.parse(content);
			return out;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
