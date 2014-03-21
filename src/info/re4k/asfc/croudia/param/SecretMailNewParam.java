package info.re4k.asfc.croudia.param;

import info.re4k.asfc.croudia.http.HttpHelper;

public class SecretMailNewParam implements Param{
	private long user_id = -1;
	private String text;
	private String screen_name = null;

	public SecretMailNewParam(String text,long user_id){
		this.text = text;
		this.user_id = user_id;
	}

	public SecretMailNewParam(String text,String screen_name){
		this.text = text;
		this.screen_name = screen_name;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = new StringBuilder();
		if(user_id!=-1){
			addAnd(sb);
			sb.append("user_id=");
			sb.append(user_id);
		}
		if(screen_name!=null){
			addAnd(sb);
			sb.append("screen_name=");
			sb.append(screen_name);
		}
		addAnd(sb);
		sb.append("text=");
		sb.append(HttpHelper.urlEncode(text));
		return sb;
	}

	protected void addAnd(StringBuilder sb){
		if(sb.length()>0){
			sb.append('&');
		}
	}

}
