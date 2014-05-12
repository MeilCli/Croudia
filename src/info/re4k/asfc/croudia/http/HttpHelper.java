package info.re4k.asfc.croudia.http;

import info.re4k.asfc.croudia.CroudiaConfig;
import info.re4k.asfc.croudia.CroudiaException;
import info.re4k.asfc.croudia.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class HttpHelper{
	protected CroudiaConfig config;

	public HttpHelper(CroudiaConfig config){
		this.config = config;
	}

	protected String get(String url) throws CroudiaException{
		return getRooper(url,"GET",null,true);
	}

	protected String post(String url,String post,boolean isAuthorization) throws CroudiaException{
		// 長さ0だったらnullにしておく
		post = post==null?null:post.length()==0?null:post;
		return getRooper(url,"POST",post,isAuthorization);
	}

	protected String getRooper(String url,String method,String post,boolean isAuthorization) throws CroudiaException{
		return get(url,method,post,isAuthorization);
	}

	private String get(String url,String method,String post,boolean isAuthorization) throws CroudiaException{
		HttpURLConnection http = null;
		try{
			http = (HttpURLConnection)new URL(url).openConnection();
		}catch(Exception e){
			e.printStackTrace();
			throw new CroudiaException(e.getMessage());
		}
		try{
			http.setRequestMethod(method);
		}catch(Exception e){
			e.printStackTrace();
			throw new CroudiaException(e.getMessage());
		}
		http.setConnectTimeout(config.getConnectTimeOut());
		http.setReadTimeout(config.getReadTimeOut());
		if(config.isGzipEnable()==true){
			http.setRequestProperty("Accept-Encoding","gzip,deflate");
		}
		if(isAuthorization==true){
			http.setRequestProperty("Authorization",config.getAPIKey().getTokenType()+" "+config.getAPIKey().getAccessToken());
		}
		if(post!=null){
			http.setDoOutput(true);
			http.setRequestProperty("Content-Length",String.valueOf(post.length()));
			PrintStream ps = null;
			try{
				ps = new PrintStream(http.getOutputStream());
				ps.print(post);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(ps!=null){
					ps.close();
				}
			}
		}
		return getString(http);
	}

	private String getString(HttpURLConnection http) throws CroudiaException{
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		int responseCode;
		try{
			http.connect();
			responseCode = http.getResponseCode();
			if(responseCode!=HttpResponseCode.Http_Success&&responseCode!=HttpResponseCode.Http_Bad_Request){
				throw new CroudiaException(http.getResponseMessage(),responseCode);
			}
			logHeader(http);
			InputStream is;
			if(responseCode==HttpResponseCode.Http_Success){
				is = http.getInputStream();
			}else{
				is = http.getErrorStream();
			}
			if(http.getContentEncoding()!=null&&http.getContentEncoding().equals("gzip")){
				reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(is)));
			}else{
				reader = new BufferedReader(new InputStreamReader(is));
			}
			String line = null;
			while(true){
				line = reader.readLine();
				if(line==null){
					sb.deleteCharAt(sb.length()-1);
					break;
				}
				sb.append(line).append('\n');
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new CroudiaException(e.getMessage());
		}finally{
			http.disconnect();
			if(reader!=null){
				try{
					reader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		String res = sb.toString();
		if(CroudiaConfig.isLog==true){
			System.out.println(res);
		}
		if(responseCode==HttpResponseCode.Http_Bad_Request){
			JSONObject obj = new JSONObject(res);
			String errorResponseMessage;
			if(obj.isNull("error")==true){
				errorResponseMessage = "not knowing error";
			}else{
				errorResponseMessage = obj.getString("error");
			}
			throw new CroudiaException("bad request",responseCode,errorResponseMessage);
		}
		return res;
	}

	public static String urlEncode(String string){
		try{
			return URLEncoder.encode(string,"UTF-8");
		}catch(UnsupportedEncodingException e){
			return string;
		}
	}

	private void logHeader(HttpURLConnection http){
		if(CroudiaConfig.isLog==true){
			Map<String,List<String>> headers = http.getHeaderFields();
			Iterator<String> headerIt = headers.keySet().iterator();
			String header = null;
			while(headerIt.hasNext()){
				String headerKey = (String)headerIt.next();
				header += headerKey+"："+headers.get(headerKey)+"\r\n";
			}
			System.out.println(header);
		}
	}
}
