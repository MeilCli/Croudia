package info.re4k.asfc.croudia.param;

public class CursorUserParam extends UserParam{
	private long cursor = -1;

	public CursorUserParam(long user_id){
		super(user_id);
	}

	public CursorUserParam(String screen_name){
		super(screen_name);
	}

	public long getCursor(){
		return cursor;
	}

	public void setCursor(long cursor){
		this.cursor = cursor;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = super.toParam();
		addAnd(sb);
		sb.append("cursor=");
		sb.append(cursor);
		return sb;
	}

}
