package info.re4k.asfc.croudia.param;

public class StatusUserParam extends StatusPageParam{
	private long user_id = -1;
	private String screen_name = null;

	public long getUser_id(){
		return user_id;
	}

	public void setUser_id(long user_id){
		this.user_id = user_id;
	}

	public String getScreen_name(){
		return screen_name;
	}

	public void setScreen_name(String screen_name){
		this.screen_name = screen_name;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = super.toParam();
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
		return sb;
	}

}
