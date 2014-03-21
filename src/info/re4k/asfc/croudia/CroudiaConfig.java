package info.re4k.asfc.croudia;

public class CroudiaConfig{
	public static boolean isLog = true;
	public static boolean isTest = true;
	private CroudiaAPIKey key;
	private boolean isGzipEnable = true;
	private int connectTimeOut = 10*1000;
	private int readTimeOut = 10*1000;
	private String authorizeURL = "https://api.croudia.com/oauth/authorize";
	private String accessTokenURL = "https://api.croudia.com/oauth/token";

	public CroudiaConfig(String consumerkey,String consumerSecret){
		this(new CroudiaAPIKey(consumerkey,consumerSecret));
	}

	public CroudiaConfig(CroudiaAPIKey key){
		this.key = key;
	}

	public CroudiaAPIKey getAPIKey(){
		return key;
	}

	public boolean isGzipEnable(){
		return isGzipEnable;
	}

	public void setGzipEnable(boolean isGzipEnable){
		this.isGzipEnable = isGzipEnable;
	}

	public int getConnectTimeOut(){
		return connectTimeOut;
	}

	public void setConnectTimeOut(int connectTimeOut){
		this.connectTimeOut = connectTimeOut;
	}

	public int getReadTimeOut(){
		return readTimeOut;
	}

	public void setReadTimeOut(int readTimeOut){
		this.readTimeOut = readTimeOut;
	}

	public String getAuthorizeURL(){
		return authorizeURL;
	}

	public void setAuthorizeURL(String authorizeURL){
		this.authorizeURL = authorizeURL;
	}

	public String getAccessTokenURL(){
		return accessTokenURL;
	}

	public void setAccessTokenURL(String accessTokenURL){
		this.accessTokenURL = accessTokenURL;
	}

}
