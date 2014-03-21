package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.Source;
import info.re4k.asfc.croudia.json.JSONObject;

public class SourceImpl implements Source{
	private String name,url;

	public SourceImpl(JSONObject obj){
		name = obj.isNull("name")?null:obj.getString("name");
		url = obj.isNull("url")?null:obj.getString("url");
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public String getURL(){
		return url;
	}

}
