package edu.hzu.github;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class GetData implements Api {
	public static void main(String[] args) {
		runAndRun();
	}

	public static void runAndRun() {
		try {
			System.out.println("Run at " + new Date());
			run();
		} catch (RuntimeException e) {
			e.printStackTrace();
			try {
				System.out.println("Sleep at " + new Date());
				Thread.sleep(61 * 60 * 1000);
				runAndRun(); // run again
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static void run() {
		//读取json文件中每个repo的url,下载每个REPO的信息
		File file = new File("./");
		String reponame=null;
        String dd;
        try {
    		Map<String, Object> map=new HashMap<String,Object>();
    		map=null;
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("2015-01-01-16.json"));
			if (br != null) {
			while ((dd = br.readLine()) != null) {
				Map<String,Object> eachrepo= new HashMap<String,Object>();
				Object obj = new Object();
			eachrepo = JsonUtils.toMap(dd);
				obj=eachrepo.get("repo");
				@SuppressWarnings("unchecked")
				String name=((Map<String, Object>) obj).get("name").toString();
		        String name1= name.substring(name.indexOf("/")+1);
		        File jsonFile3 = new File(file.getAbsolutePath() + "/data/repo"+"/"+name1);
		 
		        if(!jsonFile3.exists()){
				@SuppressWarnings("unchecked")
				String repo=((Map<String, Object>) obj).get("url").toString();
				String repourl=repo+"?"+ CLIENT_ID_SECRET;
				String resp = Http.get(repourl);

				if (resp != null) {
					 
			      map = JsonUtils.toMap(resp);
			    
		          reponame=map.get("name").toString();
				  
				}
				
			File jsonFile1 = new File(file.getAbsolutePath() + "/data/repo"+"/"+reponame+"/");
				if(!jsonFile1.exists()){
					jsonFile1.mkdirs();
				File jsonFile = new File(file.getAbsolutePath() + "/data/repo"+"/"+reponame+"/"+reponame+".json");
				writeToFile(jsonFile, JsonUtils.toString(map));
				}
			 }
			 }}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
		//排除fork=true,has_isuues=false的repo
		File dir = new File(file.getAbsolutePath() + "/data/repo");
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		if (files != null) {
			for (int i=0; i < files.length; i++) {
		        String filePath= files[i].getAbsolutePath();
		    	File dir2 = new File(filePath);
		    	File[] files2=dir2.listFiles(); 
		        String jsonPath=files2[0].getAbsolutePath();
		         File jsonFile = new File(jsonPath);
		    	 String jsonFile1=readFileToString( jsonFile);
		         Map<String, Object> jsonMap = JsonUtils.toMap(jsonFile1);
		         String fork=jsonMap.get("fork").toString();
		         String has_issues=jsonMap.get("has_issues").toString();
		
		    	if(fork.equals("true")||has_issues.equals("false")){		    	
		    		jsonFile.delete();
		    		dir2.delete();
		    	
		    	}
		   }
			
		}
	

		
		//拉取contributors 
		File dir1 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files1 = dir1.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files1 != null) {
			for (int i=0; i < files1.length; i++) {
				List<Map<String, Object>> contributors = new ArrayList<Map<String, Object>>();
		        String filePath= files1[i].getAbsolutePath();
		    	File dir2 = new File(filePath);
		    	File[] files2=dir2.listFiles(); 
		        String jsonPath=files2[0].getAbsolutePath();
		         File jsonFile = new File(jsonPath);
		    	 String jsonFile1=readFileToString( jsonFile);
		         Map<String, Object> jsonMap = JsonUtils.toMap(jsonFile1);
		         String contributors_url=jsonMap.get("contributors_url").toString();
		         @SuppressWarnings("unused")
				String reponame1=jsonMap.get("name").toString();
		         String url = contributors_url+ "?" + CLIENT_ID_SECRET+ "&" +PER_PAGE + "100&" + PAGE ;
		            @SuppressWarnings("unused")
					int total = 0;
					int pages = 1;
					String resp = Http.get(url + pages);
					if (resp == null) { // 限制到了，应该停一个小时
						System.out.println("fail");
					}
					while (resp != null && resp.startsWith("[")) {
						List<Map<String, Object>> list = JsonUtils.toList(resp);
						if (list.size() > 0) {
					        contributors.addAll(list);
							resp = Http.get(url + ++pages);
						} else {
							break;
						}
					}
					File jsonFile5 = new File(file.getAbsolutePath() + "/data/repo"+"/"+reponame+"/"+"contributors.json");
					writeToFile(jsonFile5, JsonUtils.toString(contributors));
		    
		
			}
			}
		
		
		
		//排除没有Contributor的repo
		File dir3 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files3 = dir3.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files3 != null) {
			for (int i=0; i < files3.length; i++) {
		
		        String filePath= files3[i].getAbsolutePath();
		    	File dir2 = new File(filePath);
		    	File[] files2=dir2.listFiles(); 
		    	String jsonPath=files2[0].getAbsolutePath();
	            File jsonFile = new File(jsonPath);
		         if(files2.length==1){
		        		jsonFile.delete();
			    		dir2.delete();
		        	 
		        	 
		         }
			}
			
		}
		
		
		
		
		
		
		//排除contributor小于3的项目
		
		
		File dir4 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files4 = dir4.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files4 != null) {
			for (int i=0; i < files4.length; i++) {
		
		        String filePath= files4[i].getAbsolutePath();
		    	File dir2 = new File(filePath);
		    	File[] files2=dir2.listFiles(); 
		    	if(files2!=null){
		    		for (int a=0; a < files2.length; a++)
		    			
		    		{
		    			String cName=files2[a].getName();
		    		    if(cName.equals("contributors.json")){
		    		    	 String jsonPath=files2[a].getAbsolutePath();
		    		         File jsonFile = new File(jsonPath);
		    		    	 String jsonFile1=readFileToString( jsonFile);
		    		         List<Map<String, Object>> jsonMap = JsonUtils.toList(jsonFile1);
		    		         if(jsonMap.size()<3){
		    		        	 jsonFile.delete();
		    		        	 dir2.delete();
		    		        	 
		    		         }
		    		    
		    		    }
		    			
		    			
		    		}
		    	}
		    	
	            
		    
			}
		}
		
		
		
		
		
//		读取每个repo的所有closed pull
		File dir5 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files5 = dir5.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files5 != null) {
			for (int i=0; i < files5.length; i++) {
		
		        String filePath= files5[i].getAbsolutePath();
		    	File dir2 = new File(filePath);
		    	File[] files2=dir2.listFiles(); 
		    	if(files2!=null){
		    		for (int a=0; a < files2.length; a++){
		    			List<Map<String, Object>> pulls = new ArrayList<Map<String, Object>>();
		    			String cName=files2[a].getName();
		    		    if(!cName.equals("contributors.json")&!cName.equals("AllPulls")){
		    		    String jsonPath=files2[a].getAbsolutePath();
		    		    File jsonFile = new File(jsonPath);
	    		        String jsonFile1=readFileToString( jsonFile);
		    		    Map<String, Object> jsonMap = JsonUtils.toMap(jsonFile1);
		    		    String url=jsonMap.get("pulls_url").toString();
		    		    String reponame5=jsonMap.get("name").toString();
		    		    File jsonFile7 = new File(file.getAbsolutePath() + "/data/repo"+"/"+reponame5+"/AllPulls");
		    		    if(!jsonFile7.exists()){
		    			String pullurl=url.replace("{/number}", "");
		    		     String purl = pullurl+ "?" +STATE_CLOSED+"&"+ CLIENT_ID_SECRET+ "&" +PER_PAGE + "20&" + PAGE ;
				         
							int pages = 1;
							String resp = Http.get(purl + pages);
							if (resp == null) { // 限制到了，应该停一个小时
								
							}
							while (resp != null && resp.startsWith("[")) {
								List<Map<String, Object>> list = JsonUtils.toList(resp);
								if (list.size() > 0) {
							        pulls.addAll(list);
									resp = Http.get(purl + ++pages);
								} else {
									break;
								}
							}
							
						if(!jsonFile7.exists()){
							jsonFile7.mkdirs();
							File jsonFile6 = new File(file.getAbsolutePath() + "/data/repo"+"/"+reponame5+"/"+"AllPulls/"+"allpull.json");
							writeToFile(jsonFile6, JsonUtils.toString(pulls));}
							
		    		}
		    		    }
		    	   }
		    	}
			}
			}

		//排除pull数目不合格的repo
		File dir6 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files6 = dir6.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files6 != null) {
			for (int i=0; i < files6.length; i++) {
		        int count=0;
		        String path=files6[i].getAbsolutePath();
		      
		        String filePath= path+"/"+"AllPulls"+"/"+"allpull.json";
		        File jsonFile = new File(filePath);
		        String jsonFile1=readFileToString( jsonFile);
		        List<Map<String, Object>> jsonList = JsonUtils.toList(jsonFile1);
		        for(Map<String,Object> pull:jsonList){
		        	Object merged=pull.get("merged_at");
		        	if(merged!=null){
		        		count++;
		        	}
		        
		        
		        }
		      if(count==0)
		      {
		    	jsonFile.delete();
		    	File dir7 = new File(path );
				File[] files7 = dir7.listFiles();
				for (int a=0; a < files7.length;a++) {
					String fold=files7[a].getAbsolutePath();
				    File File = new File(fold);
				    File.delete();
					
				}
		    	dir7.delete();
		    	
		    	
		      }
		    	
		       
			}
		}
		
		
		
		
