package info.re4k.asfc.croudia.param;

public class StatusParam implements Param{
	private boolean trim_user = false;
	private boolean include_entities = true;

	public boolean isTrim_user(){
		return trim_user;
	}

	public void setTrim_user(boolean trim_user){
		this.trim_user = trim_user;
	}

	public boolean isInclude_entities(){
		return include_entities;
	}

	public void setInclude_entities(boolean include_entities){
		this.include_entities = include_entities;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = new StringBuilder();
		addAnd(sb);
		sb.append("trim_user=");
		sb.append(trim_user);
		addAnd(sb);
		sb.append("include_entities=");
		sb.append(include_entities);
		return sb;
	}

	protected void addAnd(StringBuilder sb){
		if(sb.length()>0){
			sb.append('&');
		}
	}

}
