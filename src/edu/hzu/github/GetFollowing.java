package edu.hzu.github;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class GetFollowing implements Api {
 @SuppressWarnings({ "unchecked", "rawtypes" })
public static List following(String url){
	 String line;
	 BufferedReader in=null;
			 String urlName=url+"?";
		 in=GetApiData.getdata(urlName);
			  JsonFactory factory = new JsonFactory();
				ObjectMapper mapper = new ObjectMapper(factory);
				TypeReference<ArrayList<HashMap<String, Object>>> typeRef = //
				new TypeReference<ArrayList<HashMap<String, Object>>>()  {
				};
				try {
					while ((line = in.readLine()) != null) {
          ArrayList<HashMap<String, Object>> map = mapper.readValue(line, typeRef);
  
          ArrayList obj = new ArrayList();



   for(int i=0;i<map.size();i++){
	obj.add( map.get(i).get("login").toString());

   }


 
 
   return obj;
   

 
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
				finally
				{
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return null;
				
				   
			
}}
