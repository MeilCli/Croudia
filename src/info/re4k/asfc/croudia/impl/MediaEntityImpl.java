package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.MediaEntity;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class MediaEntityImpl implements MediaEntity{
	private String media_url_https,type;

	public MediaEntityImpl(JSONObject obj){
		media_url_https = getString(obj,"media_url_https");
		type = getString(obj,"type");
	}

	@Override
	public String getMediaUrlHttps(){
		return media_url_https;
	}

	@Override
	public String getType(){
		return type;
	}

}
