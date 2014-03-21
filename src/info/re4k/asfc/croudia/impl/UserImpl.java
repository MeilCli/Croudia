package info.re4k.asfc.croudia.impl;

import java.util.Date;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.json.JSONObject;

public class UserImpl implements User{
	private long created_at,id;
	private int statuses_count,favorites_count,friends_count,followers_count;
	private boolean follow_request_sent,following,isprotected;
	private String name,screen_name,description,location,url,profile_image_url_https,cover_image_url_https;

	public UserImpl(String res){
		this(new JSONObject(res));
	}

	public UserImpl(JSONObject obj){
		created_at = obj.isNull("created_at")?System.currentTimeMillis():new Date(obj.getString("created_at")).getTime();
		statuses_count = obj.isNull("statuses_count")?0:obj.getInt("statuses_count");
		favorites_count = obj.isNull("favorites_count")?0:obj.getInt("favorites_count");
		friends_count = obj.isNull("friends_count")?0:obj.getInt("friends_count");
		followers_count = obj.isNull("followers_count")?0:obj.getInt("followers_count");
		follow_request_sent = obj.isNull("follow_request_sent")?false:obj.getBoolean("follow_request_sent");
		following = obj.isNull("following")?false:obj.getBoolean("following");
		isprotected = obj.isNull("protected")?false:obj.getBoolean("protected");
		id = obj.isNull("id")?0:obj.getLong("id");
		name = obj.isNull("name")?"":obj.getString("name");
		screen_name = obj.isNull("screen_name")?"":obj.getString("screen_name");
		description = obj.isNull("description")?null:obj.getString("description");
		location = obj.isNull("location")?null:obj.getString("location");
		url = obj.isNull("url")?null:obj.getString("url");
		profile_image_url_https = obj.isNull("profile_image_url_https")?"":obj.getString("profile_image_url_https");
		cover_image_url_https = obj.isNull("cover_image_url_https")?null:obj.getString("cover_image_url_https");
	}

	@Override
	public long getCreatedAt(){
		return created_at;
	}

	@Override
	public int getStatusesCount(){
		return statuses_count;
	}

	@Override
	public int getFavoritesCount(){
		return favorites_count;
	}

	@Override
	public int getFriendsCount(){
		return friends_count;
	}

	@Override
	public int getFollowersCount(){
		return followers_count;
	}

	@Override
	public boolean isFollowRequestSent(){
		return follow_request_sent;
	}

	@Override
	public boolean isFollowing(){
		return following;
	}

	@Override
	public boolean isProtected(){
		return isprotected;
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

	@Override
	public String getDescription(){
		return description;
	}

	@Override
	public String getLocation(){
		return location;
	}

	@Override
	public String getUrl(){
		return url;
	}

	@Override
	public String getProfileImageUrlHttps(){
		return profile_image_url_https;
	}

	@Override
	public String getCoverImageUrlHttps(){
		return cover_image_url_https;
	}

}
