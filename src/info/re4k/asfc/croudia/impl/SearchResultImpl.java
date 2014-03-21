package info.re4k.asfc.croudia.impl;

import info.re4k.asfc.croudia.SearchResult;
import info.re4k.asfc.croudia.Status;
import info.re4k.asfc.croudia.json.JSONArray;
import info.re4k.asfc.croudia.json.JSONObject;

public class SearchResultImpl implements SearchResult{
	private int completed_in,count;
	private long max_id,since_id;
	private String next_results,query,refresh_url;
	private Status[] statuses;

	public SearchResultImpl(String res){
		JSONObject pobj = new JSONObject(res);
		if(pobj.isNull("search_meta")==false){
			JSONObject obj = pobj.getJSONObject("search_meta");
			completed_in = obj.isNull("completed_in")?0:obj.getInt("completed_in");
			max_id = obj.isNull("max_id")?0:obj.getLong("max_id");
			since_id = obj.isNull("since_id")?0:obj.getLong("since_id");
			count = obj.isNull("count")?0:obj.getInt("count");
			next_results = obj.isNull("next_results")?"":obj.getString("next_results");
			query = obj.isNull("query")?"":obj.getString("query");
			refresh_url = obj.isNull("refresh_url")?"":obj.getString("refresh_url");
		}
		if(pobj.isNull("statuses")==false){
			JSONArray ar = pobj.getJSONArray("statuses");
			int size = ar.length();
			statuses = new Status[size];
			for(int i = 0;i<size;i++){
				statuses[i] = new StatusImpl(ar.getJSONObject(i));
			}
		}else{
			statuses = new Status[0];
		}
	}

	@Override
	public int getCompletedIn(){
		return completed_in;
	}

	@Override
	public long getMaxId(){
		return max_id;
	}

	@Override
	public long getSinceId(){
		return since_id;
	}

	@Override
	public int getCount(){
		return count;
	}

	@Override
	public String getNextResults(){
		return next_results;
	}

	@Override
	public String getQuery(){
		return query;
	}

	@Override
	public String getRefreshUrl(){
		return refresh_url;
	}

	@Override
	public Status[] getTweet(){
		return statuses;
	}

}
