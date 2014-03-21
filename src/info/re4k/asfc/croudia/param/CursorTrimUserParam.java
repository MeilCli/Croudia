package info.re4k.asfc.croudia.param;

public class CursorTrimUserParam extends CursorUserParam{
	private boolean trim_user;

	public CursorTrimUserParam(long user_id){
		super(user_id);
	}

	public CursorTrimUserParam(String screen_name){
		super(screen_name);
	}

	public boolean isTrim_user(){
		return trim_user;
	}

	public void setTrim_user(boolean trim_user){
		this.trim_user = trim_user;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = super.toParam();
		addAnd(sb);
		sb.append("trim_user=");
		sb.append(trim_user);
		return sb;
	}

}
