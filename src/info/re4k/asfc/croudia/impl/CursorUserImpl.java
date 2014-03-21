package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.CursorUser;
import info.re4k.asfc.croudia.User;
import info.re4k.asfc.croudia.json.JSONArray;
import info.re4k.asfc.croudia.json.JSONObject;

public class CursorUserImpl implements CursorUser{
	private long next_cursor,previous_cursor;
	private User[] users;

	public CursorUserImpl(String res){
		JSONObject obj = new JSONObject(res);
		next_cursor = obj.isNull("next_cursor")?-1:obj.getLong("next_cursor");
		previous_cursor = obj.isNull("previous_cursor")?-1:obj.getLong("previous_cursor");
		if(obj.isNull("users")==false){
			JSONArray ar = obj.getJSONArray("users");
			int size = ar.length();
			users = new User[size];
			for(int i = 0;i<size;i++){
				users[i] = new UserImpl(ar.getJSONObject(i));
			}
		}else{
			users = new User[0];
		}
	}

	@Override
	public long getNextCursor(){
		return next_cursor;
	}

	@Override
	public long getPreviousCursor(){
		return previous_cursor;
	}

	@Override
	public User[] getUsers(){
		return users;
	}

}
