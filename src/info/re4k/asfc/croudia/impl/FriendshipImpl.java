package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.Friendship;
import info.re4k.asfc.croudia.json.JSONArray;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class FriendshipImpl implements Friendship{
	private boolean following,followedby;
	private long id;
	private String name,screen_name;

	public FriendshipImpl(JSONObject obj){
		if(obj.isNull("connections")==false){
			JSONArray ar = obj.getJSONArray("connections");
			int size = ar.length();
			for(int i = 0;i<size;i++){
				String s = ar.getString(i);
				if(s==null){
					continue;
				}
				if(s.equals("following")){
					following = true;
				}else if(s.equals("followed-by")){
					followedby = true;
				}
			}
		}
		id = getLong(obj,"id");
		name = getString(obj,"name");
		screen_name = getString(obj,"screen_name");
	}

	@Override
	public boolean isFollowing(){
		return following;
	}

	@Override
	public boolean isFollowedBy(){
		return followedby;
	}

	@Override
	public long getId(){
		return id;
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public String getScreenName(){
		return screen_name;
	}

}
