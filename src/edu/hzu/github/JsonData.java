package edu.hzu.github;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonData {

	public static void actor() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;

		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
		//输出文件  
		PrintStream print=new PrintStream("E:\\actor.json"); 
		  System.setOut(print);   
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
			;
             //输出用户的信息
				Object obj = new Object();
				obj = map.get("actor");
				System.out.print(obj);
				System.out.print("\r\n");
			
			

			}
		}
	
		  
      
	}
	
	
	
	
	public static void repo() throws IOException{
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;

		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
		//输出文件  
		PrintStream print=new PrintStream("E:\\repo.json"); 
		  System.setOut(print);   
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
			;
             //输出项目的信息
				Object obj = new Object();
				obj = map.get("repo");
				System.out.print(obj);
				System.out.print("\r\n");
			
			

			}
		}
		
	}
	
	public static void issue() throws IOException{
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;

		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
		//输出文件  
		PrintStream print=new PrintStream("E:\\issue.json"); 
		  System.setOut(print);   
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
			;
             //输出issue的信息
				Object obj = new Object();
				Object obj1 = new Object();
				obj = map.get("payload");
				obj1 = ((HashMap<String, Object>) obj).get("issue");
				System.out.print(obj1);
                System.out.print("\r\n");
			
			

			}
		}
		
	}
	

}
