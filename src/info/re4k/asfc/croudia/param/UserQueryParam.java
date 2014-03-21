package info.re4k.asfc.croudia.param;

import info.re4k.asfc.croudia.http.HttpHelper;

public class UserQueryParam implements Param{

	private String q;
	private boolean trim_user = false;
	private int count = -1;
	private int page = -1;

	public UserQueryParam(String q){
		this.q = q;
	}

	public boolean isTrim_user(){
		return trim_user;
	}

	public void setTrim_user(boolean trim_user){
		this.trim_user = trim_user;
	}

	public int getCount(){
		return count;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getPage(){
		return page;
	}

	public void setPage(int page){
		this.page = page;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = new StringBuilder();
		addAnd(sb);
		sb.append("trim_user=");
		sb.append(trim_user);
		addAnd(sb);
		sb.append("page=");
		sb.append(page);
		if(count!=-1){
			addAnd(sb);
			sb.append("count=");
			sb.append(count);
		}
		addAnd(sb);
		sb.append("q=");
		sb.append(HttpHelper.urlEncode(q));
		return sb;
	}

	protected void addAnd(StringBuilder sb){
		if(sb.length()>0){
			sb.append('&');
		}
	}

}
