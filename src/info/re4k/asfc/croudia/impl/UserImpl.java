package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class UserImpl implements User{
	private long created_at,id;
	private int statuses_count,favorites_count,friends_count,followers_count;
	private boolean follow_request_sent,following,isprotected;
	private String name,screen_name,description,location,url,profile_image_url_https,cover_image_url_https;

	public UserImpl(String res){
		this(new JSONObject(res));
	}

	public UserImpl(JSONObject obj){
		created_at = getDate(obj,"created_at");
		statuses_count = getInt(obj,"statuses_count");
		favorites_count = getInt(obj,"favorites_count");
		friends_count = getInt(obj,"friends_count");
		followers_count = getInt(obj,"followers_count");
		follow_request_sent = getBoolean(obj,"follow_request_sent");
		following = getBoolean(obj,"following");
		isprotected = getBoolean(obj,"protected");
		id = getLong(obj,"id");
		name = getString(obj,"name");
		screen_name = getString(obj,"screen_name");
		description = getString(obj,"description");
		location = getString(obj,"location");
		url = getString(obj,"url");
		profile_image_url_https = getString(obj,"profile_image_url_https");
		cover_image_url_https = getString(obj,"cover_image_url_https");
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