//		拉取所有USER的信息
		File dir8 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files8 = dir8.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files8 != null) {
			for (int i=0; i < files8.length; i++) {
		    
		     	int a =0;
		        String path=files8[i].getAbsolutePath();
		      
		        String filePath= path+"/"+"AllPulls"+"/"+"allpull.json";
		        File jsonFile = new File(filePath);
		        String jsonFile1=readFileToString( jsonFile);
		        List<Map<String, Object>> jsonList = JsonUtils.toList(jsonFile1);
		        for(Map<String,Object> pull:jsonList){
		       
		        	Object merged=pull.get("merged_at");
		        	
		        	if(merged!=null)
		        	{   
		        		Object pulltime=pull.get("created_at");
		        		@SuppressWarnings("unchecked")
						Map<String,Object> user=(Map<String, Object>) pull.get("user");
		                String login= ((Map<String, Object>) user).get("login").toString();
		                user.put("pulltime", pulltime);
		                
		                String userPath= path+"/"+"User";
		                File userFile = new File(userPath);
		                if(!userFile.exists()){
		                	userFile.mkdirs();
		                }
	                
		               String eachuser=userPath+"/"+login;
		               File eachFile = new File(eachuser);
                       if(!eachFile.exists()){
            	        eachFile.mkdirs();
            	       File userfile = new File(eachuser+"/"+login+".json");
 				       writeToFile(userfile, JsonUtils.toString(user));
	                   }
                       else
                       {
                    	   File userfile = new File(eachuser+"/"+login+"-"+a+".json");
    				       writeToFile(userfile, JsonUtils.toString(user));
                       }
		               
		               
		              
		             
					   
					   
		                
		              
		        		
		        	}
		        	a++;
		        }
		      }
			}
		
		
		
		//去除重复的user
		File dir9 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files9 = dir9.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files9 != null) {
			for (int i=0; i < files9.length; i++) {
		    
		  
		        String path=files9[i].getAbsolutePath();
		      
		        String filePath= path+"/"+"User";
		        
		        File dir10 = new File(filePath);
				File[] files10 = dir10.listFiles();
				if(files10!=null)
				{
					for (int a=0; a < files10.length; a++) 
					{
						  String userpath=files10[a].getAbsolutePath();
						   
					        File dir2 = new File(userpath);
							File[] files2= dir2.listFiles();
							if(files2.length>1){
								String nameuser = null;
								List<Map<String,Object>> userlist =new ArrayList<Map<String, Object>>();
								List<Map<String,Object>> timelist =new ArrayList<Map<String, Object>>();
								int number=0;
								for (int b=0; b < files2.length; b++)
								{   
									String user=files2[b].getAbsolutePath();
									File userFile = new File(user);
									String jsonFile1=readFileToString( userFile);
							        Map<String, Object> usermap = JsonUtils.toMap(jsonFile1);
							        Object pulltime=usermap.get("pulltime");
							        String username=files2[b].getName();
							        Map<String,Object> mapuser = new HashMap<String,Object>();
							        mapuser.put("pulltime", pulltime);
							        mapuser.put("username", username);
							        userlist.add(b, mapuser);
							     }
								
								
								for(Map<String,Object> eachtime:userlist)
								{ 
								String time=	eachtime.get("pulltime").toString().replace("T", " ").replace("Z", "");
								String name=    eachtime.get("username").toString();
							    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							    @SuppressWarnings("unused")
								SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								try {
									Date date = format.parse(time);
									Date date2 = format.parse("2017-01-15 00:00:00");
						            int miaoshu=differentDaysByMillisecond(date,date2);
						            Map<String,Object> timema = new HashMap<String,Object>();
						            timema.put("miaoshu", miaoshu);
						            timema.put("username", name);
						            timelist.add(number, timema);
						            number++;
						           
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								}
						        System.out.println(timelist);
								int max=Integer.parseInt(timelist.get(0).get("miaoshu").toString());
						    for(Map<String,Object> timeeach:timelist)
						    {
						    	int miao=Integer.parseInt(timeeach.get("miaoshu").toString());
						    	if(miao>max){
						    		max=miao;
						    	}
						    	
						    }
						    for(Map<String,Object> timeeach:timelist)
						    {
						    	if(max==Integer.parseInt(timeeach.get("miaoshu").toString())){
						           nameuser=	timeeach.get("username").toString();
						           System.out.println("======"+nameuser);
						    		
						    	}
						    }
						    for (int b=0; b < files2.length; b++)
							{  
						    	String user=files2[b].getName();
						    	if(!user.contains(nameuser)){
						    		File userFile = new File(files2[b].getAbsolutePath());
						    		userFile.delete();
						    		System.out.println("delete====="+files2[b].getAbsolutePath());
						    	}
								
						    	
							}
						    
						    
							}
					}
					
				}
				}
		        
			}
	
		
		
		//拉取followers
		File dir11 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files11 = dir11.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files11 != null) {
			for (int i=0; i < files11.length; i++) {
				  
				
		  
		        String path=files11[i].getAbsolutePath();
		        Map<String, Object> map=new HashMap<String,Object>();
		        String filePath= path+"/"+"User";
		        
		        File dir12 = new File(filePath);
				File[] files12 = dir12.listFiles();
				  
				if(files12!=null)
				{
					for (int a=0; a < files12.length; a++) 
					{
					  String userpath=files12[a].getAbsolutePath();
						  File userFile = new File(userpath);
							File[] files2 = userFile.listFiles();
					if(files2.length<2){
						  for (int b=0; b < files2.length; b++)
								{   
									String user=files2[b].getAbsolutePath();
									File userFile3 = new File(user);
									String jsonFile1=readFileToString( userFile3);
							        Map<String, Object> usermap = JsonUtils.toMap(jsonFile1);
						            String url=usermap.get("url").toString();
	                                String userurl=url+"?"+ CLIENT_ID_SECRET;
	      				             String resp = Http.get(userurl);
	                           
	      				if (resp != null) {
	      					 
	      			      map = JsonUtils.toMap(resp);
	      			  
	      				  
	      				}
	      				
      			        File jsonFile = new File(userpath+"/"+"follower.json");
	      				writeToFile(jsonFile, JsonUtils.toString(map));
	      				
	
				   
					}
					
				 }
				}
			}
		}
	
		}
	
	
	
		
		
		// 拉取所有user的follwing
		@SuppressWarnings("unused")
		File dir13 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files13 = dir.listFiles(); // 该文件目录下文件全部放入数组
		
		if (files13 != null) {
			for (int i=0; i < files13.length; i++) {
				  
				
		  
		        String path=files13[i].getAbsolutePath();
		   
		        String filePath= path+"/"+"User";
		        
		        File dir14 = new File(filePath);
				File[] files14 = dir14.listFiles();
				  
				if(files14!=null)
				{
					for (int a=0; a < files14.length; a++) 
					{
					  String userpath=files14[a].getAbsolutePath();
						  File userFile = new File(userpath);
							File[] files2 = userFile.listFiles();
					if(files2.length<3){
						  for (int b=0; b < files2.length; b++)
								{   	List<Map<String, Object>> pulls = new ArrayList<Map<String, Object>>();
							     if(!files2[b].getName().equals("follower.json")){
									String user=files2[b].getAbsolutePath();
									File userFile3 = new File(user);
									String jsonFile1=readFileToString( userFile3);
							        Map<String, Object> usermap = JsonUtils.toMap(jsonFile1);
						            String url=usermap.get("following_url").toString().replace("{/other_user}", "");
						   	     String purl = url+ "?" + CLIENT_ID_SECRET+ "&" +PER_PAGE + "80&" + PAGE ;
						         
									int pages = 1;
									String resp = Http.get(purl + pages);
									if (resp == null) { // 限制到了，应该停一个小时
										
									}
									while (resp != null && resp.startsWith("[")) {
										List<Map<String, Object>> list = JsonUtils.toList(resp);
										if (list.size() > 0) {
									        pulls.addAll(list);
											resp = Http.get(purl + ++pages);
										} else {
											break;
										}
									}
									
	      				
      			        File jsonFile = new File(userpath+"/"+"following.json");
	      				writeToFile(jsonFile, JsonUtils.toString(pulls));
	      				
	
				   
					}
					
				 }
				}
			}
		}
	
		}}
	
	
		// 拉取所有user的events
		File dir15 = new File(file.getAbsolutePath() + "/data/repo");
		File[] files15 = dir15.listFiles(); // 该文件目录下文件全部放入数组
		int count=0;
		if (files15 != null) {
			
			for (int i=0; i < files15.length; i++) {
				  
				
		  
		        String path=files15[i].getAbsolutePath();
		   
		        String filePath= path+"/"+"User";
		        
		        File dir16 = new File(filePath);
				File[] files16 = dir16.listFiles();
				  
				if(files16!=null)
				{
					for (int a=0; a < files16.length; a++) 
					{
					  String userpath=files16[a].getAbsolutePath();
						  File userFile = new File(userpath);
							File[] files2 = userFile.listFiles();
					if(files2.length<4){
						  for (int b=0; b < files2.length; b++)
								{   	List<Map<String, Object>> pulls = new ArrayList<Map<String, Object>>();
							     if(!files2[b].getName().equals("follower.json")&!files2[b].getName().equals("following.json")){
									String user=files2[b].getAbsolutePath();
									File userFile3 = new File(user);
								
									String jsonFile1=readFileToString( userFile3);
							        Map<String, Object> usermap = JsonUtils.toMap(jsonFile1);
						            String url=usermap.get("events_url").toString().replace("{/privacy}", "");
						   	     String purl = url+ "?" + CLIENT_ID_SECRET+ "&" +PER_PAGE + "30&" + PAGE ;
						     
						      
									int pages = 1;
									String resp = Http.get(purl + pages);
								    count++;
								    System.out.println(count);
									if (count>4900) { // 限制到了，应该停一个小时
										throw new RuntimeException("Take a rest for one hour!");
									}
									while (resp != null && resp.startsWith("[")) {
										List<Map<String, Object>> list = JsonUtils.toList(resp);
										if (list.size() > 0) {
									        pulls.addAll(list);
											resp = Http.get(purl + ++pages);
											count++;
									  System.out.println(count);
										} else {
											break;
										}
									}
									
	      				
      			        File jsonFile = new File(userpath+"/"+"events.json");
	      				writeToFile(jsonFile, JsonUtils.toString(pulls));
	      				
	
				   
					}
					
				 }
				}
			}
		}
	
		}}
	
	
		
		
	
	}
	
	
	
	
	
	
	
	
		


	
	
	private static String readFileToString(File jsonFile) {
		try {
			System.out.println("Read from " + jsonFile.getAbsolutePath());
			BufferedReader reader = new BufferedReader( //
					new FileReader(jsonFile));
			StringBuilder json = new StringBuilder();
			String line = reader.readLine();
			while (line != null) {
				json.append(line + "\n");
				line = reader.readLine();
			}
			reader.close();
			return json.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / 1000);
        return days;
    }
	
    private static void writeToFile(File jsonFile, String json) {
		try { // 保存到文件
			System.out.println("Write to " + jsonFile.getAbsolutePath());
			FileWriter fileWriter = new FileWriter(jsonFile);
			fileWriter.write(json);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
