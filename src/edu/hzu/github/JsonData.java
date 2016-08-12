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
 
		PrintStream print=new PrintStream("./lib/json.json"); 
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
				Object obj8 = new Object();
				Object obj9 = new Object();
				Object obj10 = new Object();
				Object obj11= new Object();
				Object obj12= new Object();
				
				
				obj = map.get("payload");
				
				obj1=((HashMap<String, Object>) obj).get("pull_request");
				
				if(obj1!=null){
				obj2=((HashMap<String, Object>) obj1).get("merged");
			       if(obj2!=null){
					  if("true".equals(obj2.toString())){//判断merged是否为真
						  obj3=((HashMap<String, Object>) obj1).get("head");
						if(obj3!=null){	
							obj4=((HashMap<String, Object>) obj3).get("repo");
							 if(obj4!=null){
								 obj5=((HashMap<String, Object>) obj4).get("forks");
									if(obj5!=null){	
										 if("0".equals(obj5.toString()))//判断fork是否为0
										  {	  obj6=((HashMap<String, Object>) obj3).get("user");
										  obj7=((HashMap<String, Object>) obj6).get("login");
										  obj8=((HashMap<String, Object>) obj4).get("open_issues");
										  obj9=((HashMap<String, Object>) obj4).get("watchers");
										  obj10=((HashMap<String, Object>) obj4).get("has_wiki");
										  obj11=((HashMap<String, Object>) obj4).get("has_page");
										  obj12=((HashMap<String, Object>) obj4).get("has_issues");
	 System.out.print("login=="+obj7+" "+"open_issues=="+obj8+"  "+"watchers=="+obj9+"  "+"has_wiki=="+obj10+"  "+"has_page=="+obj11+"  "+"has_issues=="+obj12);
										  System.out.print("\r\n");
											  
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
	
	
//	
//	
//	public static void repo() throws IOException{
//		JsonFactory factory = new JsonFactory();
//		ObjectMapper mapper = new ObjectMapper(factory);
//		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
//		};
//		String dd;
//
//		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
//		//输出文件  
//		PrintStream print=new PrintStream("E:\\repo.json"); 
//		  System.setOut(print);   
//		if (br != null) {
//
//			while ((dd = br.readLine()) != null) {
//				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
//			;
//             //输出项目的信息
//				Object obj = new Object();
//				obj = map.get("repo");
//				System.out.print(obj);
//				System.out.print("\r\n");
//			
//			
//
//			}
//		}
//		
//	}
//	
//	public static void issue() throws IOException{
//		JsonFactory factory = new JsonFactory();
//		ObjectMapper mapper = new ObjectMapper(factory);
//		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
//		};
//		String dd;
//
//		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
//		//输出文件  
//		PrintStream print=new PrintStream("E:\\issue.json"); 
//		  System.setOut(print);   
//		if (br != null) {
//
//			while ((dd = br.readLine()) != null) {
//				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
//			;
//             //输出issue的信息
//				Object obj = new Object();
//				Object obj1 = new Object();
//				obj = map.get("payload");
//				obj1 = ((HashMap<String, Object>) obj).get("issue");
//				System.out.print(obj1);
//                System.out.print("\r\n");
//			
//			
//
//			}
//		}
//		
//	}
//	public static void forks() throws IOException{
//		JsonFactory factory = new JsonFactory();
//		ObjectMapper mapper = new ObjectMapper(factory);
//		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
//		};
//		String dd;
//
//		BufferedReader br = new BufferedReader(new FileReader("2015-01-01-15.json"));
//		//输出文件  
//		PrintStream print=new PrintStream("E:\\forks.json"); 
//		  System.setOut(print);   
//		if (br != null) {
//
//			while ((dd = br.readLine()) != null) {
//				HashMap<String, Object> map = mapper.readValue(dd, typeRef);
//			;
//             //输出issue的信息
//				Object obj = new Object();
//				Object obj1 = new Object();
//				Object obj2 = new Object();
//				Object obj3= new Object();
//				Object obj4= new Object();
//				obj = map.get("payload");
//				obj1 = ((HashMap<String, Object>) obj).get("pull_request");
//				if(obj1!=null){
//					obj2 = ((HashMap<String, Object>) obj1).get("base");
//					obj3= ((HashMap<String, Object>) obj2).get("repo");
//					obj4= ((HashMap<String, Object>) obj3).get("forks");
//				
//				}
//				
//				System.out.print(obj4);
//                System.out.print("\r\n");
//			
//			
//
//			}
//		}
//		
//	}
//	

}
