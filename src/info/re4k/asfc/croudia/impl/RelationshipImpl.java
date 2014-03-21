package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.Relationship;
import info.re4k.asfc.croudia.json.JSONObject;

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
				source_blocking = sobj.isNull("blocking")?false:sobj.getBoolean("blocking");
				source_followed_by = sobj.isNull("followed_by")?false:sobj.getBoolean("followed_by");
				source_following = sobj.isNull("following")?false:sobj.getBoolean("following");
				source_id = sobj.isNull("id")?0:sobj.getLong("id");
				source_screen_name = sobj.isNull("screen_name")?"":sobj.getString("screen_name");
			}
			if(obj.isNull("target")==false){
				JSONObject tobj = obj.getJSONObject("target");
				target_followed_by = tobj.isNull("followed_by")?false:tobj.getBoolean("followed_by");
				target_following = tobj.isNull("following")?false:tobj.getBoolean("following");
				target_id = tobj.isNull("id")?0:tobj.getLong("id");
				target_screen_name = tobj.isNull("screen_name")?"":tobj.getString("screen_name");
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
