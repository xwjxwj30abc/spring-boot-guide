package zx.soft.sample.jetty.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Object2Json {

	public static String toJsonWithoutPretty(Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
