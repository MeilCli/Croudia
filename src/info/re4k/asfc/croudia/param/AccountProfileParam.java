package info.re4k.asfc.croudia.param;

import info.re4k.asfc.croudia.http.HttpHelper;

public class AccountProfileParam implements Param{
	private String name = null;
	private String url = null;
	private String location = null;
	private String description = null;

	public void setName(String name){
		this.name = name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public void setDescription(String description){
		this.description = description;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = new StringBuilder();
		if(name!=null){
			addAnd(sb);
			sb.append("name=");
			sb.append(HttpHelper.urlEncode(name));
		}
		if(url!=null){
			addAnd(sb);
			sb.append("url=");
			sb.append(HttpHelper.urlEncode(url));
		}
		if(location!=null){
			addAnd(sb);
			sb.append("location=");
			sb.append(HttpHelper.urlEncode(location));
		}
		if(description!=null){
			addAnd(sb);
			sb.append("description=");
			sb.append(HttpHelper.urlEncode(description));
		}
		return sb;
	}

	protected void addAnd(StringBuilder sb){
		if(sb.length()>0){
			sb.append('&');
		}
	}

}
