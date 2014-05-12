package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.Relationship;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class RelationshipImpl implements Relationship{

	private boolean source_blocking,source_followed_by,source_following,target_followed_by,target_following;
	private long source_id,target_id;
	private String source_screen_name,target_screen_name;

	public RelationshipImpl(String res){
		JSONObject pobj = new JSONObject(res);
		if(pobj.isNull("relationship")==false){
			JSONObject obj = pobj.getJSONObject("relationship");
			if(obj.isNull("source")==false){
				JSONObject sobj = obj.getJSONObject("source");
				source_blocking = getBoolean(sobj,"blocking");
				source_followed_by = getBoolean(sobj,"followed_by");
				source_following = getBoolean(sobj,"following");
				source_id = getLong(sobj,"id");
				source_screen_name = getString(sobj,"screen_name");
			}
			if(obj.isNull("target")==false){
				JSONObject tobj = obj.getJSONObject("target");
				target_followed_by = getBoolean(tobj,"followed_by");
				target_following = getBoolean(tobj,"following");
				target_id = getLong(tobj,"id");
				target_screen_name = getString(tobj,"screen_name");
			}
		}
	}

	@Override
	public boolean isSourceBlocking(){
		return source_blocking;
	}

	@Override
	public boolean isSourceFollowedBy(){
		return source_followed_by;
	}

	@Override
	public boolean isSourceFollowing(){
		return source_following;
	}

	@Override
	public long getSourceId(){
		return source_id;
	}

	@Override
	public String getSourceScreenName(){
		return source_screen_name;
	}

	@Override
	public boolean isTargetFollowedBy(){
		return target_followed_by;
	}

	@Override
	public boolean isTargetFollowing(){
		return target_following;
	}

	@Override
	public long getTargetId(){
		return target_id;
	}

	@Override
	public String getTargetScreenName(){
		return target_screen_name;
	}

}
