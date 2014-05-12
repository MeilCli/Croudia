package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.MediaEntity;
import info.re4k.asfc.croudia.SecretMail;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.json.JSONObject;
import static info.re4k.asfc.croudia.util.JSONUtil.*;

public class SecretMailImpl implements SecretMail{
	private long created_at,id,recipient_id,sender_id;
	private String text,recipient_screen_name,sender_screen_name;
	private User recipient,sender;
	private MediaEntity media;

	public SecretMailImpl(String res){
		this(new JSONObject(res));
	}

	public SecretMailImpl(JSONObject obj){
		created_at = getDate(obj,"created_at");
		id = getLong(obj,"id");
		text = getString(obj,"text");
		if(obj.isNull("recipient")==false){
			recipient = new UserImpl(obj.getJSONObject("recipient"));
		}
		recipient_id = getLong(obj,"recipient_id");
		recipient_screen_name = getString(obj,"recipient_screen_name");
		if(obj.isNull("sender")==false){
			sender = new UserImpl(obj.getJSONObject("sender"));
		}
		sender_id = getLong(obj,"sender_id");
		sender_screen_name = getString(obj,"sender_screen_name");
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
	public long getId(){
		return id;
	}

	@Override
	public String getText(){
		return text;
	}

	@Override
	public User getRecipientUser(){
		return recipient;
	}

	@Override
	public long getRecipientId(){
		return recipient_id;
	}

	@Override
	public String getRecipientScreenName(){
		return recipient_screen_name;
	}

	@Override
	public User getSenderUser(){
		return sender;
	}

	@Override
	public long getSenderId(){
		return sender_id;
	}

	@Override
	public String getSenderScreenName(){
		return sender_screen_name;
	}

	@Override
	public MediaEntity getMediaEntity(){
		return media;
	}

}
