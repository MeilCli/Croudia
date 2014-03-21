package info.re4k.asfc.croudia.param;

import info.re4k.asfc.croudia.http.HttpHelper;

public class StatusQueryParam extends StatusPageParam{
	private String q;

	public StatusQueryParam(String q){
		this.q = q;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = super.toParam();
		addAnd(sb);
		sb.append("q=");
		sb.append(HttpHelper.urlEncode(q));
		return sb;
	}
}
