package info.re4k.asfc.croudia.param;

public class UserParam implements Param{
	private long user_id = -1;
	private String screen_name = null;

	public UserParam(long user_id){
		this.user_id = user_id;
	}

	public UserParam(String screen_name){
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
		return sb;
	}

	protected void addAnd(StringBuilder sb){
		if(sb.length()>0){
			sb.append('&');
		}
	}

}
