package info.re4k.asfc.croudia.param;

public class RelationshipParam implements Param{
	private long source_id = -1;
	private String source_screen_name = null;
	private long target_id = -1;
	private String target_screen_name = null;

	public RelationshipParam(long source_id,long target_id){
		this.source_id = source_id;
		this.target_id = target_id;
	}

	public RelationshipParam(String source_screen_name,String target_screen_name){
		this.source_screen_name = source_screen_name;
		this.target_screen_name = target_screen_name;
	}

	public RelationshipParam(long source_id,String target_screen_name){
		this.source_id = source_id;
		this.target_screen_name = target_screen_name;
	}

	public RelationshipParam(String source_screen_name,long target_id){
		this.source_screen_name = source_screen_name;
		this.target_id = target_id;
	}

	@Override
	public StringBuilder toParam(){
		StringBuilder sb = new StringBuilder();
		if(source_id!=-1){
			addAnd(sb);
			sb.append("source_id=");
			sb.append(source_id);
		}
		if(source_screen_name!=null){
			addAnd(sb);
			sb.append("source_screen_name=");
			sb.append(source_screen_name);
		}
		if(target_id!=-1){
			addAnd(sb);
			sb.append("target_id=");
			sb.append(target_id);
		}
		if(target_screen_name!=null){
			addAnd(sb);
			sb.append("target_screen_name=");
			sb.append(target_screen_name);
		}
		return sb;
	}

	protected void addAnd(StringBuilder sb){
		if(sb.length()>0){
			sb.append('&');
		}
	}
}
