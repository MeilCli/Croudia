package info.re4k.asfc.croudia.param;

import info.re4k.asfc.croudia.http.HttpHelper;

public class StatusUpdateParam extends StatusParam{
	private long in_reply_to_status_id = -1;
	private String text;

	public StatusUpdateParam(String text){
		this.text = text;
	}

	public long getIn_reply_to_status_id(){
		return in_reply_to_status_id;
	}

	public void setIn_reply_to_status_id(long in_reply_to_status_id){
		this.in_reply_to_status_id = in_reply_to_status_id;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = super.toParam();
		if(in_reply_to_status_id!=-1){
			addAnd(sb);
			sb.append("in_reply_to_status_id=");
			sb.append(in_reply_to_status_id);
		}
		addAnd(sb);
		sb.append("status=");
		sb.append(HttpHelper.urlEncode(text));
		return sb;
	}

}
