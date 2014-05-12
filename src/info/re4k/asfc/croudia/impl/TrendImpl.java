package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.Trend;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class TrendImpl implements Trend{
	private String name,query;
	private boolean promoted_content;

	public TrendImpl(JSONObject obj){
		name = getString(obj,"name");
		query = getString(obj,"query");
		promoted_content = getBoolean(obj,"promoted_content");
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
