package info.re4k.asfc.croudia.util;

import java.util.Date;
import info.re4k.asfc.croudia.CroudiaConfig;
import info.re4k.asfc.croudia.json.JSONException;
import info.re4k.asfc.croudia.json.JSONObject;

public class JSONUtil{
	public static String getString(JSONObject obj,String key){
		if(obj.isNull(key)==true){
			return "";
		}
		return obj.getString(key);
	}

	public static boolean getBoolean(JSONObject obj,String key){
		if(obj.isNull(key)==true){
			return false;
		}
		try{
			return obj.getBoolean(key);
		}catch(JSONException e){
			if(obj.getString(key).equals("underdevelopment")){
				if(CroudiaConfig.isLog==true){
					System.out.print(key);
					System.out.println(":underdevelopment");
				}
				return false;
			}else{
				throw e;
			}
		}
	}

	public static long getLong(JSONObject obj,String key){
		if(obj.isNull(key)==true){
			return 0;
		}
		try{
			return obj.getLong(key);
		}catch(JSONException e){
			if(obj.getString(key).equals("underdevelopment")){
				if(CroudiaConfig.isLog==true){
					System.out.print(key);
					System.out.println(":underdevelopment");
				}
				return 0;
			}else{
				throw e;
			}
		}
	}

	public static int getInt(JSONObject obj,String key){
		if(obj.isNull(key)==true){
			return 0;
		}
		try{
			return obj.getInt(key);
		}catch(JSONException e){
			if(obj.getString(key).equals("underdevelopment")){
				if(CroudiaConfig.isLog==true){
					System.out.print(key);
					System.out.println(":underdevelopment");
				}
				return 0;
			}else{
				throw e;
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static long getDate(JSONObject obj,String key){
		if(obj.isNull(key)==true){
			return System.currentTimeMillis();
		}
		try{
			return new Date(obj.getString(key)).getTime();
		}catch(JSONException e){
			if(obj.getString(key).equals("underdevelopment")){
				if(CroudiaConfig.isLog==true){
					System.out.print(key);
					System.out.println(":underdevelopment");
				}
				return System.currentTimeMillis();
			}else{
				throw e;
			}
		}
	}
}
