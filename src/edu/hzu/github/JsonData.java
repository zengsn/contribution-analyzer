package edu.hzu.github;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonData {

	@SuppressWarnings("unchecked")
	public static void user() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-17.json"));
 
		
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");
					  

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  String geturl=obj7.toString();
										  String newurl=geturl.replace("{/number}", "");
										obj9 =GetAllPulls.getpulls(newurl);
										  
										  
										  
										  
										  
										  PrintStream print=new PrintStream("./data/contributors/user/"+"user-"+obj9.get("user_name")+".json"); 
										  System.setOut(print); 
										  System.out.println(JsonUtils.toString(obj9));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
					in.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}
}
			
			
			


	
	
	@SuppressWarnings("unchecked")
	public static void repo() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-17.json"));
 

		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj2 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				Object obj11 = new Object();
		
                
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  obj11=((HashMap<String, Object>) obj3).get("stargazers_count");
										  obj2=mapurl.get("name");
										  long day=RepoDay.day(mapurl.get("created_at").toString());
										  obj9.put("repo_name", obj2);
										  obj9.put("stargazers_count", obj11);
										  obj9.put("repo_age", day);
										  PrintStream print=new PrintStream("./data/repositories/repo/"+"repo-"+obj2+".json"); 
										  System.setOut(print); 
										  System.out.println(JsonUtils.toString(obj9));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}}
	
	
	
	@SuppressWarnings("unchecked")
	public static void repoage() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
	

		 PrintStream print=new PrintStream("./data/repositories/data/repo_age.json"); 
		  System.setOut(print); 
		
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
				
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										 
										  long day=RepoDay.day(mapurl.get("created_at").toString());
										
										  obj9.put("repo_age", day);
										 
										  System.out.println(JsonUtils.toString(obj9));
									
										 
									  }
								  }
									
							  }
						}
						
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}}

		  
	
      
	
	@SuppressWarnings("unchecked")
	public static void repostar() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 

		  PrintStream print=new PrintStream("./data/repositories/data/star_count.json"); 
		  System.setOut(print); 
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				Object obj11 = new Object();
		
                
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  obj11=((HashMap<String, Object>) obj3).get("stargazers_count");
									
									
										  obj9.put("stargazers_count", obj11);
									
										  System.out.println(JsonUtils.toString(obj9));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}}
	

	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void usercommit() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 
		  
		  PrintStream print=new PrintStream("./data/contributors/data/commit.json"); 
		  System.setOut(print); 
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				Map<String,Object> obj11 = new HashMap<String,Object>();
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");
					  

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  String geturl=obj7.toString();
										  String newurl=geturl.replace("{/number}", "");
										obj9 =GetAllPulls.getpulls(newurl);
									obj11.put("pull_commits", obj9.get("pull_commits"));
										  
										  
										  
										
										  System.out.println(JsonUtils.toString(obj11));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}
}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void userchangefile() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 
		  
		  PrintStream print=new PrintStream("./data/contributors/data/changed_files.json"); 
		  System.setOut(print); 
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				Map<String,Object> obj11 = new HashMap<String,Object>();
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");
					  

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  String geturl=obj7.toString();
										  String newurl=geturl.replace("{/number}", "");
										obj9 =GetAllPulls.getpulls(newurl);
									obj11.put("pull_changed_files", obj9.get("pull_changed_files"));
										  
										  
										  
										
										  System.out.println(JsonUtils.toString(obj11));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}
}
	
	@SuppressWarnings("unchecked")
	public static void userfollowers() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 
		  
		  PrintStream print=new PrintStream("./data/contributors/data/followers.json"); 
		  System.setOut(print); 
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				Map<String,Object> obj11 = new HashMap<String,Object>();
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");
					  

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  String geturl=obj7.toString();
										  String newurl=geturl.replace("{/number}", "");
										obj9 =GetAllPulls.getpulls(newurl);
									obj11.put("followers", obj9.get("followers"));
										  
										  
										  
										
										  System.out.println(JsonUtils.toString(obj11));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}
}
	
	@SuppressWarnings("unchecked")
	public static void usertest_inclusion() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 
		  
		  PrintStream print=new PrintStream("./data/contributors/data/test_inclusion.json"); 
		  System.setOut(print); 
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				Map<String,Object> obj11 = new HashMap<String,Object>();
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");
					  

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  String geturl=obj7.toString();
										  String newurl=geturl.replace("{/number}", "");
										obj9 =GetAllPulls.getpulls(newurl);
									obj11.put("test_inclusion", obj9.get("test_inclusion"));
										  
										  
										  
										
										  System.out.println(JsonUtils.toString(obj11));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}
}
	
	
	@SuppressWarnings("unchecked")
	public static void userpull_comments() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 
		  
		  PrintStream print=new PrintStream("./data/contributors/data/pull_comments.json"); 
		  System.setOut(print); 
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				Map<String,Object> obj11 = new HashMap<String,Object>();
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");
					  

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  String geturl=obj7.toString();
										  String newurl=geturl.replace("{/number}", "");
										obj9 =GetAllPulls.getpulls(newurl);
									obj11.put("pull_comments", obj9.get("pull_comments"));
										  
										  
										  
										
										  System.out.println(JsonUtils.toString(obj11));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}
}
	
	@SuppressWarnings("unchecked")
	public static void userfollowing_user() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 
		  
		  PrintStream print=new PrintStream("./data/contributors/data/following_user.json"); 
		  System.setOut(print); 
		if (br != null) {

			while ((dd = br.readLine()) != null) {
				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
				  
					  
			;
             //输出用户的信息
				Object obj = new Object();
				Object obj1 = new Object();
				Object obj3 = new Object();
				Object obj4 = new Object();
				Object obj5 = new Object();
				Object obj6 = new Object();
				Object obj7 = new Object();
				Object obj8 = new Object();
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj10 = new Object();
				Map<String,Object> obj11 = new HashMap<String,Object>();
				try {
					obj = map.get("repo");
					
					obj1=((HashMap<String, Object>) obj).get("url");
					String url=obj1.toString()+"?";
					BufferedReader in=GetApiData.getdata(url);
					
					
					JsonFactory factoryurl = new JsonFactory();
					ObjectMapper mapperurl = new ObjectMapper(factoryurl);
					TypeReference<HashMap<String, Object>> typeRefurl = new TypeReference<HashMap<String, Object>>() {
					};
      
					String line;
					while ((line = in.readLine()) != null) {
						HashMap<String, Object> mapurl = mapperurl.readValue(line, typeRefurl);
						
					
						
						obj3=mapurl.get("parent");
					
					  obj5=mapurl.get("has_issues");
					   obj6=mapurl.get("pulls_url");
					   obj10=mapurl.get("contributors_url");
					  

            
						if(obj3!=null){
							obj4=((HashMap<String, Object>) obj3).get("has_issues");
							  if("true".equals(obj4.toString())){
								  obj7=((HashMap<String, Object>) obj3).get("pulls_url");
								  String pullurl=obj7.toString().replace("{/number}", "");
								  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  obj8=((HashMap<String, Object>) obj3).get("contributors_url");
									  if(CountContributor.count(obj8.toString())){
										  String geturl=obj7.toString();
										  String newurl=geturl.replace("{/number}", "");
										obj9 =GetAllPulls.getpulls(newurl);
									obj11.put("following_user", obj9.get("following_user"));
										  
										  
										  
										
										  System.out.println(JsonUtils.toString(obj11));
									
										 
									  }
								  }
							  }
						}
						else{
							if("true".equals(obj5)){
								String pullurl=obj6.toString().replace("{/number}", "");  
								  if(Countclosedpulls.countclosed(pullurl))
								  {
									  if(CountContributor.count(obj10.toString())){
										  System.out.println("ok");
									  }
								  }
								
							}
							
							
							
							
						}

						
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
			}

			
				
			
				
}
}
}
