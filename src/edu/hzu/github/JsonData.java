package edu.hzu.github;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonData {

	public static void test() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;

		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
				System.out.println(s);

				// for (Entry<String, Object> entry : map.entrySet()) {

				/// System.out.println("Key = " + entry.getKey() + ", Value = "
				/// + entry.getValue());

			}
		}
	}
}
