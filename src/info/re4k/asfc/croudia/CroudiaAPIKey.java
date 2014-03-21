package info.re4k.asfc.croudia;

public class CroudiaAPIKey{
	private String consumerkey;
	private String consumerSecret;
	private String accessToken;
	private String refreshToken;
	private String tokenType;
	private long expiresIn;

	CroudiaAPIKey(String consumerkey,String consumerSecret){
		this.consumerkey = consumerkey;
		this.consumerSecret = consumerSecret;
	}

	public CroudiaAPIKey(String consumerkey,String consumerSecret,String accessToken,String refreshToken){
		this(consumerkey,consumerSecret,accessToken,refreshToken,"Bearer",0);
	}

	public CroudiaAPIKey(String consumerkey,String consumerSecret,String accessToken,String refreshToken,String tokenType){
		this(consumerkey,consumerSecret,accessToken,refreshToken,tokenType,0);
	}

	public CroudiaAPIKey(String consumerkey,String consumerSecret,String accessToken,String refreshToken,String tokenType,long expiresIn){
		this.consumerkey = consumerkey;
		this.consumerSecret = consumerSecret;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.tokenType = tokenType;
		this.expiresIn = expiresIn;
	}

	public String getConsumerkey(){
		return consumerkey;
	}

	public void setConsumerkey(String consumerkey){
		this.consumerkey = consumerkey;
	}

	public String getConsumerSecret(){
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret){
		this.consumerSecret = consumerSecret;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getRefreshToken(){
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken){
		this.refreshToken = refreshToken;
	}

	public String getTokenType(){
		return tokenType;
	}

	public void setTokenType(String tokenType){
		this.tokenType = tokenType;
	}

	/**
	 * @return ミリ秒、絶対時間
	 */
	public long getExpiresIn(){
		return expiresIn;
	}

	/**
	 * @param expiresIn ミリ秒、絶対時間
	 */
	public void setExpiresIn(long expiresIn){
		this.expiresIn = expiresIn;
	}
}
