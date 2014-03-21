package info.re4k.asfc.croudia.param;

import info.re4k.asfc.croudia.http.HttpHelper;

public class UserMultiParam implements Param{
	private String user_id = null;
	private String screen_name = null;

	public UserMultiParam(long[] user_id){
		StringBuilder sb = new StringBuilder();
		for(long u:user_id){
			if(sb.length()>0){
				sb.append(',');
			}
			sb.append(u);
		}
		this.user_id = sb.toString();
	}

	public UserMultiParam(String[] screen_name){
		StringBuilder sb = new StringBuilder();
		for(String s:screen_name){
			if(sb.length()>0){
				sb.append(',');
			}
			sb.append(s);
		}
		this.user_id = sb.toString();
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = new StringBuilder();
		if(user_id!=null){
			addAnd(sb);
			sb.append("user_id=");
			sb.append(HttpHelper.urlEncode(user_id));
		}
		if(screen_name!=null){
			addAnd(sb);
			sb.append("screen_name=");
			sb.append(HttpHelper.urlEncode(screen_name));
		}
		return sb;
	}

	protected void addAnd(StringBuilder sb){
		if(sb.length()>0){
			sb.append('&');
		}
	}

}
