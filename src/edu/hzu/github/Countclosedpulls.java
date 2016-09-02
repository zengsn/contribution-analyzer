package edu.hzu.github;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Countclosedpulls implements Api{
	public static   Boolean countclosed(String url){
	
		  String line;
		  BufferedReader in=null;
		  try {
		
				 String urlName=url+"?"+STATE_CLOSED+"&";
				 in=GetApiData.getdata(urlName);
				  JsonFactory factory = new JsonFactory();
					ObjectMapper mapper = new ObjectMapper(factory);
					TypeReference<ArrayList<HashMap<String, Object>>> typeRef = //
					new TypeReference<ArrayList<HashMap<String, Object>>>()  {
					};
			while ((line = in.readLine()) != null) {
				ArrayList<HashMap<String, Object>> map = mapper.readValue(line, typeRef);
				
			if(map.size()>=1){
				
				return true;
			}
			    	
			 
			 
			

			
			
		
			
}
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally{
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		return false;

}}
