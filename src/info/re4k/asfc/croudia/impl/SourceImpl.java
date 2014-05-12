package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.Source;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class SourceImpl implements Source{
	private String name,url;

	public SourceImpl(JSONObject obj){
		name = getString(obj,"name");
		url = getString(obj,"url");
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
