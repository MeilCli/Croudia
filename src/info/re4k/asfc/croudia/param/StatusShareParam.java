package info.re4k.asfc.croudia.param;

import info.re4k.asfc.croudia.http.HttpHelper;

public class StatusShareParam extends StatusParam{
	private String text;
	private long id;

	public StatusShareParam(String text,long id){
		this.text = text;
		this.id = id;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = super.toParam();
		addAnd(sb);
		sb.append("status=");
		sb.append(HttpHelper.urlEncode(text));
		addAnd(sb);
		sb.append("id=");
		sb.append(id);
		return sb;
	}
}
