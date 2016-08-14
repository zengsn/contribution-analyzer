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
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 
		
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
				obj = map.get("payload");
				
				obj1=((HashMap<String, Object>) obj).get("pull_request");
				
				if(obj1!=null){
				obj2=((HashMap<String, Object>) obj1).get("merged");
			       if(obj2!=null){
					  if("true".equals(obj2.toString())){//判断merged是否为真
						  obj3=((HashMap<String, Object>) obj1).get("base");
						if(obj3!=null){	
							obj4=((HashMap<String, Object>) obj3).get("repo");
							 if(obj4!=null){
								 obj5=((HashMap<String, Object>) obj4).get("fork");
									if(obj5!=null){	
										 if("false".equals(obj5.toString()))//选择没有FORK过项目的贡献者
										  {	  obj6=((HashMap<String, Object>) obj3).get("user");
										  obj7=((HashMap<String, Object>) obj6).get("login");
										  obj8=((HashMap<String, Object>) obj6).get("id");
										  obj10=((HashMap<String, Object>) obj4).get("created_at");
										  obj9.put("merged",obj2);
										  obj9.put("fork",obj5);
										  obj9.put("login",obj7);
										  obj9.put("id",obj8);
										  obj9.put("created_at",obj10);
										  
									
										  PrintStream print=new PrintStream("./data/contributors/user/"+"user-"+obj7+".json"); 
										  System.setOut(print); 
										  System.out.println(JsonUtils.toString(obj9));
										
										
										  }
									}
								 }
						}
				      
				     }
                      
				
					}
				
			
					
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
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
 
		
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
				Object obj12 = new Object();
				Object obj13 = new Object();
				Object obj14 = new Object();
				
				obj = map.get("payload");
				
				obj1=((HashMap<String, Object>) obj).get("pull_request");
				
				if(obj1!=null){
				obj2=((HashMap<String, Object>) obj1).get("merged");
			       if(obj2!=null){
					  if("true".equals(obj2.toString())){//判断merged是否为真
						  obj3=((HashMap<String, Object>) obj1).get("base");
						if(obj3!=null){	
							obj4=((HashMap<String, Object>) obj3).get("repo");
							 if(obj4!=null){
								 obj5=((HashMap<String, Object>) obj4).get("fork");
									if(obj5!=null){	
										 if("false".equals(obj5.toString()))//选择没有FORK过项目的贡献者
										  {	  
			                                 obj6=((HashMap<String, Object>) obj1).get("head");
											 if(obj6!=null){
										        obj7=((HashMap<String, Object>) obj6).get("repo");
											    if(obj7!=null){
										          obj8=((HashMap<String, Object>) obj7).get("id");
										          obj10=((HashMap<String, Object>) obj7).get("name");
										          obj11=((HashMap<String, Object>) obj7).get("created_at");
										          obj12=((HashMap<String, Object>) obj7).get("forks");
										          obj13=((HashMap<String, Object>) obj7).get("watchers");
										          obj14=((HashMap<String, Object>) obj7).get("open_issues");
										  obj9.put("id",obj8);
										  obj9.put("name",obj10);
										  obj9.put("created_at",obj11);
										  obj9.put("forks",obj12);
										  obj9.put("watchers",obj13);
										  obj9.put("open_issues",obj14);
										 
										
										  
									
										  PrintStream print=new PrintStream("./data/contributors/repo/"+"repo-"+obj10+".json"); 
										  System.setOut(print); 
										  System.out.println(JsonUtils.toString(obj9));
											 }
											 }
										  }
									}
								 }
						}
				      
				     }
                      
				
					}
				
			
					
				}
			
			
			

			}
		}
	
		  
      
	}
	
	@SuppressWarnings("unchecked")
	public static void repodataforks() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));

		  PrintStream print=new PrintStream("./data/contributors/repo/data/forks.json"); 
		  System.setOut(print); 
		
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
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj12 = new Object();
				obj = map.get("payload");
				
				obj1=((HashMap<String, Object>) obj).get("pull_request");
				
				if(obj1!=null){
				obj2=((HashMap<String, Object>) obj1).get("merged");
			       if(obj2!=null){
					  if("true".equals(obj2.toString())){//判断merged是否为真
						  obj3=((HashMap<String, Object>) obj1).get("base");
						if(obj3!=null){	
							obj4=((HashMap<String, Object>) obj3).get("repo");
							 if(obj4!=null){
								 obj5=((HashMap<String, Object>) obj4).get("fork");
									if(obj5!=null){	
										 if("false".equals(obj5.toString()))//选择没有FORK过项目的贡献者
										  {	  
			                                 obj6=((HashMap<String, Object>) obj1).get("head");
											 if(obj6!=null){
										        obj7=((HashMap<String, Object>) obj6).get("repo");
											    if(obj7!=null){
										        obj12=((HashMap<String, Object>) obj7).get("forks");
										       
										
										       obj9.put("forks",obj12);
										       System.out.println(JsonUtils.toString(obj9));
										 
										
										  
									
										  
											 }
											 }
										  }
									}
								 }
						}
				      
				     }
                      
				
					}
				
			
					
				}
			
			
			

			}
		}
	
		  
      
	}
	
	@SuppressWarnings("unchecked")
	public static void repodatawatchers() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));

		  PrintStream print=new PrintStream("./data/contributors/repo/data/watchers.json"); 
		  System.setOut(print); 
 
		
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
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj13 = new Object();
				obj = map.get("payload");
				
				obj1=((HashMap<String, Object>) obj).get("pull_request");
				
				if(obj1!=null){
				obj2=((HashMap<String, Object>) obj1).get("merged");
			       if(obj2!=null){
					  if("true".equals(obj2.toString())){//判断merged是否为真
						  obj3=((HashMap<String, Object>) obj1).get("base");
						if(obj3!=null){	
							obj4=((HashMap<String, Object>) obj3).get("repo");
							 if(obj4!=null){
								 obj5=((HashMap<String, Object>) obj4).get("fork");
									if(obj5!=null){	
										 if("false".equals(obj5.toString()))//选择没有FORK过项目的贡献者
										  {	  
			                                 obj6=((HashMap<String, Object>) obj1).get("head");
											 if(obj6!=null){
										        obj7=((HashMap<String, Object>) obj6).get("repo");
											    if(obj7!=null){
										       
										          obj13=((HashMap<String, Object>) obj7).get("watchers");
										         
									
										  obj9.put("watchers",obj13);
									
										
										  
									
										  System.out.println(JsonUtils.toString(obj9));
											 }
											 }
										  }
									}
								 }
						}
				      
				     }
                      
				
					}
				
			
					
				}
			
			
			

			}
		}

	}
	@SuppressWarnings("unchecked")
	public static void repodataopen_issues() throws IOException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		String dd;
	
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));

		  PrintStream print=new PrintStream("./data/contributors/repo/data/open_issues.json"); 
		  System.setOut(print); 
 
		
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
				Map<String,Object> obj9 = new HashMap<String,Object>();
				Object obj14 = new Object();
				
				obj = map.get("payload");
				
				obj1=((HashMap<String, Object>) obj).get("pull_request");
				
				if(obj1!=null){
				obj2=((HashMap<String, Object>) obj1).get("merged");
			       if(obj2!=null){
					  if("true".equals(obj2.toString())){//判断merged是否为真
						  obj3=((HashMap<String, Object>) obj1).get("base");
						if(obj3!=null){	
							obj4=((HashMap<String, Object>) obj3).get("repo");
							 if(obj4!=null){
								 obj5=((HashMap<String, Object>) obj4).get("fork");
									if(obj5!=null){	
										 if("false".equals(obj5.toString()))//选择没有FORK过项目的贡献者
										  {	  
			                                 obj6=((HashMap<String, Object>) obj1).get("head");
											 if(obj6!=null){
										        obj7=((HashMap<String, Object>) obj6).get("repo");
											    if(obj7!=null){
										        
										          obj14=((HashMap<String, Object>) obj7).get("open_issues");
										
										  obj9.put("open_issues",obj14);
										 
										
										  
									
										  System.out.println(JsonUtils.toString(obj9));
											 }
											 }
										  }
									}
								 }
						}
				      
				     }
                      
				
					}
				
			
					
				}
			
			
			

			}
		}
	
		  
      
	}

}
