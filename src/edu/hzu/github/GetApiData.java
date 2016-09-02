package edu.hzu.github;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;




public class GetApiData implements Api{
            public static BufferedReader getdata(String url){
            	
         
					String urlNameString=url+CLIENT_ID + "&" + CLIENT_SECRET;
				
					    BufferedReader in = null;
					    try {
					    	
					    
					        URL realUrl = new URL(urlNameString);
					        // 打开和URL之间的连接
					        URLConnection connection = realUrl.openConnection();
					        // 设置通用的请求属性
					        connection.setRequestProperty("accept", "*/*");
					        connection.setRequestProperty("connection", "Keep-Alive");
					        connection.setRequestProperty("user-agent",
					                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
					        connection.setConnectTimeout(30000);
					        connection.setReadTimeout(30000);
					        // 建立实际的连接
					        connection.connect();
					      
   
					        // 定义 BufferedReader输入流来读取URL的响应
					        in = new BufferedReader(new InputStreamReader(
					                connection.getInputStream()));
					        
					
					    } catch (Exception e) {
					     
					        e.printStackTrace();
					    }
					    // 使用finally块来关闭输入流
					    finally {
					        try {
					            if (in != null) {
					                
					            }
					        } catch (Exception e2) {
					            e2.printStackTrace();
					        }
					    }
					    return in;
					
				   
		
            	
            }

	
	}