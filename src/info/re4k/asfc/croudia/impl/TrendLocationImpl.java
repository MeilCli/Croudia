package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.TrendLocation;
import info.re4k.asfc.croudia.json.JSONObject;

public class TrendLocationImpl implements TrendLocation{
	private String name;
	private int woeid;

	public TrendLocationImpl(JSONObject obj){
		name = obj.isNull("name")?"":obj.getString("name");
		woeid = obj.isNull("woeid")?1:obj.getInt("woeid");
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public int getWoeid(){
		return woeid;
	}

}
