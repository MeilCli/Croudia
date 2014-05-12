package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.TrendLocation;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class TrendLocationImpl implements TrendLocation{
	private String name;
	private int woeid;

	public TrendLocationImpl(JSONObject obj){
		name = getString(obj,"name");
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
