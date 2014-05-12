package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.MediaEntity;
import info.re4k.asfc.croudia.Source;
import info.re4k.asfc.croudia.Status;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class StatusImpl implements Status{
	private long created_at,id,in_reply_to_status_id,in_reply_to_user_id;
	private boolean favorited,spread;
	private int spread_count,favorited_count;
	private String text,in_reply_to_screen_name;
	private Source source;
	private User user;
	private Status spread_status,reply_status;
	private MediaEntity media;

	public StatusImpl(String res){
		this(new JSONObject(res));
	}

	public StatusImpl(JSONObject obj){
		created_at = getDate(obj,"created_at");
		favorited = getBoolean(obj,"favorited");
		spread = getBoolean(obj,"spread");
		spread_count = getInt(obj,"spread_count");
		favorited_count = getInt(obj,"favorited_count");
		id = getLong(obj,"id");
		text = getString(obj,"text");
		if(obj.isNull("source")==false){
			source = new SourceImpl(obj.getJSONObject("source"));
		}
		if(obj.isNull("user")==false){
			user = new UserImpl(obj.getJSONObject("user"));
		}
		in_reply_to_screen_name = obj.isNull("in_reply_to_screen_name")?null:obj.getString("in_reply_to_screen_name");
		in_reply_to_status_id = getLong(obj,"in_reply_to_status_id");
		in_reply_to_user_id = getLong(obj,"in_reply_to_user_id");
		if(obj.isNull("spread_status")==false){
			spread_status = new StatusImpl(obj.getJSONObject("spread_status"));
		}
		if(obj.isNull("reply_status")==false){
			reply_status = new StatusImpl(obj.getJSONObject("reply_status"));
		}
		if(obj.isNull("entities")==false){
			if(obj.isNull("media")==false){
				media = new MediaEntityImpl(obj.getJSONObject("media"));
			}
		}
	}

	@Override
	public long getCreatedAt(){
		return created_at;
	}

	@Override
	public boolean isFavorited(){
		return favorited;
	}

	@Override
	public boolean isSpread(){
		return spread;
	}

	@Override
	public int getSpreadCount(){
		return spread_count;
	}

	@Override
	public int getFavoritedCount(){
		return favorited_count;
	}

	@Override
	public long getId(){
		return id;
	}

	@Override
	public String getText(){
		return text;
	}

	@Override
	public Source getSource(){
		return source;
	}

	@Override
	public User getUser(){
		return user;
	}

	@Override
	public String getInReplyToScreenName(){
		return in_reply_to_screen_name;
	}

	@Override
	public long getInReplyToStatusId(){
		return in_reply_to_status_id;
	}

	@Override
	public long getInReplyToUserId(){
		return in_reply_to_user_id;
	}

	@Override
	public Status getSpreadStatus(){
		return spread_status;
	}

	@Override
	public Status getReplyStatus(){
		return reply_status;
	}

	@Override
	public MediaEntity getMediaEntity(){
		return media;
	}

}
