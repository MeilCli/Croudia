package info.re4k.asfc.croudia.impl;

import java.util.Date;
import info.re4k.asfc.croudia.SecretMail;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.json.JSONObject;

public class SecretMailImpl implements SecretMail{
	private long created_at,id,recipient_id,sender_id;
	private String text,recipient_screen_name,sender_screen_name;
	private User recipient,sender;

	public SecretMailImpl(String res){
		this(new JSONObject(res));
	}

	public SecretMailImpl(JSONObject obj){
		created_at = obj.isNull("created_at")?System.currentTimeMillis():new Date(obj.getString("created_at")).getTime();
		id = obj.isNull("id")?0:obj.getLong("id");
		text = obj.isNull("text")?"":obj.getString("text");
		if(obj.isNull("recipient")==false){
			recipient = new UserImpl(obj.getJSONObject("recipient"));
		}
		recipient_id = obj.isNull("recipient_id")?0:obj.getLong("recipient_id");
		recipient_screen_name = obj.isNull("recipient_screen_name")?"":obj.getString("recipient_screen_name");
		if(obj.isNull("sender")==false){
			sender = new UserImpl(obj.getJSONObject("sender"));
		}
		sender_id = obj.isNull("sender_id")?0:obj.getLong("sender_id");
		sender_screen_name = obj.isNull("sender_screen_name")?"":obj.getString("sender_screen_name");
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

}
