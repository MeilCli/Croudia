package info.re4k.asfc.croudia;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import info.re4k.asfc.croudia.base64.Base64;
import info.re4k.asfc.croudia.http.HttpHelper;
import info.re4k.asfc.croudia.impl.FriendshipImpl;
import info.re4k.asfc.croudia.impl.SecretMailImpl;
import info.re4k.asfc.croudia.impl.StatusImpl;
import info.re4k.asfc.croudia.impl.UserImpl;
import info.re4k.asfc.croudia.json.JSONArray;
import info.re4k.asfc.croudia.json.JSONObject;

public class CroudiaHelper extends HttpHelper{

	public CroudiaHelper(CroudiaConfig config){
		super(config);
	}

	protected String makeState(){
		try{
			String keyText = String.valueOf(Math.random());
			String text = String.valueOf(System.currentTimeMillis());
			SecretKeySpec signingKey = new SecretKeySpec(keyText.getBytes(),"HmacSHA1");
			Mac mac = Mac.getInstance(signingKey.getAlgorithm());
			mac.init(signingKey);
			byte[] binary = mac.doFinal(text.getBytes());
			return HttpHelper.urlEncode(Base64.encodeBase64String(binary));
		}catch(Exception e){
			e.printStackTrace();
		}
		return String.valueOf(System.currentTimeMillis());
	}

	protected void makeKey(String res) throws CroudiaException{
		JSONObject obj = new JSONObject(res);
		String access_token = obj.getString("access_token");
		String token_type = obj.getString("token_type");
		String refresh_token = obj.getString("refresh_token");
		long expires_in = obj.getLong("expires_in");
		CroudiaAPIKey key = config.getAPIKey();
		key.setAccessToken(access_token);
		key.setTokenType(token_type);
		key.setRefreshToken(refresh_token);
		key.setExpiresIn((expires_in*1000)+System.currentTimeMillis());
		if(CroudiaConfig.isLog==true){
			System.out.println("access_token:"+access_token);
			System.out.println("refresh_token:"+refresh_token);
			System.out.println("token_type:"+token_type);
		}
	}

	protected void makeStatusList(ResponseList<Status,?> list,String res){
		JSONArray ar = new JSONArray(res);
		int size = ar.length();
		for(int i = 0;i<size;i++){
			JSONObject obj = ar.getJSONObject(i);
			list.add(new StatusImpl(obj));
		}
	}

	protected void makeSecretMailList(ResponseList<SecretMail,?> list,String res){
		JSONArray ar = new JSONArray(res);
		int size = ar.length();
		for(int i = 0;i<size;i++){
			JSONObject obj = ar.getJSONObject(i);
			list.add(new SecretMailImpl(obj));
		}
	}

	protected void makeUserList(ResponseList<User,?> list,String res){
		JSONArray ar = new JSONArray(res);
		int size = ar.length();
		for(int i = 0;i<size;i++){
			JSONObject obj = ar.getJSONObject(i);
			list.add(new UserImpl(obj));
		}
	}

	protected void makeFriendshipList(ResponseList<Friendship,?> list,String res){
		JSONArray ar = new JSONArray(res);
		int size = ar.length();
		for(int i = 0;i<size;i++){
			JSONObject obj = ar.getJSONObject(i);
			list.add(new FriendshipImpl(obj));
		}
	}
}
