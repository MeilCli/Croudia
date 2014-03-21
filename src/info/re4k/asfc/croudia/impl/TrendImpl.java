package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.Trend;
import info.re4k.asfc.croudia.json.JSONObject;

public class TrendImpl implements Trend{
	private String name,query;
	private boolean promoted_content;

	public TrendImpl(JSONObject obj){
		name = obj.isNull("name")?"":obj.getString("name");
		query = obj.isNull("query")?"":obj.getString("query");
		if(obj.isNull("promoted_content")==false){
			try{
				promoted_content = obj.getBoolean("promoted_content");
			}catch(Exception e){}
		}
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public String getQuery(){
		return query;
	}

	@Override
	public boolean isPromotedContent(){
		return promoted_content;
	}

}
