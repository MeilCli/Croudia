package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.CursorId;
import info.re4k.asfc.croudia.json.JSONArray;
import info.re4k.asfc.croudia.json.JSONObject;

public class CursorIdImpl implements CursorId{
	private long next_cursor,previous_cursor;
	private long[] ids;

	public CursorIdImpl(String res){
		JSONObject obj = new JSONObject(res);
		next_cursor = obj.isNull("next_cursor")?-1:obj.getLong("next_cursor");
		previous_cursor = obj.isNull("previous_cursor")?-1:obj.getLong("previous_cursor");
		if(obj.isNull("ids")==false){
			JSONArray ar = obj.getJSONArray("ids");
			int size = ar.length();
			ids = new long[size];
			for(int i = 0;i<size;i++){
				ids[i] = ar.getLong(i);
			}
		}else{
			ids = new long[0];
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
	public long[] getIds(){
		return ids;
	}

}
