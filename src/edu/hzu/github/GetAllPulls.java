package edu.hzu.github;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class GetAllPulls implements Api {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static   Map<String, Object> getpulls(String url){
		
		  BufferedReader in=null;
		  String line;
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
			
			
				
			for(int i=0;i<map.size();i++)
				
			{	String newurl=map.get(i).get("url").toString()+"?";
				BufferedReader put=GetApiData.getdata(newurl); 
			JsonFactory factoryurl = new JsonFactory();
			ObjectMapper mapperurl = new ObjectMapper(factoryurl);
			TypeReference<HashMap<String, Object>> typeRefurl = //
			new TypeReference<HashMap<String, Object>>()  {
			};
			
			
        String aa;
		while ((aa = put.readLine()) != null) {
			HashMap<String, Object> urlmap = mapperurl.readValue(aa, typeRefurl);
			Object obj = new Object();
			Object obj1 = new Object();
			Object obj2 = new Object();
			Object obj4 = new Object();
			Object obj5 = new Object();
			Object obj6 = new Object();
			Object obj8 = new Object();
			Object obj9 = new Object();
			Object obj10 = new Object();
			Object obj11 = new Object();
		
	
			Map<String,Object> obj3 = new HashMap<String,Object>();
			ArrayList obj7 = new ArrayList();
			if("true".equals(urlmap.get("merged").toString())){
			obj=urlmap.get("commits");
			obj1=urlmap.get("changed_files");
			obj2=urlmap.get("comments");
			obj4=urlmap.get("user");
			obj5=((Map<String, Object>) obj4).get("login");
			
			obj6=urlmap.get("base");
			obj8=((Map<String, Object>) obj6).get("user");
			obj9=((Map<String, Object>) obj8).get("login");
			obj10=urlmap.get("head");
			obj11=((Map<String, Object>) obj10).get("repo");
			String labelsurl=((Map<String, Object>) obj11).get("labels_url").toString();
			String labels=labelsurl.replace("{/name}", "");
			Boolean testinclusion=TestInclusion.testtest(labels);
			
			int followers=CountUserFollowers.count(((Map<String, Object>) obj4).get("followers_url").toString());
			
			String fol=((Map<String, Object>) obj4).get("following_url").toString();
			String fow=fol.replace("{/other_user}", "");
			obj7=(ArrayList) GetFollowing.following(fow);
			
			int b =1;
		     if(b>obj7.size()){obj3.put("following_user", "false");}
					for(int a=0;a<obj7.size();a++){
						if(obj9.toString().equals(obj7.get(a).toString())){
							obj3.put("following_user", "true");
							
						}
						else{
							obj3.put("following_user", "false");
						}
					}
			
			obj3.put("pull_commits", obj);
			obj3.put("pull_changed_files", obj1);
			obj3.put("pull_comments", obj2);
			obj3.put("user_name", obj5);
			obj3.put("followers", followers);
			obj3.put("test_inclusion", testinclusion);	
			 put.close();
			  return obj3;
			}
			
		
		}
		
			
			}
		
			}
			
		  }
	
			catch (JsonParseException e) {
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
		return null;
	
			

		  }}
