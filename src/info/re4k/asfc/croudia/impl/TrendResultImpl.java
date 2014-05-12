package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.Trend;
import info.re4k.asfc.croudia.TrendLocation;
import info.re4k.asfc.croudia.TrendResult;
import info.re4k.asfc.croudia.json.JSONArray;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class TrendResultImpl implements TrendResult{
	private long as_of,created_at;
	private TrendLocation locations;
	private Trend[] trends;

	public TrendResultImpl(String res){
		JSONObject obj = new JSONObject(res);
		as_of = getDate(obj,"as_of");
		created_at = getDate(obj,"created_at");
		if(obj.isNull("locations")==false){
			locations = new TrendLocationImpl(obj.getJSONObject("locations"));
		}
		if(obj.isNull("trends")==false){
			JSONArray ar = obj.getJSONArray("trends");
			int size = ar.length();
			trends = new Trend[size];
			for(int i = 0;i<size;i++){
				trends[i] = new TrendImpl(ar.getJSONObject(i));
			}
		}else{
			trends = new Trend[0];
		}
	}

	@Override
	public long getAsOf(){
		return as_of;
	}

	@Override
	public long getCreatedAt(){
		return created_at;
	}

	@Override
	public TrendLocation getLocation(){
		return locations;
	}

	@Override
	public Trend[] getTrends(){
		return trends;
	}

}
